# Catcher of Offers
-------------
## 面试笔试真题记录

--------------------------

## 拼多多2018.8.6 java工程师笔试题:

1. [第1题：](https://github.com/lanrengufeng/OfferCatcher/blob/master/src/pinduoduo/Main.java)
- 字符串拼接

2. [第2题：](https://github.com/lanrengufeng/OfferCatcher/blob/master/src/pinduoduo/Main2.java)
- 只需要考虑首位是否是0就行

3. [第3题：](https://github.com/lanrengufeng/OfferCatcher/blob/master/src/pinduoduo/Main3.java)
- 将所有信息放入ArrayList，遍历找最大共同个数即可

4. [第4题：](https://github.com/lanrengufeng/OfferCatcher/blob/master/src/pinduoduo/Main4.java)
- 动态规划+回溯

-------------------------

## 字节跳动2018.8.25

1. [第1题](https://github.com/lanrengufeng/OfferCatcher/blob/master/src/toutiao20180825/Main.java)
- blabla···，团队共有n个人，这n个人每个人都提供了自己认识的人的名字，不包括自己，如果A的名单有B，或者B的名单有A，则代表A与B认识，同时如果A认识B，B认识C，则代表A与C也会很快认识。根据这个名单，将n个人分成m组，每组人数可以不同，但是组内的任何一个人与其他人都必须直接或者间接认识，如何确定一个方案，使得m最小。
- 输入描述：
> 第一行一个整数n，代表有n个人，从1开始编号。
接下来有n行，第x+1行代表编号为x的人认识的人的编号k，(1<=k<=n)，每个人的名单以0代表结束。

- 示例：
> 输入：  
10  
0  
5 3 0  
8 4 0  
9 0  
9 0  
3 0  
0  
7 9 0  
0  
9 7 0  

> 输出：
2

- 说明：
> 1号同学孤独地自己一个组，因为他谁也不认识，也没人认识他，其他人均可以间接或者直接认识，分在同一个组。

- 思路： 使用并查集可以很好地解决这种问题
- [Union Find Set](https://github.com/lanrengufeng/AlgorithmCode/blob/master/src/search/UnionFind.java)


---------------

## 中兴通信2018.8.28

1.[第一题](https://github.com/lanrengufeng/OfferCatcher/blob/master/src/zhongxing20180828/Solution.java)  
- 输入一行01字符串，表示一个满二叉树的层级遍历结果，1表示有效结点，0表示null。层级遍历每一个有效结点，求距离当前结点的最远结点和当前结点的距离。
- 输出： 一个非负整数列表

- 示例
- 输入
> network = 111110000010000

- 输出
> [3,2,4,3,3,4]

- 思路： 题意即求二叉树中每一个结点的最远路径。对于结点cur来说，结果只可能是max(cur的左右子树的最大深度  , 递归(cur的父结点的另一子结点的最大深度+2))。 
- 具体参见代码。




