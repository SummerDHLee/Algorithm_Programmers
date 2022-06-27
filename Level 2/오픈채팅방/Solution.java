import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> userInfo = new HashMap<>();
        String message = "";

        for (String r : record) {
            String[] s = r.split(" ");
            if (s[0].equals("Enter")) {
                userInfo.put(s[1], s[2]);
                message += "E" + s[1] + " ";
            } else if (s[0].equals("Leave")) {
                message += "L" + s[1] + " ";
            } else {
                userInfo.put(s[1], s[2]);
            }
        }

        String[] smessage = message.split(" ");

        String[] answer = new String[smessage.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = userInfo.get(smessage[i].substring(1)) + retMessage(smessage[i].charAt(0));
        }
        return answer;
    }

    private String retMessage(char c) {
        if (c == 'E')
            return "님이 들어왔습니다.";
        else
            return "님이 나갔습니다.";
    }
}