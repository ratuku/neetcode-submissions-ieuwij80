class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) return memo.get(n);

        int value = 0;
        for (int i = n-1; i > n - 4 ; i--) {
            value+= tribonacci(i);
        }
        memo.put(n, value);
        return value;
    }
}