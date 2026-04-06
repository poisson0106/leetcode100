package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class BuildTrie implements BaseCase {
    @Override
    public void run() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.insert("app");
        trie.search("app");
    }

    class Trie {

        class TrieNode {
            int pass = 0;
            int end = 0;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            cur.pass++;
            for (int i = 0; i < chars.length; i++) {
                if (cur.children[chars[i] - 'a'] == null) {
                    cur.children[chars[i] - 'a'] = new TrieNode();
                }
                cur = cur.children[chars[i] - 'a'];
                if (i == chars.length - 1) {
                    cur.end++;
                }
                cur.pass++;
            }
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < chars.length; i++) {
                if (cur.children[chars[i] - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[chars[i] - 'a'];
                    if (i == chars.length - 1 && cur.end > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < chars.length; i++) {
                if (cur.children[chars[i] - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[chars[i] - 'a'];
                }
            }
            return true;
        }
    }
}
