package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leecode17 {
    List<String> result = new ArrayList<>();
    StringBuffer temp = new StringBuffer();
    List<String> digitList = Arrays.asList(
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        // 这里要在开头就剪掉""，不然digits="" 时，进入backtracking后返回的是"",而不是[]
        // 中间的""不用管
        if (digits==null||digits.isEmpty()) return result;
        backtracking(digits,0);
        return result;
    }

    // n表示输入的数字串digits遍历到第几个数字了
    private void backtracking(String digits,int n) {
        if (n == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // 表示当前数字所代表的字符串
        String str = digitList.get(digits.charAt(n)-'0');
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(digits,n+1);
            temp.deleteCharAt(temp.length()-1);

        }
    }
}
