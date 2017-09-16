# Hashing
Suppose we want to design a system for storing employee records keyed using phone numbers. And we want following queries to be performed efficiently:

1. Insert a phone number and corresponding information.
1. Search a phone number and fetch the information.
1. Delete a phone number and related information.

We can think of using the following data structures to maintain information about different phone numbers.

1. Array of phone numbers and records.
1. Linked List of phone numbers and records.
1. Balanced binary search tree with phone numbers as keys.
1. Direct Access Table.

For **arrays** and **linked lists**, we need to search in a linear fashion, which can be costly in practice. If we use arrays and keep the data sorted, then a phone number can be searched in O(Logn) time using Binary Search, but insert and delete operations become costly as we have to maintain sorted order.

With **balanced binary search tree**, we get moderate search, insert and delete times. All of these operations can be guaranteed to be in O(Logn) time.

Another solution that one can think of is to use a **direct access table** where we make a big array and use phone numbers as index in the array. An entry in array is NIL if phone number is not present, else the array entry stores pointer to records corresponding to phone number. Time complexity wise this solution is the best among all, we can do all operations in O(1) time. For example to insert a phone number, we create a record with details of given phone number, use phone number as index and store the pointer to the created record in table.
This solution has many practical limitations. First problem with this solution is extra space required is huge. For example if phone number is n digits, we need O(m * 10n) space for table where m is size of a pointer to record. Another problem is an integer in a programming language may not store n digits.


Hashing is an improvement over Direct Access Table. The idea is to use hash function that converts a given phone number or any other key to a smaller number and uses the small number as index in a table called hash table.

### Hash Table: 
An array that stores pointers to records corresponding to a given phone number. An entry in hash table is NIL if no existing phone number has hash function value equal to the index for the entry.

### What is Collision?
Since a hash function gets us a small number for a key which is a big integer or string, there is possibility that two keys result in same value. The situation where a newly inserted key maps to an already occupied slot in hash table is called collision and must be handled using some collision handling technique.

### How to handle Collisions?
There are mainly two methods to handle collision:
1) Separate Chaining
2) Open Addressing
In this article, only separate chaining is discussed. We will be discussing Open addressing in next post.

## Separate Chaining:
The idea is to make each cell of hash table point to a linked list of records that have same hash function value.

Let us consider a simple hash function as “key mod 7” and sequence of keys as 50, 700, 76, 85, 92, 73, 101.

![](material/hashChaining1.png)

#### Advantages:
1) Simple to implement.
2) Hash table never fills up, we can always add more elements to chain.
3) Less sensitive to the hash function or load factors.
4) It is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.

#### Disadvantages:
1) Cache performance of chaining is not good as keys are stored using linked list. Open addressing provides better cache performance as everything is stored in same table.
2) Wastage of Space (Some Parts of hash table are never used)
3) If the chain becomes long, then search time can become O(n) in worst case.
4) Uses extra space for links.

## Separate Chaining:

Like separate chaining, open addressing is a method for handling collisions. In Open Addressing, all elements are stored in the hash table itself. So at any point, size of table must be greater than or equal to total number of keys (Note that we can increase table size by copying old data if needed).

Insert(k): Keep probing until an empty slot is found. Once an empty slot is found, insert k.

Search(k): Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.

Delete(k): Delete operation is interesting. If we simply delete a key, then search may fail. So slots of deleted keys are marked specially as “deleted”.
Insert can insert an item in a deleted slot, but search doesn’t stop at a deleted slot.

Open Addressing is done following ways:

#### a) Linear Probing: 
In linear probing, we linearly probe for next slot. For example, typical gap between two probes is 1 as taken in below example also.
let hash(x) be the slot index computed using hash function and S be the table size

````
If slot hash(x) % S is full, then we try (hash(x) + 1) % S
If (hash(x) + 1) % S is also full, then we try (hash(x) + 2) % S
If (hash(x) + 2) % S is also full, then we try (hash(x) + 3) % S 
..................................................
..................................................
````
Let us consider a simple hash function as “key mod 7” and sequence of keys as 50, 700, 76, 85, 92, 73, 101.


![](material/openAddressing1.png)

##### Clustering: 
The main problem with linear probing is clustering, many consecutive elements form groups and it starts taking time to find a free slot or to search an element.

#### b) Quadratic Probing 
We look for i2‘th slot in i’th iteration.

````
let hash(x) be the slot index computed using hash function.  
If slot hash(x) % S is full, then we try (hash(x) + 1*1) % S
If (hash(x) + 1*1) % S is also full, then we try (hash(x) + 2*2) % S
If (hash(x) + 2*2) % S is also full, then we try (hash(x) + 3*3) % S
..................................................
..................................................

````

#### c) Double Hashing 
We use another hash function hash2(x) and look for i*hash2(x) slot in i’th rotation.

````
let hash(x) be the slot index computed using hash function.  
If slot hash(x) % S is full, then we try (hash(x) + 1*hash2(x)) % S
If (hash(x) + 1*hash2(x)) % S is also full, then we try (hash(x) + 2*hash2(x)) % S
If (hash(x) + 2*hash2(x)) % S is also full, then we try (hash(x) + 3*hash2(x)) % S
..................................................
..................................................

````

### Open Addressing vs. Separate Chaining
##### Advantages of Chaining:
1) Chaining is Simpler to implement.
2) In chaining, Hash table never fills up, we can always add more elements to chain. In open addressing, table may become full.
3) Chaining is Less sensitive to the hash function or load factors.
4) Chaining is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.
5) Open addressing requires extra care for to avoid clustering and load factor.

##### Advantages of Open Addressing
1) Cache performance of chaining is not good as keys are stored using linked list. Open addressing provides better cache performance as everything is stored in same table.
2) Wastage of Space (Some Parts of hash table in chaining are never used). In Open addressing, a slot can be used even if an input doesn’t map to it.
3) Chaining uses extra space for links.


References:

http://courses.csail.mit.edu/6.006/fall11/lectures/lecture10.pdf
https://www.cse.cuhk.edu.hk/irwin.king/_media/teaching/csc2100b/tu6.pdf