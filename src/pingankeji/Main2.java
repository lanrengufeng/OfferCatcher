package pingankeji;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.isEmpty())
                break;
            String[] cur = s.split(" ");
            double sum = 0;
            for (int i = 1; i < cur.length; i++)
                sum += Integer.valueOf(cur[i]);
            int num = (int) Math.round(sum / (cur.length - 1));
            map.put(cur[0], num);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry s : list)
            System.out.println(s.getKey() + " " + s.getValue());
        in.close();
    }
}
