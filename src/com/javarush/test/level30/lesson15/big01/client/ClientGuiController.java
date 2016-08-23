package com.javarush.test.level30.lesson15.big01.client;
/*
Осталось написать компонент контроллер (Controller):
21.1.	Создай класс ClientGuiController унаследованный от Client.
21.2.	Создай и проинициализируй поле, отвечающее за модель ClientGuiModel model.
21.3.	Создай и проинициализируй поле, отвечающее за представление ClientGuiView view.
Подумай, что нужно передать в конструктор при инициализации объекта.
21.4.	Добавь внутренний класс GuiSocketThread унаследованный от SocketThread.
Класс GuiSocketThread должен быть публичным. В нем переопредели следующие
методы:
21.4.1.	void processIncomingMessage(String message) –
должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
21.4.2.	void informAboutAddingNewUser(String userName) –
должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
21.4.3.	void informAboutDeletingNewUser(String userName) –
должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
21.4.4.	void notifyConnectionStatusChanged(boolean clientConnected) –
должен вызывать аналогичный метод у представления.
21.5.	Переопредели методы в классе ClientGuiController:
21.5.1.	SocketThread getSocketThread() – должен создавать и возвращать объект типа
GuiSocketThread.
21.5.2.	void run() – должен получать объект SocketThread через метод getSocketThread()
и вызывать у него метод run(). Разберись, почему нет необходимости вызывать
метод run в отдельном потоке, как мы это делали для консольного клиента.
21.5.3.	getServerAddress(), getServerPort(),getUserName(). Они должны вызывать
одноименные методы из представления (view).
21.6.	Объяви метод ClientGuiModel getModel(), который должен возвращать модель.
21.7.	Объяви метод main(), который должен создавать новый объект
ClientGuiController и вызывать у него метод run().
Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
все работает корректно.
*/
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        GuiSocketThread guiSocketThread = new GuiSocketThread();
        return  guiSocketThread;
    }

    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    @Override
    protected String getServerAddress() {
        String adress  = view.getServerAddress();
        return adress;
    }

    @Override
    protected int getServerPort() {
        int port = view.getServerPort();
        return port;
    }

    @Override
    protected String getUserName() {
        String userName = view.getUserName();
        return userName;
    }

    public ClientGuiModel getModel(){
        return model;
    }


    public class GuiSocketThread extends SocketThread{
        /*должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.*/
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        /*должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.*/
        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        /*должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.*/
        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        /*должен вызывать аналогичный метод у представления.*/
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
