# 古诗字符串处理程序
## 一、实验目的
利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，达到如下功能：

1. 每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”

2. 允许提供输入参数，统计古诗中某个字或词出现的次数

3. 考虑操作中可能出现的异常，在程序中设计异常处理程序

## 二、任务
1. 利用字符串String及其方法对古诗做对齐处理
2. 设计系统的输入/输出，把处理结果保存在文件中存储
3. 包含异常处理结构
4. 系统的界面采用二选一：
    * 使用GUI窗体界面，设计各组件，完成用户与系统的交互
    * 控制台（Console）

## 三、实验核心方法

​              运用String类来对字符串进行处理，先是确定一个main方法，然后对字符串进行输入，输出，异常，查询等处理。

![JL2OaR.png](https://s1.ax1x.com/2020/04/30/JL2OaR.png)

## 四、核心代码

```java
public static String handler(String text) {
    int size = 7;
    char odd = '，';
    char even = '。';
    String poetry = "";
    for (int i = 0; i < text.length(); i++) {
        poetry += text.charAt(i);
        if ((i + 1) % size == 0) {
            if ((i + 1) % 2 == 1) {
                poetry += odd;
            } else {
                poetry += even;
                poetry += '\n';
            }
        }
    }
    return poetry;
}
```

## 五、实验结果
![JLceRU.png](https://s1.ax1x.com/2020/04/30/JLceRU.png)

## 六、收获

​        通过此次实验，我发现我有很多不会的地方，有些功能虽然通过看书和网上查询找到了方法，但是将它们结合起来成为一个整体还有很多不足，程序经常出现各种各样的问题，但经过询问和查询再经过慢慢调试，最终运行成功，对于import java.io.*;等类的使用熟练了一点，例如import java.io.FileWriter将数据写入文件中等。还额外了解到了odd表示奇数，even表示偶数等其他知识。



