class Solution {

    int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public boolean smithNum(int n) {

        int temp = n;
        int factorsDigitSum = 0;
        boolean isComposite = false;

        for (int i = 2; i * i <= temp; i++) {

            while (temp % i == 0) {

                factorsDigitSum += digitSum(i);
                temp /= i;
                isComposite = true;
            }
        }

        if (temp > 1) {
            factorsDigitSum += digitSum(temp);
        }

        return isComposite && digitSum(n) == factorsDigitSum;
    }
}
