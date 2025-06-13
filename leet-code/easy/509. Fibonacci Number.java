class Solution {
    public int fib(int n) {
        int sum = n;

        if(n > 1) {
            sum = fib(n - 1) + fib(n - 2);
        }
        
        return sum;
    }
}