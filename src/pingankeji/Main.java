package pingankeji;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<TreeNode> list = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.isEmpty())
                break;
            String[] ss = s.split(" ");


        }
        in.close();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
