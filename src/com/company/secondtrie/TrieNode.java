package com.company.secondtrie;

import com.company.trie.Node;

import java.util.ArrayList;

public class TrieNode {
    private boolean isWord = false;
    private ArrayList<Node> children = new ArrayList<>();
    private String text = null;

    public TrieNode() {
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Node getChild(Character key) {
        for (Node n:
                this.children) {
            if(n.getKey() == key) {
                return n;
            }
        }
        return null;
    }

    public Node getChild(Node node) {
        for (Node n:
                this.children) {
            if(n == node) {
                return n;
            }
        }
        return null;
    }

    public void setChildren(Node child) {
        this.children.add(child);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
