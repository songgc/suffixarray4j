package com.sigaphi.text.suffixarray;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.stream.Collectors;


public class SuffixArrayTest {

    @Test
    public void buildTest() {
        String doc = "to be or not to be";
        int[] sa = SuffixArray.buildSuffixArray(doc);
        System.out.println(Arrays.toString(sa));
        int[] lcp = SuffixArray.computeLCP(doc.toCharArray(), 0, doc.length(), sa);
        System.out.println(Arrays.toString(lcp));
    }

    @Test
    public void buildBigText() throws IOException {
        URL url = new URL("http://www.gutenberg.org/cache/epub/10/pg10.txt");
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String pageText = reader.lines().collect(Collectors.joining("\n"));
        System.out.print(pageText.length());
        int[] sa = SuffixArray.buildSuffixArray(pageText);
        int[] lcp = SuffixArray.computeLCP(pageText.toCharArray(), 0, pageText.length(), sa);
//        System.out.println(Arrays.toString(sa));
    }
}