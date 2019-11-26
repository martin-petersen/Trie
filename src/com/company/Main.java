package com.company;

import com.company.trie.Tree;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Tree root = new Tree();

        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str;

        while ((str = bufferedReader.readLine()) != null) {
            root.insert(str);
        }

        if(args.length == 3) {
            int limit = Integer.parseInt(args[2]);
            System.out.println(root.closeWords(args[1], limit));
        } else {
            System.out.println(root.closeWords(args[1]));
        }
    }
}
