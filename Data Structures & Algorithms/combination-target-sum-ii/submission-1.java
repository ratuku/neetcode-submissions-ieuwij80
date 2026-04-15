/*
* Solution with reduced recurrsion calls.
* Sort array, BackTrack, Skip duplicate numbers/nodes
*/

class Solution {
    private Set<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new HashSet<>();
        int sum = 0;
        List<Integer> combo = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, sum, combo);

        //System.out.println(result);
        return new ArrayList<>(result);
    }

    private void backTrack(int[] candidates, int target, int index, int sum, List<Integer> combo) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(combo));
        }
        
        if (sum > target || index == candidates.length) {
            return;
        }

        combo.add(candidates[index]);
        backTrack(candidates, target, index+1, sum + candidates[index], combo);
        
        combo.remove(combo.size() -1);
        
        // ignore duplicate nodes/numbers
        // reduces number of recurrsion calls
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        backTrack(candidates, target, index+1, sum, combo);
    }
}
