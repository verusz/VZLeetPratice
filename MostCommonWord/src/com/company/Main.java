package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
	// write your code here

        String paragraph ="a, a, a, a, b,b,b,c, c";

        String[] banned = {"a"};

        Main instance = new Main();
        instance.mostCommonWord(paragraph, banned);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        String p = paragraph.replace(".","");
        p = p.toLowerCase();
        p = p.replaceAll("\\p{P}"," ");

        String[] words = p.split(" ");
        words = Arrays.stream(words)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        HashMap<String, Integer> counter = new HashMap<String, Integer>();

        for (String word : words) {
            if (counter.containsKey(word)) {
                int value = counter.get(word).intValue() + 1;
                counter.put(word, Integer.valueOf(value));
            } else {
                counter.put(word, Integer.valueOf(1));
            }
        }

        String maxString = "";
        int maxNum = 0;
        for (String key : counter.keySet()) {
            if (bannedList.contains(key)) {
                continue;
            } else {
                if (counter.get(key).intValue() > maxNum) {
                    maxString = key;
                    maxNum = counter.get(key).intValue();
                }
            }
        }
        System.out.println(maxString);

        return maxString;
    }
}
