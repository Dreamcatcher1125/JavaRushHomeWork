package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
Пришло время написать главный метод класса Handler, который будет вызывать все
вспомогательные методы, написанные ранее. Добавим метод void run() в класс Handler.
Он должен:
11.1.	Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress
11.2.	Создавать Connection, используя поле Socket
11.3.	Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
11.4.	Рассылать всем участникам чата информацию об имени присоединившегося частника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для этого лучше всего.
11.5.	Сообщать новому участнику о существующих участниках
11.6.	Запускать главный цикл обработки сообщений сервером
11.7.	Обеспечить закрытие соединения при возникновении исключения
11.8.	Отловить все исключения типа IOException и ClassNotFoundException, вывести в
консоль информацию, что произошла ошибка при обмене данными с удаленным
адресом
11.9.	После того как все исключения обработаны, если п.11.3 отработал и возвратил
нам имя, мы должны удалить запись для этого имени из connectionMap и разослать
всем остальным участникам сообщение с типом USER_REMOVED и сохраненным
именем.
11.10.	Последнее, что нужно сделать в методе run() – вывести сообщение,
информирующее что соединение с удаленным адресом закрыто.
Наш сервер полностью готов. Попробуй его запустить.
*/
public class Server { // основной класс сервера

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>(); // ключ - имя клиента, а значением - соединение с ним.

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера: ");

        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            ConsoleHelper.writeMessage("Сервер запущен!");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка сокета");
        }
    }

    public static void sendBroadcastMessage(Message message) {  // сервер посылает всем Клиентам сообщения
        try {
            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleHelper.writeMessage("Сообщение не отправлено");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                // Сформировать и отправить команду запроса имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));
                // Получить ответ клиента
                Message message = connection.receive();

                // Проверить, что получена команда с именем пользователя
                if (message.getType() == MessageType.USER_NAME) {

                    //Достать из ответа имя, проверить, что оно не пустое
                    if (message.getData() != null && !message.getData().isEmpty()) {

                        // и пользователь с таким именем еще не подключен (используй connectionMap)
                        if (connectionMap.get(message.getData()) == null) {

                            // Добавить нового пользователя и соединение с ним в connectionMap
                            connectionMap.put(message.getData(), connection);
                            // Отправить клиенту команду информирующую, что его имя принято
                            connection.send(new Message(MessageType.NAME_ACCEPTED));

                            // Вернуть принятое имя в качестве возвращаемого значения
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            // 9.2.	 Пройтись по connectionMap
            for (String key : connectionMap.keySet()) {
                // 9.3.	 У каждого элемента из п.9.2 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем
                Message message = new Message(MessageType.USER_ADDED, key);

                // 9.5.	 Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе
                if (!key.equals(userName)){
                    //9.4.	 Отправить сформированную команду через connection
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                // 10.1.	 Принимать сообщение клиента
                Message message = connection.receive();
                // 10.2.	 Если принятое сообщение – это текст (тип TEXT)
                if (message.getType() == MessageType.TEXT){
                // то формировать новое текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и текста сообщения.
                    String s = userName + ": " + message.getData();
                    Message chatText = new Message(MessageType.TEXT, s);
                    // 10.3.	 Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage.
                    sendBroadcastMessage(chatText);
                } else { // 10.4.	 Если принятое сообщение не является текстом, вывести сообщение об ошибке
                    ConsoleHelper.writeMessage("Error, message not text");
                }
            }
        }

        @Override
        public void run() {
            // 11.1.	Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress
            ConsoleHelper.writeMessage("Установлено новое соединение с " + socket.getRemoteSocketAddress());
            // 11.2.	Создавать Connection, используя поле Socket
            try {
                Connection connection = new Connection(socket);

                //11.3.	Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                String clientName = serverHandshake(connection);

                // 11.4.	Рассылать всем участникам чата информацию об имени присоединившегося частника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для этого лучше всего.
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            }
        }




    }
}

