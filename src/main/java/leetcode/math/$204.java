package leetcode.math;

import java.util.Arrays;

public class $204 {

    public static void main(String[] args) {
        System.out.println(new $204().countPrimes(10));
    }

    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int count = n - 2;
        for (int i = 2; i < n; i++) {
            if(primes[i]) {
                for(int j=i*2; j < n; j+=i) {
                    if(primes[j]) {
                        primes[j] = false;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
