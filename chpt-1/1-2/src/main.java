import java.util.ArrayList;
import java.util.List;

/*
    Given two strings, write a method to decide if one is a permutation of the other.
*/
public class main {
    public static void main(String [] args)
    {
        System.out.println(isPermutation("cow", "cwo") + " == true");
        System.out.println(isPermutation("mop", "cwo") + " == false");
        System.out.println(isPermutation("", "") + " == true");
    }

    private static boolean isPermutation(String s1, String s2)
    {
        // Assume no nulls
        if(s1.length() != s2.length())
        {
            return false;
        }

        List<Character> charList = new ArrayList<>();

        for(char c : s1.toCharArray())
        {
            charList.add(c);
        }

        for(char c : s2.toCharArray())
        {
            if(charList.contains(c))
            {
                charList.remove(Character.valueOf(c));
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
