# ArrayList
[Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) <br>
[Online Tutorial](https://www.youtube.com/watch?v=NbYgm0r7u6o)
[Linked List Tutorial](https://www.youtube.com/watch?v=N6dOwBde7-M)
- A class. Has the same purpose as an array but can change in length while program is running.
- Resizable-array implementation of the `List` interface. 
Implements all optional list operations, and permits all elements, 
including null. 
- In addition to implementing the `List` interface, 
this class provides methods to manipulate the size of the array 
that is used internally to store the list. 
(This class is roughly equivalent to Vector, except that it is unsynchronised.)

### VS Array
Array is static in size. <br>
ArrayList is dynamic in size. <br>
An array is a fixed-length data structure. <br> 
ArrayList is a variable-length data structure. <br>
You cannot use generic for Array. <br>
Two drawbacks:
1. You cannot store primitives in ArrayList, it can only contain Objects. While Array can contain both. <br>
2. Using an instance of `ArrayList` is less efficient than using an array.