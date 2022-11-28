

### 构造数组

> 输入一个 int 类型的值 $N$，构造一个长度为 $N$ 的数组 `arr` 并返回。
>
> 要求：对于任意的 `i<k<j`，都满足 `arr[i] + arr[j] != 2 * arr[k]`



其中一种思路：（有很多种解法）

构造一个序列 `{i, k, j}`，满足 `[i] + [j] ≠ 2 * [k]`

比如 `{2, 1, 3}`，对他进行 **“ 奇变换 ”** ，可以是 `{3, 1, 5}` 分表代表 `第 i 个奇数`

**“ 偶变换 ”** 同理为：`{2, 0, 4}`

将他们拼接到一起为 `{3, 1, 5, 2, 0, 4}` 同样满足条件

同理可以继续向上找长度为 12 的数组



 <img src="images/array.assets/image-20210829175146135.png" alt="image-20210829175146135" style="zoom:80%;" />



> **Master 公式**，计算递归方式的复杂度：
>
> **$T(N) = a * T(N/b) + O(N^d)$**

参数：

- `a` 子过程调用次数
- `b` 子过程数据规模
- `d` 其他的时间复杂度

关系：

| 关系         | T(N)复杂度      |
| ------------ | --------------- |
| $logb^a < d$ | $O(N^d)$        |
| $logb^a > d$ | $O(N^{logb^a})$ |
| $logb^a = d$ | $O(N^d * logN)$ |

 

### bfprt算法

又称为中位数的中位数算法，线性查找数组中第 K 大（小）的数

链接：

- https://en.wikipedia.org/wiki/Median_of_medians
- https://brilliant.org/wiki/median-finding-algorithm/
- https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/866686/java-median-of-medians-solution-beats-99-with-comments-to-explain-the-algorithm



### 刷题

1. **业务题**。注重分析能力，最优解就是在该题专有的业务上，找到聪明的做法。
2. **技巧题**。背后有一个数据结构、特殊算法，可以进行推广。









