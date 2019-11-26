package com.company.trie;

import java.util.ArrayList;

public class Node {
    private Character key;
    private boolean word = false;
    private Node parent;
    private ArrayList<Node> children = new ArrayList<>();

    Node() {
    }

    public char getKey() {
        return key;
    }

    private void setKey(char key) {
        this.key = key;
    }

    private Node getParent() {
        return parent;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    boolean isWord() {
        return word;
    }

    private void setWord(boolean word) {
        this.word = word;
    }

    public boolean existChildren() {
        return this.children.isEmpty();
    }

    Node getChild(Character key) {
        for (Node n:
             this.children) {
            if(n.getKey() == key) {
                return n;
            }
        }
        return null;
    }

    private Node getChild(Node node) {
        for (Node n:
                this.children) {
            if(n == node) {
                return n;
            }
        }
        return null;
    }

    private void setChildren(Node child) {
        this.children.add(child);
    }

    void insert(ArrayList<Character> keys) {
        if(this.getChild(keys.get(0)) != null) {
            Character c = keys.get(0);
            keys.remove(0);
            if(keys.size() == 0) {
                this.getChild(c).setWord(true);
                return;
            }
            this.getChild(c).insert(keys);
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

    ArrayList<String> find(ArrayList<Character> keys) {
        ArrayList<String> palavras = new ArrayList<>();
        Node node = this;
        while(keys.size() > 0) {
            node = node.getChild(keys.get(0));
            keys.remove(0);
        }

        ArrayList<Node> nodes = node.getWordNodes();

        for (Node n:
             nodes) {
            palavras.add(makeWord(n));
        }
        return palavras;
    }

    private ArrayList<Node> getWordNodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        Node n;
        if(this.isWord()) {
            nodes.add(this);
        }
        for(int i = 0; i < this.children.size(); ++i) {
            n = this.children.get(i);
            if(n.children != null) {
                nodes.addAll(n.getWordNodes());
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
        sb.append(node.getKey());
        return sb.reverse().toString();
    }

    void remove(ArrayList<Character> keys) {
        Node node = this;
        while(keys.size() > 0) {
            node = node.getChild(keys.get(0));
            keys.remove(0);
        }
        if(node.children.size() == 0) {
            Node parent = node.getParent();
            parent.children.remove(node);
            while(!parent.isWord() && parent.getParent().children.size() > 0) {
                parent = parent.getParent();
                parent.children.remove(0);
                if(parent.getParent() == null)
                    return;
            }
        } else {
            node.setWord(false);
        }
    }
}
