import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author franyang
 * @date 2020/11/21
 */
public class 滑动窗口算法 {

    public static void main(String[] args) {
        int[] numbers = {10,1,2,4,7,2};
        int limit = 5;
        int[] numbers2 = {8,2,4,7};
        int limit2 = 4;

        int[] numbers3 = {2,4,7,2,2,10,1,2,4,7,2};
        int limit3 = 5;

        int[] numbers4 = {2,4,7,2,2,10,2,2};
        int limit4 = 5;


        滑动窗口算法 solution = new 滑动窗口算法();

        System.out.println(solution.longestSubarray(numbers,limit));
        System.out.println(solution.longestSubarray(numbers2,limit2));
        System.out.println(solution.longestSubarray(numbers3,limit3));
        System.out.println(solution.longestSubarray(numbers4,limit4));

    }
    /**
     * 此方法计算的size是对的,对应的数组是错的
     * */
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0)
            return 0;
        int curr_max = nums[0]; // 当子数组下最大值 这里初始化为第一个数
        int curr_min = nums[0]; // 当子数组下最大值 这里初始化为第一个数
        Queue<Integer> sub_nums = new LinkedList<Integer>();
        for (int num : nums) {
            if (Math.abs(num - curr_max) <= limit && Math.abs(num - curr_min) <= limit && Math.abs(curr_max - curr_min) <= limit) {
                curr_max = Math.max(num, curr_max);
                curr_min = Math.min(num, curr_min);
                sub_nums.offer(num);
            } else {
                sub_nums.offer(num);
                sub_nums.poll();
                curr_max = Collections.max(sub_nums); // 当子数组最大值
                curr_min = Collections.min(sub_nums); // 当前子数组最小值
            }
        }
        return sub_nums.size();
    }




//    public int longestSubarray(int[] nums, int limit) {
//        /*
//            维护两个单调双端队列
//            一个最大队（队首元素 peek() 为最大值），一个最小队
//            目的是为了避免 重新 遍历数组 来获取 某个范围内的 最大值和最小值
//
//            (
//                我们之前维护单调值的是使用使用单调栈，那么判断数据就是使用栈顶元素
//                这里使用队列，那么判断数据就是使用队尾元素（即最后入队的元素）
//
//                比如最大队列，队头为最大值，那么后面加入的值 num 如果比 前面加入的值 还大，那么 最大值 就跟 前面的加入值 无关
//                因为前面的值最先入队，也是最先出队的，它无论出不出队，最大值都是 后面入队的这个值 num
//                同理，最小队也一样
//            )
//        */
//        Deque<Integer> maxQ = new LinkedList<Integer>();
//        Deque<Integer> minQ = new LinkedList<Integer>();
//
//        int mlen = 0;
//
//        int len = nums.length;
//        for(int left = 0, right = 0; right < len; ){
//            //维护最大队
//            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right]){
//                maxQ.pollLast();
//            }
//            maxQ.add(right);
//            //维护最小队
//            while(!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right]){
//                minQ.pollLast();
//            }
//            minQ.add(right);
//            /*
//                maxQ 的 peek() 是 [left, right] 中的最大值
//                minQ 的 peek() 是 [left, right] 中的最小值
//
//                nums = [8,2,4,7], limit = 4
//                idx     0 1 2 3
//                首先插入 8 和 2
//                队列情况如下：
//                maxQ = {1, 0}   （peek() == 0）
//                minQ = {1}      （peek() == 1）
//
//                滑动窗口区间：[0, 1]
//
//                我们发现最大值和最小值的差 > 4，因此我们需要找到舍弃某些值，重新划定窗口区间
//                因为最大值的索引位置为 0，最小值的索引位置为 1，因此我们舍弃掉 0 位置 及前面的值，将 left 指向 0 后面的一个值，即 1
//            */
//            /*
//            这里不会出现队列为空的情况
//            因为上面最大队 和 最小队都添加了 right，即滑动窗口右边界的值
//            那么表示它们之中必定存在一个相同的索引位置，绝对值差为 0，不会超过 limit，因此不会 poll()
//            */
//            while(nums[maxQ.peek()] - nums[minQ.peek()] > limit){
//                //哪个索引在前面就去除掉哪个，然后将 left 指向该位置的后一个位置，相当于去除掉前面所有值
//                if(maxQ.peek() < minQ.peek()){
//                    left = maxQ.poll() + 1;
//                }else{
//                    left = minQ.poll() + 1;
//                }
//            }
//            right++;
//            mlen = Math.max(mlen, right - left);
//        }
//        return mlen;
//    }
}
