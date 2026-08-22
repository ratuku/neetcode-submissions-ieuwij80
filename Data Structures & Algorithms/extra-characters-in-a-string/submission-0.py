class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False

    

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word):
        currNode = self.root;
        for char in word:
            if char not in currNode.children:
                currNode.children[char] = TrieNode()
            currNode = currNode.children[char]
        currNode.isWord = True

    def addWords(self, lists):
        for word in lists:
            self.addWord(word)



class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        trie = Trie()
        trie.addWords(dictionary)

        # now search via dps and return min char left
        memo = {}

        def dfs(i):
            # base case
            if i == len(s):
                return 0

            # return stored calculation
            if i in memo:
                return memo[i]

            # 1) treat s[i] as an extra char calculate from the next index
            result = 1 + dfs(i+1)

            # Begin process of finding number of extra char sarting from 1
            node = trie.root

            for j in range(i, len(s)):
                char = s[j]

                if char not in node.children:
                    break

                node = node.children[char]

                if node.isWord:
                    result = min(result, dfs(j+1))

            # save the answer of this index
            memo[i] = result
            return result    
        return dfs(0)





