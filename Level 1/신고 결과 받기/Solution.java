import java.util.*;

public class Solution {
    int k;

    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<User> userList = new ArrayList<>();
        this.k = k;

        for (String id : id_list) {
            User user = new User(id);
            userList.add(user);
        }

        for (String r : report) {
            String[] ra = r.split(" ");
            User s = userList.get(userList.indexOf(new User(ra[0])));
            User o = userList.get(userList.indexOf(new User(ra[1])));
            s.reportSomeone(o);
        }

        int[] answer = new int[userList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = userList.get(i).countReported();
        }

        return answer;
    }

    private class User {
        private String id;
        private int reportedNum;
        private Set<User> reportList;
        private boolean suspended;

        public User(String id) {
            this.id = id;
            reportedNum = 0;
            reportList = new HashSet<>();
            suspended = false;
        }

        public void reportSomeone(User u) {
            if (!reportList.contains(u)) {
                reportList.add(u);
                u.reportedBySomeone();
            }
        }

        public void reportedBySomeone() {
            reportedNum++;
            if (reportedNum >= k) {
                suspended = true;
            }
        }

        public int countReported() {
            int cnt = 0;
            for (User u : reportList) {
                if (u.getSuspended()) {
                    cnt++;
                }
            }
            return cnt;
        }

        public String getId() {
            return id;
        }

        public boolean getSuspended() {
            return suspended;
        }

        @Override
        public boolean equals(Object u) {
            if (u instanceof User) {
                return ((User) u).getId().equals(this.id);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
