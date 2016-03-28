package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = File.createTempFile("D:/1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            user1.setFirstName("Иван");
//            user1.setLastName("Иванов");
            user1.setBirthDate(dateFormat.parse("21.01.2000"));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user2 = new User();
            user2.setFirstName(null);
            user2.setLastName("Лариса");
            user2.setBirthDate(dateFormat.parse("11.12.1999"));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            for (User user : users)
            {
                printWriter.println("@"); //записываем newUser в новую строку

                String firstName = user.getFirstName();
                if (firstName == null)
                {
                    firstName = "noName";
                }
                printWriter.println(firstName); //записываем имя в новую строку

                String lastName = user.getLastName();
                if (lastName == null)
                {
                    lastName = "noLastName";
                }
                printWriter.println(lastName); //записывае фамилию в новую строку

                printWriter.println(dateFormat.format(user.getBirthDate())); //записываем Дату Рождения в новую строку

                printWriter.println(String.valueOf(user.isMale())); //Записываем пол в новую строку (true/false)

                printWriter.println(user.getCountry()); //Записываем страну в новую строку

        }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready())
            {
                String newUser = reader.readLine(); //считываем newUser
                if(newUser.equals("@"))
                {
                    User user = new User();

                    String firstName = reader.readLine();
                    if (firstName.equals("noName")) firstName = null;
                    user.setFirstName(firstName);

                    String lastName = reader.readLine();
                    if (lastName.equals("noLastName")) lastName = null;
                    user.setLastName(lastName);

                    user.setBirthDate(dateFormat.parse(reader.readLine()));

                    if(reader.readLine().equals(true)) user.setMale(true);
                    else user.setMale(false);

                    user.setCountry(User.Country.valueOf(reader.readLine()));

                    users.add(user);
                }
            }
        }
    }
}
