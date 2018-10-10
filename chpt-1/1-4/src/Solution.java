import java.util.HashSet;
import java.util.Set;

// Given a string write a function to check if it is a permutation of a palindrome.
public class Solution {
    public static void main(String [] args)
    {
        System.out.println(pp("tact Coa") + " == true");
        System.out.println(pp(" ") + " == true");
        System.out.println(pp("moo oN") + " == false");
    }

    private static boolean pp(String value)
    {
        // Why does string builder not support regex or to lower?
        // A char array would be the best place to support this.
        StringBuilder input = new StringBuilder(value.toLowerCase().replaceAll("\\s", ""));

        if(input.length() < 2)
        {
            return true;
        }

        Set<Character> exists = new HashSet<>();
        char c;
        for(int i = 0; i < input.length(); i++)
        {
            c = input.charAt(i);
            if(exists.contains(c))
            {
                exists.remove(c);
            }
            else
            {
                exists.add(c);
            }
        }

        return (exists.size() == 0 && input.length() % 2 == 0) ||
                (exists.size() == 1 && input.length() % 2 == 1);
    }
}
