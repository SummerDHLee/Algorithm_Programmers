import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        String[] ss = s.split(" ");

        for (String n : ss) {
            list.add(Integer.parseInt(n));
        }

        Collections.sort(list);

        return Integer.toString(list.get(0)) + " " + Integer.toString(list.get(list.size() - 1));

    }
}