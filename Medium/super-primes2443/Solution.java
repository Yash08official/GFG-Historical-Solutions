import java.util.*;

class Solution {

    public ArrayList<Integer> superPrimes(int n) {

        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Create sieve
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;

        if (n >= 1) {
            isPrime[1] = false;
        }

        // Step 2: Mark non-prime numbers
        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Find super primes
        int position = 0;

        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) {

                position++;

                // Prime number whose position is prime
                if (position <= n && isPrime[position]) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}