import java.io.PrintStream;
import java.util.*;

public class HandleTruth {
    public static String wordCount(String msg, PrintStream output) {
        // split the message into word set
        String[] words = msg.split(" ");

        //NEW CODE: Makes every word lowercase to fix error where The and the are different words (which they are not).
        for(int i = 0; i < words.length; i++)
            words[i] = words[i].toLowerCase();

        //NEW CODE: Removes any occurrences of a word that is just "" (which prior to this, literally nothing could be considered a word with the right input)
        int newWordsLength = words.length;
        for(String word : words) {
            if(word.equals(""))
                newWordsLength--;
        }
        if(newWordsLength != words.length)
        {
            String[] newWords = new String[newWordsLength];
            int newWordsCounter = 0;
            for(int i = 0; i < words.length; i++) {
                if(!words[i].equals("")) {
                    newWords[newWordsCounter++] = words[i];
                }
            }
            words = newWords;
        }

        // use map to count the occurrences of each word
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            wordMap.put(word, 1);
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            //output.println(entry);
        }

        // sort the map based on number of occurrences
        TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }

        for (Map.Entry<Integer, Set<String>> entry : sortedMap.entrySet()) {
            output.println(entry);
        }

        return sortedMap.toString();
    }
}