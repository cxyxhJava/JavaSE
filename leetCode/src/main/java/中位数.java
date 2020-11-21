/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:27 2020-07-08
 * @ Description：
 * @ Modified By：
 */
public class 中位数 {

    public static void main(String[] args){
        int[] a = {1,2,3,7,8,11,13};
        int[] b = {1,4,5,6,20,100};
        System.out.println(get中位数(a,b));
    }


    /**
     * 思路:接上一个方法的思路,我们既然只是只是取中位数,那么我们其实只需要拿到两个数组总长/2或者两个数组总长/2+1的值就可以了,不需要后半部分的数据,那么就可以缩短循环.
     * @param a
     * @param b
     * @return
     */
    private static int get中位数方法1(int[] a, int[] b){

        return 0;
    }

    /**
     *
     * 思路:将两个有序数组合并为一个有序数组,直接获取合并后的有序数组
     * 这个方案的优化点就在于,两个数组的合并优化
     * @param a
     * @param b
     * @return
     */
    private static int get中位数(int[] a, int[] b){
        int bIndex = 0;
        int count = 0;
        int[] c = new int[a.length+b.length];
        //循环a数组
        for (int i = 0; i < a.length; i++) {
            int aValue = a[i];
            //a数据内循环b数组 双层循环 添加bIndex冒泡算法模式
            for (int j = bIndex; j < b.length; j++) {
                int bValue = b[j];
                //a值小于等于b值 保存a值退出b数组循环,因为后续的值一定大于a
                if (aValue<=bValue){
                    c[count] = aValue;
                    count++;
                    break;
                }else {
                    //a值大于b值 保存b值继续b数组循环,保存b数组的值,一直到b数组小于等于a的值保存到c数组
                    c[count] = bValue;
                    bIndex = j+1;
                    count++;
                }
            }
        }
        //b数组 未处理的数据处理
        for (int i = bIndex; i < b.length; i++) {
            c[count] = b[i];
            count++;
        }
        //计算已经排序好的C数组中位数
        Integer result;
        if (c.length%2==0){
            result = c[c.length/2];
        }else {
            result = (c[(c.length-1)/2]+c[(c.length+1)/2])/2;
        }
        return result;
    }




}
