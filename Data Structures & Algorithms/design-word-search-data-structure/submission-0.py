class TrieNode:
    
    def __init__(self):
        self.children = [None]*26
        self.endOfLine = False


class WordDictionary:

    def __init__(self):
        self.node = TrieNode()
        

    def addWord(self, word: str) -> None:
        node = self.node
        # charCount = 2

        for char in word:
            index = ord(char) - ord('a')

            if node.children[index] == None:
                node.children[index] = TrieNode()

            node = node.children[index]
        
        node.endOfLine = True
        

    def search(self, word: str) -> bool:
        return self.dfs(0, self.node, word)


    def dfs(self, index, node: TrieNode, word: str) -> bool:

        for i in range(index, len(word)):
            char = word[i]

            if char == '.':
                # now we have to check over all children henceforth
                # find a way to loop over all children and use list or recursion. might have to change this function.
                for child in node.children:
                    if child is not None:
                        if self.dfs(i+1, child, word):
                            return True
                return False

            else:    
                onlyChildIndex = ord(char) - ord('a')

                if node.children[onlyChildIndex] is None:
                    return False
                
                node = node.children[onlyChildIndex]

        return node.endOfLine


        
