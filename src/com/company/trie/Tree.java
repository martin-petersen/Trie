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

    public ArrayList<String> closeWords(String prefix, int limit) {
        ArrayList<Character> keys = new ArrayList<>();
        for (int i= 0 ; i < prefix.length(); ++i) {
            keys.add(prefix.charAt(i));
        }
        ArrayList<String> palavras = new ArrayList<>();
        ArrayList<String> tmp = this.root.find(keys);

        if(tmp.size() < limit) {
            palavras.addAll(tmp);
        } else {
            for(int i = 0; i < limit; ++i) {
                palavras.add(tmp.get(i));
            }
        }
        return palavras;
    }

    public void removeWord(String word) {
        ArrayList<Character> keys = new ArrayList<>();
        for (int i= 0 ; i < word.length(); ++i) {
            keys.add(word.charAt(i));
        }
        this.root.remove(keys);
    }

    public void exists(String word) {
        ArrayList<Character> keys = new ArrayList<>();
        for (int i= 0 ; i < word.length(); ++i) {
            keys.add(word.charAt(i));
        }
        Node node = this.root;
        while(keys.size() > 0) {
            node = node.getChild(keys.get(0));
            keys.remove(0);
        }
        if(node == null){
            System.out.println("Essa palavra (" + word + ") não existe!");
            return;
        }
        if(node.isWord()) {
            System.out.println("Essa palavra (" + word + ") existe!");
        }
    }

    public boolean existChildren() {
        return root.existChildren();
    }
}
