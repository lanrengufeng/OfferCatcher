package zhongxing20180828;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().minStrength("111110000010000"));

	}

	List<Integer> minStrength(String network) {
		List<Integer> res = new ArrayList<>();
		char[] cs = network.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '0')
				continue;
			int len = getLength(cs, i, 0);
			int len2 = getLength2(cs, i, 0);
			res.add(Math.max(len, len2));
		}
		return res;
	}

	private int getLength2(char[] cs, int index, int len) {
		if (index == 0)
			return len;
		int father = (index - 1) / 2;
		if (father * 2 + 1 == index) { // 当前结点为左子树
			len = Math.max(getLength(cs, father * 2 + 2, 0) + 2, getLength2(cs, father, 0) + 1);
		} else { // 当前结点为右子树
			len = Math.max(getLength(cs, father * 2 + 1, 0) + 2, getLength2(cs, father, 0) + 1);
		}
		return len;
	}

	/**
	 * 求左右子树的最大深度
	 * 
	 * @param cs
	 * @param index
	 * @param len
	 * @return
	 */
	private int getLength(char[] cs, int index, int len) {
		if (index >= cs.length || index < 0 || cs[index] == '0')
			return len - 1;
		int left = getLength(cs, index * 2 + 1, len + 1);
		int right = getLength(cs, index * 2 + 2, len + 1);
		return Math.max(left, right);
	}
}
