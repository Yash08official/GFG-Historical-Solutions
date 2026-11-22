class Solution {

    public static int nextPrime(int n) {

        int num = n + 1;

        while (true) {

            boolean isPrime = true;

            // Check whether num is prime
            for (int i = 2; i * i <= num; i++) {

                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                return num;
            }

            num++;
        }
    }
}
