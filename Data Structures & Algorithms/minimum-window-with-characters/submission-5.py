class Solution:
    def minWindow(self, s: str, t: str) -> str:
        "Try the approach of tracking unique char in t"
        if t == "":
            return ""

        # loop over t
        dict_t = {}
        for i in t:
            dict_t[i] = dict_t.get(i, 0) + 1
        
        res = [-1, -1]
        resLen = float("infinity")

        current_c, need_c = 0, len(dict_t)
        window = {}
        # now start with a window that expands to right but contracts from the left
        l = 0
        r = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = window.get(c, 0) + 1

            # Add it only when needed
            if c in dict_t and window[c] == dict_t.get(c, 0):
                current_c += 1

            while (current_c == need_c):
                # is window better than best result
                if (r - l + 1 < resLen):
                    res = [l, r]
                    resLen = r - l + 1 # why not len(window)
                
                window[s[l]] -= 1
                if s[l] in dict_t and window[s[l]] < dict_t.get(s[l], 0):
                    # so we removed what is needed hence decrement current_c
                    current_c -= 1
                l += 1

        
        if (resLen == float("infinity")):
            return ""
        else:
            return s[res[0]:res[1] + 1]

