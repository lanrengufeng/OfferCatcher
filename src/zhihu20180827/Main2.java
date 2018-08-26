package zhihu20180827;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目名称：计算逆波兰表达式的结果 时间限制：1000ms 题目描述：逆波兰记法中，操作符置于操作数的后面。例如表达“三加四”时，写作“3 4 +”，而不是“3 +
 * 4”。如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”在逆波兰记法中写作“3 4 - 5
 * +”：先3减去4，再加上5。使用逆波兰记法的一个好处是不需要使用括号。例如中缀记法中“3 - 4 * 5”与“（3 - 4）*5”不相同，但后缀记法中前者写做“3 4 5 *
 * -”，无歧义地表示“3 (4 5 *) -”；后者写做“3 4 - 5 *”。（测试用例仅做参考，我们会根据代码质量进行评分）
 * 
 * 输入描述：第一行输入一个整数 n，表示包含元素数量.(1<=n<=1000) 第二行输入n个元素。
 * 
 * 输出描述：输出计算后的结果。 示例1 输入 2 1 + 3 * 输出 9
 * 
 * @author Watcher
 *
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			String s = in.next();
			if (!s.isEmpty()&&s.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (s.equals("-")) {
				int tmp = stack.pop();
				stack.push(stack.pop() - tmp);
			} else if (s.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (s.equals("/")) {
				int tmp = stack.pop();
				stack.push(stack.pop() / tmp);
			} else {
				stack.push(Integer.valueOf(s));
			}
		}
		System.out.println(stack.pop());
		in.close();
	}
}
