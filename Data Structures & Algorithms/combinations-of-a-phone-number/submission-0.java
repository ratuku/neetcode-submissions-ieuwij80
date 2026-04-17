class Solution {

    private final Map<Character, List<Character>> map = new HashMap<>() {{
      put('2', List.of('a', 'b', 'c'));  
      put('3', List.of('d', 'e', 'f')); 
      put('4', List.of('g', 'h', 'i'));
      put('5', List.of('j', 'k', 'l'));
      put('6', List.of('m', 'n', 'o'));  
      put('7', List.of('p', 'q', 'r', 's')); 
      put('8', List.of('t', 'u', 'v'));
      put('9', List.of('w', 'x', 'y', 'z'));   
}};
    private List<String> result;
    private List<Character> options;


    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        StringBuilder combo = new StringBuilder();
        int n = digits.length();

        backTrack(digits, combo, n, 0, 0);
        return result;
    }

    private void backTrack(String digits, StringBuilder combo, int n, int digiPos, int charPos) {
        // digiPos >> digitPosition
        // charPos >> characterPosition
        // we have iterated through all digits.. return
        if (digiPos == n) {
            // we have a full combination
            if (combo.length() > 0) {
                result.add(combo.toString());
            }
            return;
        }

        // dive deeper (depth)  >> next digit
        options = map.get(digits.charAt(digiPos));
        if (charPos == options.size()) {
            // we have exhausted all options for this digit
            return;
        }
        combo.append(options.get(charPos)); // picked an option
        backTrack(digits, combo, n, digiPos + 1, 0);  // move to next digitPosition

       // dive wider (breath) >> move to the next character/option of the same position/digit
       combo.deleteCharAt(combo.length() - 1); // we backtrack here, undo our choice
       backTrack(digits, combo, n, digiPos, charPos + 1);
    }
}
