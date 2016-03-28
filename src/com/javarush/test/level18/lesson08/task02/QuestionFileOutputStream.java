package com.javarush.test.level18.lesson08.task02;

import java.io.*;

/* Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
2. Считайте строку
3. Если считанная строка равна [Д], то закрыть поток
4. Если считанная строка не равна [Д], то не закрывать поток
*/

public class QuestionFileOutputStream implements AmigoOutputStream  //1 Создать свой класс обертку и наследоваться от того же класса что и оборачиваемый класс
{
    private AmigoOutputStream amigoOutputStream;  //оборачиваемый объект, именно у него мы расширяем функциональность

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) //2. передать оборачиваемый объект в конструктор нашего класса
    {
        this.amigoOutputStream = amigoOutputStream;
    }

    @Override                             // 3. переопределить все методы в нашем новом классе и вызвать в нем методы оборачиваемого класса
    public void flush() throws IOException
    {
        amigoOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException
    {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        amigoOutputStream.write(b, off , len);
    }

    @Override                                             //4/ Внести свои изменения "по вкусу"
    public void close() throws IOException
    {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("Д")) amigoOutputStream.close();
        else if(!s.equals("Д")) ;
    }
}

