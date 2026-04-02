class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backTrack(1, n, k, new ArrayList<Integer>(), output);
        return output;
    }


    private void backTrack(int start, int end, int k, List<Integer> combo, List<List<Integer>> output) {
        if (combo.size() == k) {
            output.add(new ArrayList<>(combo)); // add a copy so it's not overriden
            return;
        }

        // decision part
        for (int i = start; i <= end; i++) {
            combo.add(i); // pick this number
            backTrack(i+1, end, k, combo, output); // continue to explore
            combo.remove(combo.size() -1); // backtrack.. undo the recent selection to explore next number
        }
    }
}