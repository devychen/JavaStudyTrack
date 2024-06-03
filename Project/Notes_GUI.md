### Basics

1. **Components**

### Flow Layout

1. FlowLayout是一种布局管理器，它按照一定的方向排列组件，就像段落中的文字一样。具体的排列方向由容器的componentOrientation属性决定，可以是从左到右（LEFT_TO_RIGHT）或从右到左（RIGHT_TO_LEFT）。

2. FlowLayout的特点
FlowLayout通常用于在面板中排列按钮。它会水平排列按钮，直到当前行放不下更多按钮，然后换到下一行继续排列。行的对齐方式由align属性决定，可以是以下几种值：
```java
FlowLayout.LEFT //左对齐
FlowLayout.RIGHT //右对齐
FlowLayout.CENTER //居中对齐
FlowLayout.LEADING //按照当前语言的方向对齐（左到右或右到左）
FlowLayout.TRAILING //与当前语言的方向相反对齐
```

### Border Layout
BorderLayout是一种布局管理器，它将容器分为五个区域，每个区域可以放置一个组件。每个区域最多只能包含一个组件。
这五个区域分别是：
```java
BorderLayout.NORTH  //（北部）
BorderLayout.SOUTH  //（南部）
BorderLayout.EAST   //（东部）
BorderLayout.WEST   //（西部）
BorderLayout.CENTER //（中部）
```
如果你在同一个区域添加多个组件，只有最后一个组件会被显示。
如果你想在某个区域放置多个组件，可以创建一个容器（比如JPanel），然后将多个组件添加到这个容器，再将容器添加到这个区域。

#### vs FlowLayout
- BorderLayout：
    - 将容器分成五个区域（北、南、东、西、中），每个区域最多只能包含一个组件。
可以使用JPanel等容器在一个区域中放置多个组件。
适合用于需要将界面分成多个固定区域的情况。<br>
- FlowLayout：
    - 按顺序排列组件，类似于文本在一行中排列，当一行放不下时会自动换行。
适合用于简单的组件排列，比如按钮的排列。

### Grid Layout
1. **基本**
- GridLayout是一种布局管理器，它将组件按照行和列的网格形式排列。
- 在GridLayout中，所有的单元格都具有相同的大小。

2. **使用方式**
- 要创建一个GridLayout，你需要指定行数和列数。例如，要创建一个2行3列的布局：
```java
getContentPane.setLayout(new GridLayout(2, 3));
```

3. **特点**
- 网格布局：所有的组件按照网格的形式排列，每个组件占据一个单元格。
- 单元格大小：所有的单元格大小相同，由布局自动计算。
- 添加组件：通过调用add()方法将组件添加到布局中。组件的位置由添加的顺序决定，第一个添加的组件在第一个单元格，第二个添加的组件在第二个单元格，依此类推。

### Box Layout

1. 什么是BoxLayout？<br>
BoxLayout是一种布局管理器，它可以将组件垂直或水平地堆叠在一起。
与GridLayout或BorderLayout不同，BoxLayout在布局时会尊重组件的首选大小。

2. 创建BoxLayout <br>
要创建一个BoxLayout，你需要向BoxLayout的构造函数传递容器和一个方向参数。
方向可以是垂直方向`（BoxLayout.Y_AXIS）`或水平方向`（BoxLayout.X_AXIS）`

```java
BoxLayout aBoxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
```

3. BoxLayout的常量
BoxLayout的方向由以下常量确定：
```java
BoxLayout.Y_AXIS    //垂直方向，从上到下排列组件
BoxLayout.X_AXIS    //水平方向，从左到右排列组件
```

4. 使用Box类创建间距
Box类提供了用于创建不可见的“空间”组件的方法。你可以在组件之间放置这些空间，以获得可伸缩或固定大小的间距。

> 可伸缩空间：可伸缩空间就像两个组件之间的弹簧。当你调整这两个组件的大小时，弹簧会伸展并将组件推开。
固定空间：固定空间始终保持相同的大小，即使你调整窗口大小也不会改变。

#### BoxLayout vs. BorderLayout：
布局方式：
- BoxLayout：BoxLayout可以将组件垂直或水平地堆叠在一起，组件之间可以有固定或可伸缩的间距。
- BorderLayout：BorderLayout将容器划分为五个区域（北、南、东、西、中），每个区域可以放置一个组件。<br>

组件排列：
- BoxLayout：适合于将多个组件垂直或水平排列在一起，可以创建具有弹性间距的布局。
- BorderLayout：适合于在界面上定义不同功能区域，每个区域可以放置一个主要的组件。<br>

适用场景：
- BoxLayout：适用于需要动态调整组件间距或实现自定义布局的情况，特别是适合于创建简单但灵活的用户界面。
- BorderLayout：适用于需要将界面划分为不同功能区域的情况，例如创建一个具有标题、内容和底部工具栏的应用程序界面。

### Controlling the size of components & Dimensionality
当你在设计Swing界面时，经常需要控制组件的大小。有时候，Swing布局管理器会按照自己的规则来确定组件的大小，但**BoxLayout**却能接受你设置的大小。为了改变组件的大小，你可以使用以下方法：

