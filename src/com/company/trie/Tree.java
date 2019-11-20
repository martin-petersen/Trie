package com.company.trie;

import java.util.ArrayList;

public class Tree {
    private Node root;

    public Tree() {
        this.root = new Node();
    }

    public void insert(String word) {
        ArrayList<Character> keys = new ArrayList<>();
        for (int i= 0 ; i < word.length(); ++i) {
            keys.add(word.charAt(i));
        }
        this.root.insert(keys);
    }

    public ArrayList<String> closeWords(String prefix) {
        ArrayList<Character> keys = new ArrayList<>();
        for (int i= 0 ; i < prefix.length(); ++i) {
            keys.add(prefix.charAt(i));
        }
        return this.root.find(keys);
    }

    public void removeWord(String word) {

    }
}
