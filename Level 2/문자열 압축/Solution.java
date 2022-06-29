class Solution {
    public int solution(String s) {

        if (s.length() == 1) {
            return 1;
        }

        int[] len = new int[s.length() / 2];

        for (int i = 0; i < len.length; i++) {
            len[i] = getLen(s, i);
        }

        int answer = len[0];
        for (int l : len) {
            if (l < answer) {
                answer = l;
            }
        }
        return answer;
    }

    private int getLen(String s, int i) {
        String tmp = s;
        int len = 0;

        while (tmp.length() > i + 1) {
            String cmp = tmp.substring(0, i + 1);
            tmp = tmp.substring(i + 1);
            len += i + 1;
            int cnt = 0;
            for (int k = 0; k < tmp.length() / (i + 1); k++) {
                if (tmp.substring((i + 1) * k, (i + 1) * (k + 1)).equals(cmp)) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt != 0) {
                len += Math.log10(cnt + 1) + 1;
                tmp = tmp.substring(cnt * (i + 1));
            }
        }
        len += tmp.length();

        return len;
    }
}