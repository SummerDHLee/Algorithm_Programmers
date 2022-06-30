class Solution {
    String hand;
    int l, r;
    String answer;

    public String solution(int[] numbers, String hand) {

        this.hand = (hand.equals("left")) ? "L" : "R";
        l = 10;
        r = 12;

        answer = "";

        for (int n : numbers) {
            switch (n) {
                case 1:
                case 4:
                case 7:
                    l = n;
                    answer += "L";
                    break;
                case 3:
                case 6:
                case 9:
                    r = n;
                    answer += "R";
                    break;
                default:
                    decideHand(n);
            }
        }
        return answer;
    }

    private void decideHand(int n) {
        if (n == 0) {
            n = 11;

        }

        int dl = Math.abs(l - n);
        int dr = Math.abs(r - n);

        dl = (dl / 3) + (dl % 3);
        dr = (dr / 3) + (dr % 3);

        if (dl < dr) {
            l = n;
            answer += "L";
        } else if (dl > dr) {
            r = n;
            answer += "R";
        } else {
            if (hand == "L") {
                l = n;
            } else {
                r = n;
            }
            answer += hand;
        }

    }
}
