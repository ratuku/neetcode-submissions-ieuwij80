class TrieNode:

    def __init__(self):
        self.children = [None] * 26
        self.isEndOfWord = False

class PrefixTree:

    def __init__(self):
        self.node = TrieNode();
    
    def insert(self, word: str) -> None:
        # loop over char of str
        node = self.node

        for char in word:
            index = ord(char) - ord('a')

            if (node.children[index] is None):
                node.children[index] = TrieNode()
            
            node = node.children[index]
        
        node.isEndOfWord = True


    def search(self, word: str) -> bool:
        node = self.node

        for char in word:
            index = ord(char) - ord('a')

            if node.children[index] is None:
                return False
            
            node = node.children[index]

        if node.isEndOfWord is True:
            return True
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        node = self.node

        for char in prefix:
            index = ord(char) - ord('a')

            if node.children[index] is None:
                return False
            
            node = node.children[index]
        
        return True

