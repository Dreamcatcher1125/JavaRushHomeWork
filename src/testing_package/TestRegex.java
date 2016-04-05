package testing_package;

import java.util.StringTokenizer;

public class TestRegex
{
    public static void main(String[] args)
    {
        String s = "Good news everyone!";

        StringTokenizer tokenizer = new StringTokenizer(s,"ne");
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
}
//Good news nevneryone!