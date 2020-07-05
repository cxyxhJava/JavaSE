import java.util.*;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:09 2020-01-02
 * @ Description：
 * @ Modified By：
 */
public class SumMain {

    public static void main(String[] args) throws Exception {
        int[] nums = {3,2,4};
        int target = 6;

        SumMain sumMain = new SumMain();
        int[] result = sumMain.twoSum1(nums,target);
        for (int i : result) {
            System.out.println(i);
        }

        int[][] grid = { {1,1,1},{1,0,1},{1,1,1}};
    }


    public int[] twoSum(int[] nums,int target){
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];

                if (a+b == target){
                    result.add(i);
                    result.add(j);
                }
            }

        }
        int[] resultInt = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }


    public int[] twoSum1(int[] nums,int target) throws Exception {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (Integer integer : map.keySet()) {
            Integer a = target-integer;
            if (map.containsKey(a)){
                return new int[]{map.get(integer),map.get(a)};
            }
        }
        throw new Exception();
    }

}
