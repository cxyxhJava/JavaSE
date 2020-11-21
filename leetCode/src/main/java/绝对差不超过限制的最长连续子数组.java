import java.util.HashSet;
import java.util.Set;

/**
 * @author franyang
 * @date 2020/11/20
 *
 * 绝对差不超过限制的最长连续子数组
 *
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class 绝对差不超过限制的最长连续子数组 {


    public static void main(String[] args) {
        int[] numbers = {10,1,2,4,7,2};
        int limit = 5;
        int[] numbers2 = {8,2,4,7};
        int limit2 = 4;

        //排序 找到最大最小值.

        System.out.println(longestSubarray(numbers,limit));
        System.out.println(longestSubarray(numbers2,limit2));


    }

    /**
     * 实现解析
     *
     * 1.一次循环,判断绝对
     *
     * @param numbers
     * @param limit
     * @return
     */
    private static int longestSubarray(int[] numbers,int limit){
        return 0;
    }
}
