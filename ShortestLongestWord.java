import java.util.*;

public class ShortestLongestWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] words = text.split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length())
                shortest = word;

            if (word.length() > longest.length())
                longest = word;
        }

        System.out.println("Shortest: " + shortest + " (" + shortest.length() + ")");
        System.out.println("Longest: " + longest + " (" + longest.length() + ")");

        sc.close();
    }
}
