package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int maxLength(List<String> arr) {

        if (arr.size() == 1) {
            return arr.get(0).length();
        }
        int length = 0;

        String[][] mar = new String[arr.size() - 1][arr.size() - 1];


        for (int i = 0; i < arr.size(); i++) {
            List<String> temp = arr;
        for (int j = 0; j < arr.get(i).length(); j++) {
            for (int k = 0; k < arr.size(); k++) {
                if (arr.get(k).indexOf(arr.get(i).charAt(j)) >= 0) {

                    temp.remove(k);
                }
            }
        }

            mar[i] = temp.toArray(new String[temp.size()]);

        }

        for (int i = 0; i < arr.size(); i++) {
            int subLength = 0;
            for (int j = 0; j < mar[i].length; j++) {
                if (mar[i][j].length() > subLength ) {
                    subLength = mar[i][j].length();
                }
            }
            if (subLength + arr.get(i).length() > length) {
                length = subLength + arr.get(i).length();
            }
        }

        return length;
    }
}
