package com.company.trie;

import java.util.ArrayList;

public class Node {
    private Character key;
    private boolean word = false;
    private Node parent;
    ArrayList<Node> children = new ArrayList<>();

    public Node() {
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
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

    public void insert(ArrayList<Character> keys) {
        if(this.getChild(keys.get(0)) != null) {
            keys.remove(0);
            if(keys.size() == 0) {
                this.setWord(true);
                return;
            }
            this.getChild(keys.get(0)).insert(keys);
        } else {
            Node n = new Node();
            n.setKey(keys.get(0));
            n.setParent(this);
            keys.remove(0);
            if(keys.size() == 0) {
                n.setWord(true);
                this.setChildren(n);
            } else {
                this.setChildren(n);
                this.getChild(n).insert(keys);
            }
        }
    }

    public ArrayList<String> find(ArrayList<Character> keys) {
        ArrayList<String> palavras = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Character s:
             keys) {
            sb.append(s);
        }
        if(keys.size() == 1) {
            ArrayList<Node> nodes = this.getWordNodes();
            for (Node n:
                 nodes) {
                palavras.add(makeWord(n));
            }
        } else {
            keys.remove(0);
            if(this.isWord()) {
                palavras.add(makeWord(this));
            }
            this.getChild(keys.get(0));
        }

        for (int i = 0; i < palavras.size(); ++i) {
            palavras.set(i,sb.toString() + palavras.get(i));
        }
        return palavras;
    }

    private ArrayList<Node> getWordNodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        for (Node n:
             this.children) {
            if(n.children != null) {
                if(n.isWord()) {
                    nodes.add(n);
                    nodes.addAll(n.getWordNodes());
                } else {
                    nodes.addAll(n.getWordNodes());
                }
            } else {
                if(n.isWord()) {
                    nodes.add(n);
                }
            }
        }
        return nodes;
    }

    private String makeWord(Node node) {
        StringBuilder sb = new StringBuilder();
        while(node.getParent().getParent() != null) {
            sb.append(node.getKey());
            node = node.getParent();
        }
        return sb.reverse().toString();
    }
}
