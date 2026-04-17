class Solution {
    private List<List<String>> subStrings;

    public List<List<String>> partition(String s) {
        subStrings = new ArrayList<>();
        List<String> subString = new ArrayList<>();

        subStrings(s, 0, 0, subString);

        return subStrings;
    }

    private void subStrings(String str, int l, int r, List<String> subString) {
        if (r >= str.length()) {
            if (l == r) {
                subStrings.add(new ArrayList<>(subString));
            }
            return;
        }

        if (isPalindrome(str, l, r)) {
            subString.add(str.substring(l, r+1)); // add next char to current substring
            subStrings(str, r + 1, r + 1, subString); // so here we add substring now we only want to consider the remaining characters..
            subString.remove(subString.size() - 1 ); // remove this so we can back track below and go to the next node in the same level..
        }

        subStrings(str, l, r + 1, subString);
    }

    private boolean isPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}
