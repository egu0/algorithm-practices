
## 好题应细品

### 1、技巧题

技巧题特点：背后有一个数据结构、特殊算法，可以进行推广。

#### 【未分类】

1. [明明的随机数](https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0) - 位图，拓展：比如求1亿个整数的最大前10个整数，先分块，而每一小块就可以用该方法计算，最后在归并
2. [放苹果](https://www.nowcoder.com/practice/bfd8234bb5e84be0b493656e390bdebf) - 常规dp，重点在子问题划分
3. [质数因子](https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607) - 分解质因数
4. [购物单](https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4) - 动态规划，01背包问题变形
5. [最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/) - 字符串、栈
6. [组合总和II](https://leetcode.cn/problems/combination-sum-ii/) - 回溯、剪枝（经典题）
7. [全排列I](https://leetcode.cn/problems/permutations/)，[全排列II](https://leetcode.cn/problems/permutations-ii/) - 回溯、剪枝（经典）
8. [正则表达式匹配](https://leetcode.cn/problems/regular-expression-matching/)，[通配符匹配](https://leetcode.cn/problems/wildcard-matching/comments/) - 经典字符串dp
9. [吃苹果的最大数目](https://leetcode.cn/problems/maximum-number-of-eaten-apples/) - 贪心、优先级队列

#### 图论

1. [882.细分图中的可到达节点](https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/) - dijkstra

### 2、业务题

业务题特点：注重分析能力，最优解就是在该题专有的业务上，找到聪明的做法。

1. [1753. 移除石子的最大得分](https://leetcode.cn/problems/maximum-score-from-removing-stones/)
2. [895. 最大频率栈](https://leetcode.cn/problems/maximum-frequency-stack/)

### 题目来源

1. CF_ 开头题目来自 https://codeforces.com/
2. HJ 开头题目来自 https://www.nowcoder.com/exam/oj
3. XN 字母+数字表示题目缩写+编号，来自 https://leetcode.cn/
4. 其他，demo程序

### 多线程题目

1. [三个线程按序打印123](https://leetcode.cn/problems/print-in-order/) - wait/notify/notifyAll, Lock等 ⭐
