package howManyWords;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowManyWordsCount {
        public List< Map.Entry <String, Integer>> countWords (String[] words){

            HashMap<String, Integer> wordsCount = new HashMap<>();
            for (String word : words) {
                word = word.toLowerCase();
                wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
            }
            List<Map.Entry<String,Integer>> listSorted = new ArrayList<>(wordsCount.entrySet());

            listSorted.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());
            return listSorted;
        }
    }


