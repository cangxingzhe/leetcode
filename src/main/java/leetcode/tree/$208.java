package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class $208 {

    public static void main(String[] args) {

    }

    static class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if(node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }
    }

    static class Trie2 {
        Map<Character, Trie2> children;
        boolean isEnd;
        public Trie2() {
            children = new HashMap<>();
        }

        public void insert(String word) {
            Trie2 node = this;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if(node.children.get(c) == null) {
                    node.children.put(c, new Trie2());
                }
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie2 trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }

        private Trie2 searchPrefix(String prefix) {
            Trie2 node = this;
            for (int i = 0; i < prefix.length(); i++) {
                if(node.children.containsKey(prefix.charAt(i))) {
                    return null;
                }
                node = node.children.get(prefix.charAt(i));
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }
    }
}
