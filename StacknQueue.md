[Return to contents](https://github.com/devychen/JavaStudyTrack/tree/main/README.md)

# Stack

- 用于存储方法调用&局部变量的内存区域；
- 栈的大小和生命和走其实确定的，在方法执行完毕时，对应的栈会被销毁；
- 是一种后进先出（先进后出-LIFO）的数据结构，通过压栈(push)和出栈(pop)的方式来管理数据；
    ```java
    import java.util.* // stack<T> as a class is defined in pkg java.util
    Stack<String> myStack = new Stack<String>();
    String name = null;
    myStack.push("adventurine"); 
    myStack.push("keigen");
    name = myStack.pop(); // this will delete "keigen" as it's on the top
    name = myStack.pop(); // will delete "aventurine"
    ```
- 其访问速度相对较快，因为它按照固定的地址进行访问；



