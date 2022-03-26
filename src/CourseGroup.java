import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseGroup {

    public static HashMap<String, List<String>> pairsCourse(List<String> input) {
        List<Integer> userIdList = new ArrayList<>();
        HashMap<Integer, List<String>> userCourseMapping = new HashMap<>();
        HashMap<String, List<String>> ans = new HashMap<>();
        for (String userId : input) {
            String userIds[] = userId.split(",");
            if (!userIdList.contains(Integer.parseInt(userIds[0]))) {
                userIdList.add(Integer.parseInt(userIds[0]));
            }
            if (userCourseMapping.containsKey(Integer.parseInt(userIds[0]))) {
                List<String> tempList = userCourseMapping.get(Integer.parseInt(userIds[0]));
                if (!tempList.contains(userIds[1])) {
                    tempList.add(userIds[1]);
                }
                userCourseMapping.put(Integer.parseInt(userIds[0]), tempList);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(userIds[1]);
                userCourseMapping.put(Integer.parseInt(userIds[0]), temp);
            }
        }
        for (int i = 0; i < userIdList.size(); i++) {
            for (int j = i + 1; j < userIdList.size(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(userIdList.get(i));
                sb.append(',');
                sb.append(userIdList.get(j));
                List<String> userId1 = userCourseMapping.get(userIdList.get(i));
                List<String> userId2 = userCourseMapping.get(userIdList.get(j));
                int k = 0;
                List<String> commonCourses = new ArrayList<>();
                while (k < userId1.size()) {
                    if (userId2.contains(userId1.get(k))) {
                        commonCourses.add(userId1.get(k));
                    }
                    k++;
                }
                ans.put(sb.toString(), commonCourses);
            }
        }
        return ans;
    }




}