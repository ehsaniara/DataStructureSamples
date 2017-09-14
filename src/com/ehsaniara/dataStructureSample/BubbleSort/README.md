# Bubble Sort
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.


````
public void sort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++)
        for (int j = 0; j < arr.length - i - 1; j++)
            if (arr[j] > arr[j + 1]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
}

````

## Example:
### First Pass:
Here, algorithm compares the first two elements, and swaps since 5 > 1.

( 5 1 4 2 8 ) –> ( 1 5 4 2 8 )

Swap since 5 > 4

( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 )

Swap since 5 > 2

( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 )

Now, since these elements are already in order (8 > 5), algorithm does not swap them.

( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )

### Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )

 Swap since 4 > 2

( 1 4 2 5 8 ) –> ( 1 2 4 5 8 )

( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )

Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

### Third Pass:
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )