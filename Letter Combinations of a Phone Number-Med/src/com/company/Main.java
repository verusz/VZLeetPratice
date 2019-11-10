package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main in = new Main();
        in.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 ) {
            return null;
        }

        Map<Character, Character[]> hashMap = new HashMap<>();
        hashMap.put('2', new Character[]{'a','b','c'});
        hashMap.put('3', new Character[]{'d','e','f'});
        hashMap.put('4', new Character[]{'g','h','i'});
        hashMap.put('5', new Character[]{'j','k','l'});
        hashMap.put('6', new Character[]{'m','n','o'});
        hashMap.put('7', new Character[]{'p','q','r','s'});
        hashMap.put('8', new Character[]{'t','u','v'});
        hashMap.put('9', new Character[]{'w','x','y','z'});


        List<String> results = new ArrayList<>();
        String combination = new String();

        dfs(digits, combination, 0, results, hashMap);

        return results;
    }

    public void dfs(String digits, String combination, int startIndex, List<String> results, Map<Character, Character[]> hashMap) {
        if (startIndex == digits.length()) {
            results.add(new String(combination));
            return;
        }

            Character c = digits.charAt(startIndex);
            for (int j = 0; j < hashMap.get(c).length; j++) {
                combination = combination + hashMap.get(c)[j];
                dfs(digits, combination, startIndex + 1, results, hashMap);
                combination = combination.substring(0, combination.length() - 1);
            }
    }
}
