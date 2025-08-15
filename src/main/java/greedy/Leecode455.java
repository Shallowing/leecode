package greedy;

import java.util.Arrays;

public class Leecode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // 统计满足孩子的个数
        int count = 0;
        // 从小到大拿饼干，最小的饼干和最小胃口的孩子比较
        for (int i = 0; i < s.length; i++) {
            if (count<g.length && s[i]>=g[count]){
                count++;
            }
        }
        return count;
    }
}
