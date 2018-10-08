/*
    URLify -- replace space with %20. Use char array.
*/
public class main {
    public static void main(String [] args)
    {
        String s = "John Doe";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

        s = "Hello, World!";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

        s = "trivia ";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

        s = " trivia";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

        s = "trivia";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

        s = "";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

        s = "   ";
        System.out.println(s);
        System.out.println(urlify(s.toCharArray()));
        System.out.println();

    }

    private static char[] urlify(char[] s)
    {
        int position = s.length + offset(s);
        char[] url = new char[position];
        position--;

        for(int i = s.length-1; i >= 0; i--)
        {
            if(s[i] == ' ')
            {
                url[position] = '0';
                url[position-1] = '2';
                url[position-2] = '%';
                position -= 3;
            }
            else
            {
                url[position] = s[i];
                position--;
            }
        }

        return url;
    }

    private static int offset(char[] s)
    {
        int whitespace = 0;
        for(char c : s)
        {
            if(c == ' ')
            {
                whitespace++;
            }
        }

        // %20 takes three spots, % can take the original space.
        return whitespace * 2;
    }

}
