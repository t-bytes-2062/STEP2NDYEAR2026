import java.util.*;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String s, int i, int j) {
        if (i >= j)
            return true;
        if (s.charAt(i) != s.charAt(j))
            return false;
        return isPalindromeRecursive(s, i + 1, j - 1);
    }

    static boolean isPalindromeArrayReversal(String s) {
        char[] arr = s.toCharArray();
        char[] rev = new char[arr.length];

        for (int i = 0; i < arr.length; i++)
            rev[i] = arr[arr.length - 1 - i];

        return s.equals(new String(rev));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.println("Iterative: " +
                (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (isPalindromeRecursive(text,0,text.length()-1) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
