package xiecheng20180904;

import java.util.*;

public class Main3 {

    public static class MyMap {
        int size;
        HashMap<Integer, Integer> map1;
        HashMap<Integer, Integer> map2;

        public MyMap() {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
        }

        public void put(int key, int value) {
            if (!map1.containsKey(key)) {
                size++;
                map2.put(key, 1);
            }
            map1.put(key, value);
        }

        public int get(int key) {
            if (!map1.containsKey(key))
                return -1;
            map2.put(key, map2.get(key) + 1);
            return map1.get(key);
        }

        public void remove() {
            size--;
            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList(map2.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
            map1.remove(list.get(0).getKey());
            map2.remove(list.get(0).getKey());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyMap map = new MyMap();
        int max = in.nextInt();
        while(in.hasNextLine()){
            String s = in.next();
            if(s.equals("p")){
                int key = in.nextInt();
                int value = in.nextInt();
                if(map.size==max&&!map.map1.containsKey(key)){
                    map.remove();
                }
                map.put(key,value);
            }else{
                int key = in.nextInt();
                System.out.println(map.get(key));
            }
        }
        in.close();
    }
}
