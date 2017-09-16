# Merge Sort for Linked Lists

MergeSort(headRef)
1) If head is NULL or there is only one element in the Linked List 
    then return.
2) Else divide the linked list into two halves.  
     * FrontBackSplit(head, &a, &b); /* a and b are two halves */
3) Sort the two halves a and b.
     * MergeSort(a);
     * MergeSort(b);
4) Merge the sorted a and b (using SortedMerge()) and update the head pointer using headRef.
     * headRef = SortedMerge(a, b);

Sources: [LinkedListProblems.pdf](http://cslibrary.stanford.edu/105/LinkedListProblems.pdf)