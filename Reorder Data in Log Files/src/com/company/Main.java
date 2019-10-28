package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        Main in = new Main();
        in.reorderLogFiles(strs);
    }

    public String[] reorderLogFiles(String[] logs) {

        List<String> digitalStrs = new ArrayList<>();
        List<String> letterStrs = new ArrayList<>();


        for (String word: logs) {
            Character c = word.split(" ")[1].charAt(0);

            if ( Character.isDigit(c) ) {
                digitalStrs.add(word);
            } else {
                letterStrs.add(word);
            }
        }

        Collections.sort(letterStrs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);

                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            }
        });
        letterStrs.addAll(digitalStrs);
        String[] result = letterStrs.toArray(new String[0]);

        return result;
    }
}
