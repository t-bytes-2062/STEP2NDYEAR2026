import java.util.*;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            // Skip stop words
            if (stopWords.contains(word)) {
                continue;
            }

            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Convert map entries to a list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency descending
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}
