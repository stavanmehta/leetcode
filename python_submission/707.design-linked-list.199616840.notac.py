class Node(object):

    def __init__(self, value, nextNode=None):
        self.val = value
        self.next = nextNode


class MyLinkedList(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.size = 0

    def get(self, index):
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        :type index: int
        :rtype: int
        """
        if index < 0 or index >= self.size:
            return -1
        counter = 0
        curr = self.head
        while curr:
            if counter == index:
                return curr.val
            counter += 1
            curr = curr.next

    def addAtHead(self, val):
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        :type val: int
        :rtype: void
        """
        node = Node(val)
        if self.head:
            node.next = self.head
            self.head = node
        else:
            self.head = node
        self.size += 1

    def addAtTail(self, val):
        """
        Append a node of value val to the last element of the linked list.
        :type val: int
        :rtype: void
        """
        node = Node(val)
        if not self.head:
            self.head = node
        else:
            curr = self.head
            while curr.next:
                curr = curr.next
            curr.next = node
        self.size += 1

    def addAtIndex(self, index, val):
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        :type index: int
        :type val: int
        :rtype: void
        """
        if self.size == 0 or index == 0:
            self.addAtHead(val)
        else:
            node = Node(val)
            counter = 0
            curr = self.head
            while curr:
                if counter == index-1:
                    node.next = curr.next
                    curr.next = node
                    self.size += 1
                    return
                else:
                    curr = curr.next


    def deleteAtIndex(self, index):
        """
        Delete the index-th node in the linked list, if the index is valid.
        :type index: int
        :rtype: void
        """
        curr = self.head

        if index == 0 and self.size == 1 and self.head:
            self.head = None
            self.size -= 1
        elif self.size > 1:
            counter = 0
            prev = None
            next = self.head

            while next:
                if counter == index:
                    prev.next = next.next
                    self.size -= 1
                    return
                else:
                    prev = next
                    next = next.next
                    counter += 1
     

    # Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
