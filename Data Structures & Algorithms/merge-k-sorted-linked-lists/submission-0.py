# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        result: Optional[ListNode] = []

        if not lists:
            return None

        # result = lists[0] # this should be a list
        # divide... top down
        while len(lists) > 1:
            merged = []
            for i in range(0, len(lists), 2):
                a = lists[i]
                b = lists[i + 1] if i + 1 < len(lists) else None
                merged.append(self.mergeSortStarter(a, b))
            lists = merged

        return lists[0]

    def mergeSortStarter(self, a: Optional[ListNode], b: Optional[ListNode]) -> Optional[ListNode]:
        # conquer
        # actually since they already sorted.. only write code to merge?
        dummy = ListNode()
        tail = dummy
       
        # merge elements of b int result
        while( a and b):
            if ( a.val <= b.val):
                tail.next = a
                a = a.next
            else:
                tail.next = b
                b = b.next
            tail = tail.next
        
        tail.next = a or b
        return dummy.next



        
        