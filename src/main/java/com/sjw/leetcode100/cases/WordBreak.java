package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak implements BaseCase {
    @Override
    public void run() {
        // Test case 1: should return false
        List<String> list1 = new ArrayList<>();
        list1.add("cats");
        list1.add("dog");
        list1.add("sand");
        list1.add("and");
        list1.add("cat");
        String s1 = "catsandog";
        System.out.println("Test 1 (catsandog): " + wordBreak1(s1, list1));
        
        // Test case 2: should return true
        List<String> list2 = new ArrayList<>();
        list2.add("leet");
        list2.add("code");
        String s2 = "leetcode";
        System.out.println("Test 2 (leetcode): " + wordBreak1(s2, list2));
    }

    /**
     * Optimized solution using DP from left to right.
     * 
     * Time Complexity: O(n² * k) where n = string length, k = average word length
     * - We iterate through each position in the string (O(n))
     * - For each position, we try all possible word lengths (O(n) in worst case)
     * - String comparison for each attempt is O(k)
     * 
     * Using HashSet for word lookup gives O(1) instead of O(m) for list iteration.
     * 
     * The key optimization: Instead of recursively trying all paths from start,
     * we build up the solution from left to right. dp[i] = true means s[0:i+1] 
     * can be segmented into dictionary words.
     * 
     * Why this is faster:
     * 1. Each position is processed exactly once - O(n) states
     * 2. We don't revisit states like in the recursive DFS approach
     * 3. HashSet provides O(1) word existence check
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Use HashSet for O(1) word lookup instead of O(m) list iteration
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] = true means s[0:i+1] can be segmented into dictionary words
        boolean[] dp = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            // Try each word in dictionary that could end at position i
            for (String word : wordSet) {
                int wordLen = word.length();
                // Check if word can fit ending at position i
                if (i >= wordLen - 1) {
                    // Check if word matches s[i-wordLen+1 to i]
                    int startIdx = i - wordLen + 1;
                    
                    // Either at position 0, or dp[startIdx-1] must be true
                    boolean prefixMatch = (startIdx == 0) || dp[startIdx - 1];
                    
                    if (prefixMatch && s.substring(startIdx, i + 1).equals(word)) {
                        dp[i] = true;
                        break; // Found a valid word, no need to check others
                    }
                }
            }
        }
        
        return dp[s.length() - 1];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        //到结尾长度为i的字符串是否符合要求
        Boolean[] dp = new Boolean[s.length()+1];
        dp[0] = true;
        return f(s, 1, wordSet, dp);
    }

    public boolean f(String s, int len, Set<String> wordDict, Boolean[] dp) {
        if(len > s.length()) {
            return dp[len - 1];
        }

        if (dp[len] != null) {
            return dp[len];
        }

        boolean precheck = false;
        boolean valid = false;
        for (String str : wordDict) {
            precheck = (s.length() -len + str.length()) <= s.length();
            if (precheck && s.startsWith(str, s.length() - len)) {
                if (f(s, len-str.length(), wordDict, dp)) {
                    valid = true;
                    break;
                }
            }
        }

        dp[len] = valid;
        return f(s, len+1, wordDict, dp);
    }
}
