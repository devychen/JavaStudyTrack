## ArrayList & LinkedList & Generics
- Introduce **ADT (Abstract Data Type)**, which contains 7 types. !*注意区分abstract method (add, remove, get)*
    - **Bag**: unordered collection
    - **List**: a collection that numbers its items
    - **Stack**: chronologically ordered items, last in first out
    - **Queue**: chronologically ordered items, first in first out
    - **Dictionary**: paris of items (with one being a key), can be sorted or not
    - **Tree**: hierarchically arranged
    - **Graph**: generalisation of a tree
    - Other terminology:
        - **Collection**: an ADT that contains a group of objects
        - **Container**: a class that implements the collection
    - ADT in java is represented as an Interface `List<T>`
        - *remember that a class can implement ≥ 1 interface(s).
- Introduce **dynamic** data structure: i.e. the size could grow/shrink while program running.
    - 2 kinds: class `ArrayList` of array-based data structure, `linked list` of linked data structures (data items are linked to one another so that one data item knows wehre the next one is.)
    - *Also mentioned: `inner classses`, a kind of class definition within antoher class definition


### Abstract Data Types


### Class `Arraylist`
- Dynamic and variable-length (compared to `array` which is static and fixed-length)
- Two drawbacks: 1/ base type can't be primitive types, use wrapper classes; 2/ instances are less efficient than arrays
- to use it 
    - must import: `import java.util.*;`
    - syntax: 
    ```java
    ArrayList<String> list = new ArrayList<String>(50)
    // The ArrayList list stores objects of type String and has an initial capacity of 50.
    ArrayList<Base_Type> name = new ArrayList<Base_Type>(initialCapacity);
    // base_type could be any reference_type incl. class, interface, generic, ...
    // use wrapper_classes (Integer, Double, ...) for primitive_types.
    ```
- Changing elements
    - Add: `list.add(new Word("the"));`
    - Get: `list.get(3);`
    - Insert: `list.add(1, new Word("vicious"));` now "vicious" is at index 1, the prev moved down/forward
    - Remove: `list.remove(1);`, `list.remove(new Word("children"));`
    - 0 ≤ index < size()
- is a collection class
    - collection classes implement the `Collection` interface
    - special for-loop syntax
    `for (Base_Type variable : collectionObject){}`

### Generics
- Parameters to parameterise a data type
- included in class definitions
- In classes and methods, use a **type parameter** instead of **a specific data type**
- Type `Generic`
    - A generic class or interface that is parmeterised over types;
    - Declare a generic class: add <T> element after the classname;
    - T for "Type", K - Key, E - Element...
- Could also be used in interface 

### Linked Data Structure
1. **Linked lists**: 
    - a group of objects (called nodes) that are connected by references (called links).
    - predefined, `import java.util`, could also self-defined.
    - **NullPointException**: indicate access to an object has been attempted using a null reference - no object is referenced by the variable. No need to be caught/declared in a `throws` clause.
- Inner classes
    - the inner & outer classes have access to each other's methods and instance variable, even declared private.
- Iterators
    - External iterator: place all the elements of a linked list into an array and “step through” the elements by iterating the array;
    - Internal iterator: one that uses an instance variable to step through the nodes.
    - To implement iteration of a collection of objects: implementing Interface `Iterator<T>`.
        - methods incl.: `next`, `hasNext`, `remove`


## Access Modifiers & Packages

#### Modifiers
| Modifier    | Class | Package | Subclass | World |
|-------------|-------|---------|----------|-------|
| public      | y     | y       | y        | y     |
| protected   | y     | y       | y        | n     |
| No modifier | y     | y       | n        | n     |
| pricate     | y     | n       | n        | n     |
#### Packages
- Defn: a named collection of related classes that can serve as a library of classes, it groups a set of classes together into a directory.
- `import`: import all classes from a pkg: `import java.io.*`
- Defining own pkg: 
    - folder name (directory) is the pkg name; 
    - each class in the pkg has `package Package_Name` as the first statement.
    - For example: our package will be named lib.helpers, so we will store the package in the directory lib/helpers



## Stack n Queues

## Recursion

## OpenNLP

## Maven

## Java 8

## Else
1. `this`
```java
public class Pouch {
    private String value;
    public Pouch() {}
    public Pouch( String value ) {
        this.value = value; 
        // 带一个字符串参数的构造函数，接收一个字符串并将其赋值给value
    }
    public void set(String value){
        this.value = value;
        // 定义一个名为set的公众方法，可以设置Pouch中保存的字符串的值
    }
}

// 
public class ObjectPouchMain(){
    Pouch pouch = new Pouch(Integer.valueOf("12"));
    // 创建了一个名为pouch的Pouch 对象，并将字符串 "12" 转换为整数后存入其中
}
```
2. abstract method <br>
`void`与否无关
3. In `interface` we define set of methods, which then have to be realised through `class`
- Comparable<T> interface: to compare one object to another
    - `int result = obj1.compareTo(obj2);`
    - return negative if obj1 < obj2; 0 if obj1 = obj2; positive if obj1 > obj2; 
- List<T> interface: to store and maintain an ordered collection (sequence/list) of fdata
    - import needed: `java.util`
4. Data structure is used to organise data in a specific way