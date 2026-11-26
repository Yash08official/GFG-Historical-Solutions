import java.util.*;

class Solution {

    public static int countNumbers(int n) {

        int limit = (int) Math.sqrt(n);

        // Step 1: Generate primes using Sieve
        boolean[] isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;

        if (limit >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= limit; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Store all primes
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {

            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int count = 0;

        // Step 3: Count numbers of form p^8
        for (int p : primes) {

            long value = 1;

            for (int i = 0; i < 8; i++) {
                value *= p;
            }

            if (value <= n) {
                count++;
            } else {
                break;
            }
        }

        // Step 4: Count numbers of form p^2 * q^2
        for (int i = 0; i < primes.size(); i++) {

            long pSquare = (long) primes.get(i) * primes.get(i);

            for (int j = i + 1; j < primes.size(); j++) {

                long qSquare = (long) primes.get(j) * primes.get(j);

                if (pSquare * qSquare <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}