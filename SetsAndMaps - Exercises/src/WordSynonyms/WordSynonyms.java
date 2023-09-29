package WordSynonyms;

import com.sun.source.doctree.BlockTagTree;

import java.util.*;
import java.util.stream.Collectors;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> map = new LinkedHashMap<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();
            if(!map.containsKey(word1)){
                stringList = new ArrayList<>();
                stringList.add(word2);
                map.put(word1,stringList);
            }else {
                map.get(word1).add(word2);
            }

        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String synonyms = entry.getValue()
                            .stream()
                                    .map(e->String.valueOf(e))
                                            .collect(Collectors.joining(" "));
            System.out.printf("%s - %s\n",entry.getKey(),synonyms);
        }

    }
}
