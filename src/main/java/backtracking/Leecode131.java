package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leecode131 {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex==s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex,i+1);
            if (ischeck(str)){
                path.add(str);
                backtracking(s,i+1);
                path.removeLast();
            }
        }
    }
    // 判断是否是回文
    private boolean ischeck(String sb) {
        for (int i = 0; i < sb.length()/ 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){return false;}
        }
        return true;
    }
}
