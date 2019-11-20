package com.company;

import com.company.trie.Tree;

public class Main {

    public static void main(String[] args) {
        Tree root = new Tree();

        String s1 = "ameixa";
        String s2 = "amei";
        String s3 = "ame";
        String s4 = "amo";
        String s5 = "amou";

        root.insert(s1);
        root.insert(s2);
        root.insert(s3);
        root.insert(s4);
        root.insert(s5);

        System.out.println(root.closeWords("am").toString());
        System.out.println(root.closeWords("am",2).toString());

        root.exists("ams");


        root.removeWord(s1);

        System.out.println(root.closeWords("am").toString());
    }
}
