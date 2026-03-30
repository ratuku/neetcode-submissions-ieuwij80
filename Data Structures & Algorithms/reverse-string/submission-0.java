// loop through the array
// have pointers l,r
// swap values in those positions
// exit when l>=r


class Solution {
    public void reverseString(char[] s) {
        int r = s.length - 1;
        int l = 0;
        char holdRValue;

        while (r > l) {
            holdRValue = s[r];
            s[r] = s[l];
            s[l] = holdRValue;
            r--;
            l++;
        }

        System.out.println(s);
    }
}