package com.sigaphi.text.suffixarray;


import com.sigaphi.text.suffixarray.constuct.sais;
import org.apache.commons.lang3.StringUtils;


public class SuffixArray {

    public static int[] buildSuffixArray(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        char[] doc = str.toCharArray();
        int[] sa = new int[doc.length];
        sais.suffixsort(doc, sa, doc.length);
        return sa;
    }

    public static int[] computeLCP(char[] doc, final int start, final int length, int [] sa) {
        int[] input = new int[doc.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = Character.getNumericValue(doc[i]);
        }
        int[] lcp = computeLCP(input, start, length, sa);
        return  lcp;
    }

    public static int[] computeLCP(int[] input, final int start, final int length, int [] sa) {
        final int [] rank = new int [length];
        for (int i = 0; i < length; i++)
            rank[sa[i]] = i;
        int h = 0;
        final int [] lcp = new int [length];
        for (int i = 0; i < length; i++)
        {
            int k = rank[i];
            if (k == 0)
            {
                lcp[k] = -1;
            }
            else
            {
                final int j = sa[k - 1];
                while (i + h < length && j + h < length
                        && input[start + i + h] == input[start + j + h])
                {
                    h++;
                }
                lcp[k] = h;
            }
            if (h > 0) h--;
        }

        return lcp;
    }

    public static void precomputeLcps(int[] lcp, int[] llcp, int[] rlcp) {
        llcp = new int[lcp.length];
        rlcp = new int[lcp.length];
        // TODO
    }


}
