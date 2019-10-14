package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String beginWord = "hit";
        String endWord = "cog";


        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");


        Main ins = new Main();
        ins.ladderLength(beginWord, endWord, wordList);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int l = beginWord.length();

        Map<String, List<String>> allList = new HashMap<>();


        for (String word: wordList) {
//            List<String> subWords = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                String w = word.substring(0, i) + "*" + word.substring(i + 1, l);
//                subWords.add(w);
                List<String> subword = new LinkedList<>();
                subword.add(word);

                allList.put(w, subword);
            }
        }

        Queue<String> wordQueue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        wordQueue.offer(beginWord);
        set.add(beginWord);
        int level = 1;

        while (!wordQueue.isEmpty()) {
            String w = wordQueue.poll();

            for (int i = 0; i < l; i++) {
                String subWord = w.substring(0, i) + "*" + w.substring(i + 1, l);

                for (String sw: allList.getOrDefault(subWord, new LinkedList<>())) { // have already found the same subWord
                    if (sw == endWord) {
                        System.out.println(level + 1);
                        return level + 1;
                    }

                    if (!set.contains(sw)) {
                        level = level + 1;

                        wordQueue.offer(sw);
                        set.add(sw);
                    }
                }
            }
        }
        return  0;

    }
}
