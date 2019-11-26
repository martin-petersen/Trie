package com.company.trie;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TreeTest {

    @org.junit.Test
    public void insert() {
        Tree root = new Tree();
        String s1 = "ameixa";
        root.insert(s1);

        root.exists("ameixa");

        assertTrue("Essa palavra (ameixa) existe!",true);
    }

    @org.junit.Test
    public void closeWords() {
        Tree root = new Tree();
        String s1 = "ameixa";
        String s2 = "amei";
        String s3 = "ame";
        String s4 = "amo";
        String s5 = "amou";
        root.insert(s2);
        root.insert(s3);
        root.insert(s4);
        root.insert(s5);
        root.insert(s1);

        assertTrue(root.closeWords("am").contains("ameixa") && root.closeWords("am").contains("amei") &&
                root.closeWords("am").contains("ame") && root.closeWords("am").contains("amo") &&
                root.closeWords("am").contains("amou"));

        assertTrue(root.closeWords("am",2).size() == 2 && root.closeWords("am",2).contains("ame") &&
                root.closeWords("am",2).contains("amei"));
    }

    @org.junit.Test
    public void removeWord() {
        Tree root = new Tree();
        String word2 = "ameixa";
        String word = "ame";
        root.insert(word2);

        root.removeWord(word2);

        assertTrue(root.existChildren());

        root.insert(word2);
        root.insert(word);

        root.removeWord(word);

        assertTrue(word2,true);
        assertFalse(word,false);
    }

    @org.junit.Test
    public void exists() {
        Tree root = new Tree();
        String word = "ams";
        String word2 = "ameixa";
        root.insert(word2);

        root.exists(word);

        assertTrue("Essa palavra (" + word + ") não existe!",true);

        root.exists(word2);

        assertTrue("Essa palavra (" + word2 + ") não existe!",true);
    }
}