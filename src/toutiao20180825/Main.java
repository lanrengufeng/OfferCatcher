package toutiao20180825;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Node> nodes = new ArrayList<>();
		int res = n;
		for (int i = 1; i <= n; i++)
			nodes.add(new Node(i));
		UnionFindSet ufs = new UnionFindSet(nodes); // 初始化并查集
		for (int i = 0; i < n; i++) {
			Node node = nodes.get(i); // 编号为i+1的人
			int cur = in.nextInt(); // i+1认识的人的编号
			while (cur != 0) {
				Node tmp = nodes.get(cur - 1); // 编号为cur的人
				if (!ufs.isSameSet(node, tmp)) {
					res--; // 编号i+1与cur尚未合并过，合并，总数-1
					ufs.union(node, tmp);
				}
				cur = in.nextInt();
			}
		}
		System.out.println(res);
		in.close();
	}

	public static class Node {
		public int val;

		public Node(int val) {
			this.val = val;
		}
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet(List<Node> nodes) {
			makeSets(nodes); // 调用makeSets()初始化并查集
		}

		/**
		 * 初始化并查集
		 * 
		 * @param nodes
		 */
		private void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		public Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node)
				father = findHead(father);
			fatherMap.put(node, father);
			return father;
		}

		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null)
				return;
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize >= bSetSize) {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				}
			}
		}
	}
}
