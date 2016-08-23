package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/*
 Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь
его. Его реализация с учетом уже созданных методов выглядит очень просто. Давай
напишем ее:
17.1.	Запроси адрес и порт сервера с помощью методов getServerAddress() и
getServerPort().
17.2.	Создай новый объект класса java.net.Socket, используя данные, полученные в
п.17.1.
17.3.	Создай объект класса Connection, используя сокет из п.17.2.
17.4.	Вызови метод, реализующий "рукопожатие" клиента с сервером
(clientHandshake()).
17.5.	Вызови метод, реализующий основной цикл обработки сообщений сервера.
17.6.	При возникновении исключений IOException или ClassNotFoundException
сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false
в качестве параметра.
Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.

*/
public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {

        @Override
        public void run() {
            String adressServera = getServerAddress();
            int portServera = getServerPort();
            try {
                Socket socket = new Socket(adressServera, portServera);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        /*Этот метод будет представлять клиента серверу. */
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                /*16.1.1.	В цикле получать сообщения, используя соединение connection*/
                Message message = connection.receive();

                switch (message.getType()) {

                    // 	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя)
                    case NAME_REQUEST: {

                        // запросить ввод имени пользователя с помощью метода getUserName()
                        // создать новое сообщение с типом USER_NAME и введенным именем, отправить сообщение серверу.
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    }

                    // Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя)
                    case NAME_ACCEPTED: {

                        // значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
                        // Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
                        notifyConnectionStatusChanged(true);
                        return;
                    }

                    default: {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        /*Этот метод будет реализовывать главный цикл обработки сообщений сервера. */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            while (true) {
            /*16.2.1.	Получи сообщение от сервера, используя соединение connection.*/
                Message message = connection.receive();

                switch (message.getType()) {
                    /*16.2.2.	Если это текстовое сообщение (тип TEXT),*/
                    case TEXT: {
                        processIncomingMessage(message.getData());
                        break;
                    }
                    /*16.2.3.	Если это сообщение с типом USER_ADDED,*/
                    case USER_ADDED: {
                        informAboutAddingNewUser(message.getData());
                        break;
                    }

                    /*16.2.4.	Если это сообщение с типом USER_REMOVED,*/
                    case USER_REMOVED: {
                        informAboutDeletingNewUser(message.getData());
                        break;
                    }

                    /*16.2.5.	Если клиент получил сообщение какого-либо другого типа, кинь исключение IOException("Unexpected MessageType").*/
                    default: {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        /*должен выводить текст message в консоль*/
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        /*должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату*/
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату");
        }

        /*должен выводить в консоль, что участник с именем userName покинул чат*/
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            /*15.4.1.	Устанавливать значение поля clientConnected класса Client в соответствии с переданным параметром.*/
            Client.this.clientConnected = clientConnected;

            /*15.4.2.	Оповещать (пробуждать ожидающий) основной поток класса Client. */
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }

    public void run() {
        // 14.1.1.	Создавать новый сокетный поток с помощью метода getSocketThread.
        SocketThread socketThread = getSocketThread();

        //14.1.2.	Помечать созданный поток как daemon
        socketThread.setDaemon(true);

        // 14.1.3.	Запустить вспомогательный поток.
        socketThread.start();

        // 14.1.4.	Заставить текущий поток ожидать, пока он не получит нотификацию из другогопотока.
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка");
            return;
        }

        // 14.1.5.	После того, как поток дождался нотификации, проверь значение clientConnected.
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
// 14.1.6.	Считывай сообщения с консоли пока клиент подключен.
            while (clientConnected) {
                String message;
                // Если будет введена команда 'exit', то выйди из цикла.
                if (!(message = ConsoleHelper.readString()).equals("exit")) {
                    // 14.1.7.	После каждого считывания, если метод shouldSentTextFromConsole() возвращает true, отправь считанный текст с помощью метода  sendTextMessage().
                    if (shouldSentTextFromConsole()) {
                        sendTextMessage(message);
                    }
                } else {
                    return;
                }
            }
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
    }


    /*должен запросить ввод адреса сервера у пользователя и вернуть введенное значение. */
    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адреса сервера: ");
        String adressServera = ConsoleHelper.readString();
        return adressServera;
    }

    /*должен запрашивать ввод порта сервера и возвращать его*/
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int portServera = ConsoleHelper.readInt();
        return portServera;
    }

    /*должен запрашивать и возвращать имя пользователя.*/
    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        String nameUser = ConsoleHelper.readString();
        return nameUser;
    }

    /*Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный от нашего, который не должен отправлять введенный в консоль текст.*/
    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    /*должен создавать и возвращать новый объект класса SocketThread.*/
    protected SocketThread getSocketThread() {
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }

    /*создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection.*/
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки");
            clientConnected = false;
        }
    }
}
