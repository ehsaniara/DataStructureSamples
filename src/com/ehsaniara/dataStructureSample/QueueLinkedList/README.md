# Queue (With Linked List)
In the previous post, we introduced Queue and discussed array implementation. In this post, linked list implementation is discussed. The following two main operations must be implemented efficiently.

In a Queue data structure, we maintain two pointers, front and rear. The front points the first item of queue and rear points to last item.

### enQueue() 
This operation adds a new node after rear and moves rear to the next node.

### deQueue() 
This operation removes the front node and moves front to the next node.

