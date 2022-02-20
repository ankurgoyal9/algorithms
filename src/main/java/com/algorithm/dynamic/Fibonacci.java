package com.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Memoization to reduce time complexity to O(N) instead of O(2^N)
 * 
 * 
 * */
public class Fibonacci {

    public static Map<Long, Long> map = new HashMap<Long, Long>();

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(50L));
    }

    public static Long calculateFibonacci(Long n){
        if(map.get(n)!=null){
            return map.get(n);
        }
        if (n<=2){
            return 1L;
        }

        Long value = calculateFibonacci(n-1) + calculateFibonacci(n-2);
        map.put(n, value);
        return value;
    }
    
}
