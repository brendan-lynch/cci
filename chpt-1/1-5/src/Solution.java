import java.util.ArrayList;
import java.util.List;

// There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character.
// Given two strings, write a function to check if they are one edit or less away.
public class Solution {
    public static void main(String [] args)
    {
        System.out.println(oneAway("pale", "ple") + " == true");
        System.out.println(oneAway("ale", "ple") + " == true");
        System.out.println(oneAway("pale", "pales") + " == true");
        System.out.println(oneAway("pale", "bake") + " == false");
    }

    private static boolean oneAway(String first, String second)
    {
        String s1 = first.length() > second.length() ? first : second;
        String s2 = first.length() > second.length() ? second : first;

        int i1 = 0;
        int i2 = 0;
        boolean diff = false;
        while(i1 < s1.length() && i2 < s2.length())
        {
            if(s1.charAt(i1) == s2.charAt(i2))
            {
                i2++;
            }
            else
            {
                if(diff)
                {
                    return false;
                }

                diff = true;
                if(s1.length() == s2.length())
                {
                    i2++;
                }
            }

            i1++;
        }

        return true;
    }

    // Suboptimal, did not account for solving this without implementing additional storage.
    // Additional storage does not improve the performance and is strictly worse.
    private static boolean oneAwayPoor(String s1, String s2)
    {
        boolean withinOne = true;
        if(diffLength(s1.length(), s2.length()) > 1)
        {
            withinOne =  false;
        }
        else
        {
            List<Character> l1 = new ArrayList<>();
            List<Character> l2 = new ArrayList<>();

            for(char c : s1.toCharArray())
            {
                l1.add(c);
            }

            for(char c : s2.toCharArray())
            {
                l2.add(c);
            }

            int diffCount = 0;
            while(l1.size() > 0 && l2.size() > 0)
            {
                if(!l1.remove(l2.get(0)))
                {
                    diffCount++;
                    if(diffCount > 1)
                    {
                        withinOne = false;
                        break;
                    }
                }

                l2.remove(l2.get(0));
            }

            if(diffLength(l1.size(), l2.size()) > 1)
            {
                withinOne = false;
            }
        }

        return withinOne;
    }

    private static int diffLength(int a, int b)
    {
        return Math.abs(a-b);
    }
}
