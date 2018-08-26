package zhihu20180827;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目名称：求并集 时间限制：1000ms 题目描述：输出两个单向有序链表的并集 如链表 A {1 -> 2 -> 5 -> 7} 链表 B {3 -> 5 -> 7 -> 8} 输出: {1
 * -> 2 ->3 -> 5 -> 7 ->8} 。（测试用例仅做参考，我们会根据代码质量进行评分）
 * 
 * 输入描述：第一行输入整数n，m,(1<=n,m<=1000)分别表示两个链表的长度。 第二行给出A链表所包含元素。(1<=a<=1000) 第三行给出B链表所包含元素。(1<=b<=1000)
 * 
 * 输出描述：按题目描述输出。 示例1 输入 4 4 1 2 5 7 3 5 7 8 输出 1 -> 2 ->3 -> 5 -> 7 ->8
 * 
 * @author Watcher
 *
 */
public class Main {
	public static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		int cur = in.nextInt();
		Node p1 = new Node(cur);
		Node p1cur = p1;
		for (int i = 0; i < n - 1; i++) {
			cur = in.nextInt();
			p1cur.next = new Node(cur);
			p1cur = p1cur.next;
		}
		cur = in.nextInt();
		Node p2 = new Node(cur);
		Node p2cur = p2;
		for (int i = 0; i < m - 1; i++) {
			cur = in.nextInt();
			p2cur.next = new Node(cur);
			p2cur = p2cur.next;
		}
		Node preHead = new Node(-1);
		Node node = preHead;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				node.next = p1;
				node = node.next;
				p1 = p1.next;
			} else if (p1.val > p2.val) {
				node.next = p2;
				node = node.next;
				p2 = p2.next;
			} else {
				node.next = p1;
				node = node.next;
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		if (p1 != null)
			node.next = p1;
		if (p2 != null)
			node.next = p2;
		node = preHead.next;
		while (node.next != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.print(node.val);
		in.close();
	}*/
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr1 = new int[n],arr2 = new int[m];
		for(int i=0;i<n;i++)
			arr1[i] = in.nextInt();
		for(int i=0;i<m;i++)
			arr2[i] = in.nextInt();
		int p1=0,p2=0;
		while(p1<n&&p2<m){
			if(arr1[p1]<arr2[p2])
				list.add(arr1[p1++]);
			else if(arr1[p1] > arr2[p2])
				list.add(arr2[p2++]);
			else{
				list.add(arr1[p1++]);
				p2++;
			}
		}
		while(p1<n)
			list.add(arr1[p1++]);
		while(p2<m)
			list.add(arr2[p2++]);
		for(int i=0;i<list.size()-1;i++)
			System.out.print(list.get(i)+" -> ");
		System.out.println(list.get(list.size()-1));
		in.close();
	}
}
