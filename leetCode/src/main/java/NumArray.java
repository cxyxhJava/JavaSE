/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:48 2020-07-05
 * @ Description：
 * @ Modified By：
 */
public class NumArray {
    /**
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     *
     * 示例：
     *
     * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     *
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     * 说明:
     *
     * 你可以假设数组不可变。
     * 会多次调用 sumRange 方法。
     * @param args
     */
    public static void main(String[] args){
        System.out.println(sumRange(0,2,new int[]{-2, 0, 3, -5, 2, -1}));
        System.out.println(sumRange(2,5,new int[]{-2, 0, 3, -5, 2, -1}));
        System.out.println(sumRange(0,5,new int[]{-2, 0, 3, -5, 2, -1}));
    }

    public static int sumRange(int i, int j,int[] nums) {

        int result = 0;
        for (int k = 0; k < nums.length; k++) {
            if (k>=i&&k<=j){
                result+=nums[k];
            }
        }
        return result;
    }

}
