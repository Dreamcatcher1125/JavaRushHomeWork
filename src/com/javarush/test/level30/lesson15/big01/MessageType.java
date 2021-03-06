package com.javarush.test.level30.lesson15.big01;

public enum MessageType { // enum, который отвечает за тип сообщений пересылаемых между клиентом и сервером
    NAME_REQUEST,   // запрос имени
    USER_NAME,      // имя пользователя
    NAME_ACCEPTED,  // имя принято
    TEXT,           // текстовое сообщение
    USER_ADDED,     // пользователь добавлен
    USER_REMOVED;   // пользователь удален
}
