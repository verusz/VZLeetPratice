package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main in = new Main();
        System.out.println(in.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        String result = "";
        int maxL = 0;

        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[j+1][i-1]);
                if (dp[i][j] == true && maxL < (j - i + 1)) {
                    result = s.substring(i,j + 1);
                    maxL = result.length();
                }

            }
        }
        return result;
    }
}
