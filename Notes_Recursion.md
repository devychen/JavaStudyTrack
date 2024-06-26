# Recursion

- Making a function call itself when executing
- vs **Loop**
 -


### Example Syntax <br>

```java
public class Main {
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result); // 输出: 120
    }
    
    public static int factorial(int n) {
        // 递归基
        if (n == 0 || n == 1) {
            return 1;
        }
        // 递归调用
        return n * factorial(n - 1);
    }
}
```

### Examples 
```java
// Use recursion to add all of the numbers up to 10.
public class Main {
  public static void main(String[] args) {
    int result = sum(10);
    System.out.println(result);
  }
  public static int sum(int k) {
    if (k > 0) {
      return k + sum(k - 1);
    } else {
      return 0;
    }
  }
}

```

```java
// Use recursion to add all of the numbers between 5 to 10.
public class Main {
  public static void main(String[] args) {
    int result = sum(5, 10);
    System.out.println(result);
  }
  public static int sum(int start, int end) {
    if (end > start) {
      return end + sum(start, end - 1);
    } else {
      return end;
    }
  }
}
```