/* Implement an algorithm to determine if a string has all unique characters. */

import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String [] args)
    {
        System.out.println(isUnique("cow") + " == true");
        System.out.println(isUnique("moon") + " == false");
        System.out.println(isUnique("racecar") + " == false");
        System.out.println(isUnique("") + " == true");
    }

    private static boolean isUnique(String s)
    {
        boolean unique = true;

        // Assume no nulls
        if(s.length() < 2)
        {
            return unique;
        }

        Set<Character> characters = new HashSet<>();
        for(char c : s.toCharArray())
        {
            if(characters.contains(c))
            {
                unique = false;
                break;
            }
            else
            {
                characters.add(c);
            }
        }

        return unique;
    }
}
