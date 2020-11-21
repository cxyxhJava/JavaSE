/**
 * @author franyang
 * @date 2020/11/21
 */
public class 统计位数为偶数的数字 {

    public static void main(String[] args) {
        Integer[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }


    /**
     *
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     *
     * 输入：nums = [12,345,2,6,7896]
     * 输出：2
     * 解释：
     * 12 是 2 位数字（位数为偶数） 
     * 345 是 3 位数字（位数为奇数）  
     * 2 是 1 位数字（位数为奇数） 
     * 6 是 1 位数字 位数为奇数） 
     * 7896 是 4 位数字（位数为偶数）  
     * 因此只有 12 和 7896 是位数为偶数的数字
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */

    public static int findNumbers(Integer[] nums) {
        Integer count = 0;
        for (Integer num : nums) {
            String numStr = num.toString();
            count = numStr.length()%2==0?count+1:count;
        }
        return count;
    }

}
