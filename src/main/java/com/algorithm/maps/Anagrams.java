package com.algorithm.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
*/
public class Anagrams {
    public static void main(String[] args) {
        System.out.println(anagramCount("zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw"));
    }

    public static int anagramCount(String s) {
        Map<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();
        int count = 0;
        for (int i = 1; i <=  s.length(); i++) {
            if (!map.containsKey(i)) {
                map.put(i, new HashMap<String, Integer>());
            }
            for (int j = 0; j <= s.length() -i; j++) {
                String subStr = s.substring(j, j+i);
                char[] tempArray = subStr.toCharArray();
                Arrays.sort(tempArray);
                subStr = new String(tempArray);
                if (map.get(i).get(subStr) == null) {
                    map.get(i).put(subStr, 1);
                } else {
                    map.get(i).put(subStr, map.get(i).get(subStr) + 1);
                }
            }
        } 

        for (int i = 1; i <=  s.length(); i++) {
            HashMap subMap = map.get(i);
            int sum =  subMap.entrySet().stream().filter(x -> (Integer)(((Entry)x).getValue())>1)
                            .mapToInt(x -> ((Integer)(((Entry)x).getValue()))*(((Integer)(((Entry)x).getValue()))-1)/2)
                            .sum();
            count += sum;
        }

        //System.out.println(map);
        return count;
    }
}