设置组件的大小：
你可以使用以下方法来设置组件的大小：
```java
setMinimumSize(Dimension minimumSize)   //设置组件的最小大小
setMaximumSize(Dimension maximumSize)   //设置组件的最大大小
setPreferredSize(Dimension preferredSize)   //设置组件的首选大小
```
然而，有些方法可能会在不同的情况下表现得不同。有时候，我发现只有`setMaximumSize()`方法生效了。但为了确保效果，你可以使用相同的Dimension实例来调用这三个方法。

#### Dimension 类
Dimension类用于指定宽度和高度，或者水平距离和垂直距离。你可以通过以下方式来创建一个Dimension实例：

```java
Dimension size = new Dimension(10, 100);
```

### Button and Action Listener

按钮和事件监听器 <br>
- 要添加一个按钮，你可以像我们之前创建JLabel对象一样创建一个JButton对象。
- 主要的区别在于，当你点击按钮时，一个JButton对象可能会触发一个动作。
- 执行这个动作的类必须实现ActionListener接口。
- 这个接口包含一个方法：`void actionPerformed(ActionEvent e)`

事件监听器 <br>
- 很多例子都是在设置JFrame的类中实现ActionListener接口。但这可能不是一个很好的做法。当你有多个按钮在你的界面上时，这会变得非常难以阅读和维护。
- 更好的做法是为每个按钮实现一个ActionListener类。你可以使用`void addActionListener(ActionListener l)`方法将监听器添加到按钮上。

> More example: `TestFrame8.java`, `ButtonListenerExample.java`

### List and ListListener

JList组件允许你显示一个对象列表，并且用户可以从列表中选择一个或多个项目。默认情况下，JList对象不提供滚动列表的方式。要启用此功能，必须将JList包装在JScrollPane中。

列表中选项的选择与你的代码之间的连接是通过实现ListSelectionListener接口的类来实现的。该接口要求实现一个方法：`public void valueChanged(ListSelectionEvent event)`。

要将监听器添加到列表中，请在JList中使用`void addListSelectionListener(ListSelectionListener listener)`方法。每当你点击列表中的一个项目，或者使用光标键改变选择时，选择处理程序就会被调用。

#### Accessing the selected item (访问所选项目)
要访问列表中所选的项目，JList类提供了以下方法：

`Object getSelectedValue()` 
- 返回第一个选定的值，如果选择为空，则返回null。

`int getSelectedIndex()` 
- 返回第一个选定元素的第一个索引；如果没有选定的项目，则返回-1。

#### List datamodels (列表数据模型)
列表显示的数据存储在一个模型中。当我们使用数组作为模型创建JList时，我们只能读取列表中的元素。我们可以使用标准的访问方法从列表中检索元素。但是，一旦我们添加元素，程序将崩溃。

#### Building your own ListModel (更改列表中的值)
要改变值，我们必须使用DefaultListModel类的实例替换只读模型。这个类提供了在列表中的特定索引处添加或删除元素的方法。如果我们想要向JList添加元素或从JList中删除元素，我们必须更改底层的列表模型。

要编辑DefaultListModel的内容，你可以使用以下方法：

`void addElement(Object obj)`
- 将指定的组件添加到此列表的末尾。

`void add(int index, Object element)`
- 在此列表中的指定位置插入指定的元素。

`Object remove(int index)` 
- 删除此列表中指定位置的元素。

> Another Example: `TestFrame9.java`, `TestFrame10.java`

### Text Fields (文本字段)

到目前为止，我们只使用了JLabel对象来在界面上显示文本。对于编辑单行文本，Swing提供了一个JTextField组件。每个JTextField组件只显示一定数量的字符。你可以输入更多文本到文本字段中，但超过文本字段列数的额外文本不会显示出来。

要改变文本字段中的文本，你必须调用`public void setText(String t)`方法；

要获取文本字段的内容，调用`public String getText()`方法。

### Dialog boxes (对话框)

在编程中，经常需要显示消息或要求用户确认某个操作。Swing提供了在JOptionPane类中预定义的对话框。

#### To get a message box use (获取一个消息框)
```java
JOptionPane.showMessageDialog(frame, "单词已经在列表中。");
// 这里，frame是对话框的parent window。
```

#### To get a confirmation dialog (获取一个确认对话框)
```java
int result = JOptionPane.showConfirmDialog(frame, "确定要删除这个元素吗？");
```

`showConfirmDialog()`方法会显示消息字符串和三个按钮：“是”、“否”和“取消”。当用户选择“是”时，方法返回YES_OPTION；当用户选择“否”时，返回NO_OPTION；当用户选择“取消”时，返回CANCEL_OPTION。

#### To enter a single line of text(输入单行文本)
```java
String userInput = JOptionPane.showInputDialog(frame, "请输入单词：");
```
`JOptionPane.showInputDialog()`方法会显示消息字符串和一个文本字段，用户可以在其中输入文本。

如果你想提供一个预定义的文本字段条目，可以将`initialSelectionValue`设置为所需的值。该方法返回文本字段中的文本。


