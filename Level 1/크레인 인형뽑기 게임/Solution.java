import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();

        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    int tmp = board[i][m - 1];
                    board[i][m - 1] = 0;

                    if (basket.size() == 0)
                        basket.push(tmp);
                    else {
                        int tmp2 = basket.pop();
                        if (tmp != tmp2) {
                            basket.push(tmp2);
                            basket.push(tmp);
                        } else
                            answer += 2;
                    }
                    break;

                }

            }
        }

        return answer;
    }
}