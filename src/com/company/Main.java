package com.company;

import com.company.trie.Tree;

public class Main {

    public static void main(String[] args) {
        Tree root = new Tree();

        String s1 = "ameixa";
        String s2 = "amei";
        String s3 = "ame";

        root.insert(s1);
        root.insert(s2);
        root.insert(s3);

        System.out.println(root.closeWords("ameix").toString());
    }
}
