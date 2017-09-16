### QuickSort
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.


1) Always pick first element as pivot.
2) Always pick last element as pivot (implemented below)
3) Pick a random element as pivot.
4) Pick median as pivot.

The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.

![alt text](material/QuickSort.png)

````
public int partition(int arr[], int low, int high){
    int pivot = arr[high]; 
    int i = (low-1); // index of smaller element
    for (int j=low; j<high; j++)
    {
        // If current element is smaller than or
        // equal to pivot
        if (arr[j] <= pivot)
        {
            i++;

            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;

    return i+1;
}

````
Recursive Quick Sort [QuickSort.java](QuickSort.java)
````
void qSort(int arr[], int low, int high) {
    if (low < high) {
        /* pi is partitioning index, arr[pi] is
          now at right place */
        int pi = partition(arr, low, high);

        // Recursively sort elements before
        // partition and after partition
        qSort(arr, low, pi - 1);
        qSort(arr, pi + 1, high);
    }
}
````
1) The above implementation uses last index as pivot. This causes worst-case behavior on already sorted arrays, which is a commonly occurring case. The problem can be solved by choosing either a random index for the pivot, or choosing the middle index of the partition or choosing the median of the first, middle and last element of the partition for the pivot.

2) To reduce the recursion depth, recur first for the smaller half of the array, and use a tail call to recurse into the other.

3) Insertion sort works better for small sub-arrays. Insertion sort can be used for invocations on such small arrays (i.e. where the length is less than a threshold t determined experimentally).

Iterative Quick Sort [IterativeQuickSort.java](IterativeQuickSort.java)
````
void quickSort(int arr[], int l, int h) {
    // create auxiliary stack
    int stack[] = new int[h - l + 1];

    // initialize top of stack
    int top = -1;

    // push initial values in the stack
    stack[++top] = l;
    stack[++top] = h;

    // keep popping elements until stack is not empty
    while (top >= 0) {
        // pop h and l
        h = stack[top--];
        l = stack[top--];

        // set pivot element at it's proper position
        int p = partition(arr, l, h);

        // If there are elements on left side of pivot,
        // then push left side to stack
        if (p - 1 > l) {
            stack[++top] = l;
            stack[++top] = p - 1;
        }

        // If there are elements on right side of pivot,
        // then push right side to stack
        if (p + 1 < h) {
            stack[++top] = p + 1;
            stack[++top] = h;
        }
    }
}
````
The above mentioned optimizations for recursive quick sort can also be applied to iterative version.

1) Partition process is same in both recursive and iterative. The same techniques to choose optimal pivot can also be applied to iterative version.

2) To reduce the stack size, first push the indexes of smaller half.

3) Use insertion sort when the size reduces below a experimentally calculated threshold.

Referenced: [Referenced](http://en.wikipedia.org/wiki/Quicksort) 