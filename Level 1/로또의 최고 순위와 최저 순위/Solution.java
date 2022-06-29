import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Set<Integer> winNumSet = new HashSet<>();

        for (int w : win_nums) {
            winNumSet.add(w);
        }

        int common = 0;
        int zero = 0;

        for (int l : lottos) {
            if (l == 0) {
                zero++;
            } else if (winNumSet.contains(l)) {
                common++;
            }
        }

        int[] answer = new int[2];
        answer[0] = (common + zero != 0) ? 7 - (common + zero) : 6;
        answer[1] = (common != 0) ? 7 - common : 6;

        return answer;
    }
}