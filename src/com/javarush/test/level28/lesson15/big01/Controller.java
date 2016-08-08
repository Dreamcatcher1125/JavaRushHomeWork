package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;

import java.util.Arrays;

/*
1. Создай класс Controller, в нем будет содержаться бизнес логика.
2. В Controller добавь паблик конструктор, который будет принимать столько провайдеров, сколько в него передадут для обработки
Сохрани их в приватное поле providers.
Помнишь, как это делать? Нужно нажать на аргументе конструктора Alt+Enter, выбрать Create Field for Parameter 'providers'
3. Если провайдеры не переданы в конструктор контроллера, то брось IllegalArgumentException.
4. Создай метод toString в классе Controller (Alt+Insert -> toString()) со стандартной реализацией (должен выводить поле providers)
*/
public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if(providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
