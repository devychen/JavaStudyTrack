# Java Notes

### Shortcuts
[ArrayList](https://github.com/devychen/JavaStudyTrack/blob/main/ArrayList.md) <br>

[Generics](https://github.com/devychen/JavaStudyTrack/blob/main/Generics.md) <br>
[LinkedList](https://github.com/devychen/JavaStudyTrack/blob/main/LinkedList.md) <br>


### IntelliJ tips <br>
How to create projects [online tutorial](https://www.youtube.com/watch?v=c0efB_CKOYo)
1. Blue folder icon is the source folder. <br> If it's not the intended one, right click "Mark Directory as" - "Sources Root"
2. Green icon is the test source folder.
3. To create a test for class: <br> right click or option+enter on the class name within the code file.
4. "src" is called _source code_

### Some tips
- `i`在每次迭代后都会自动增加1（这是`for`循环的默认行为）
- `public void`方法用于执行操作而不返回任何值，而非 void 方法用于执行操作并返回一个值供调用者使用。
```java
// example
public void printMessage(String message) {
    System.out.println(message);
}
// example
public int add(int a, int b) {
    return a + b;
}
```
- `Class` vs `Type`
- `String s: someNames`:
```java
for (String s : someNames) { // WHY - 读取someNames中的每一个元素并且赋予s。Equals to:
                            // for (int i = 0; i < someNames.size(); i++) {
                            //     String s = someNames.get(i);}
            allNames.add(s);
        }
```
- ArrayList method
```java
ArrayList arrayList = new ArrayList<>();
arrayList.add();
arrayList.addAll();
```