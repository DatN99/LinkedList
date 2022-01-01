# LinkedList

src/com/company/LinkedList stores pointers for the head and tail of the linked list. The length is used for searching/insertion/deletion at a specific
location.

This is a doubly reversed linked list. It's time complexity is O(N) time. It's actually O(N/2) for insertion and deletion
since it determines whether to iterate normally from the head or iterate backwards to find the position for insertion/deletion
However, the 1/2 constant is ignored

Supported operations: 

add -> initializes ndoe and adds node to end of list
insert -> initializes node and inserts at specific position
insertNewHead -> insert node at head position
insertBetween -> insert node between two nodes
remove -> removes node at specified position
removeNode -> removes specified node between specified surrounding nodes
print-> prints linked list

mergeTwoLists -> merges two lists where new list has sorted nodes in ascending order.


