package com;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
/**
 *
 * 中文题目：
 *   给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *   你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *   示例：
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 *
 *  英文题目：
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 */
public class NodeClass {
    /**
     * @author commonsstring@gmail.com
     * 方案一 ： 蛮力法
     * 时间复杂度: O(N^2)
     * 思路：
     *     a + b = target;
     *     b = target - a;
     *     由上面的式子, 可知只需要在遍历数组的时候, 查看数组中是否存在 target - a。
     *     注意题设:
     *         1, 同样的元素不能被重复利用
     *         2, 每个输入只对应一种答案
     */
    public static int[] twoSumFirst(int[] nums, int target) {
        //参数判断
        if(nums.length < 1 || nums == null) return null;
        int[] arr = new int[2];
        for(int i = 0, len = nums.length; i < len; i++){
            //计算b的值
            int val = target - nums[i];
            for (int j = 0; j < len; j++) {
                // j != i ：解决同样的元素不能被重复利用
                if(val == nums[j] && j != i){
                    arr[0] = i;
                    arr[1] = j;
                    //每个输入只对应一种答案
                    return arr;
                }
            }
        }
        return arr;
    }

    /**
     * @author commonsstring@gmail.com
     * 方案二 ： 空间换时间
     * 时间复杂度：0(N)
     * 思路：
     *     与方案一相同。
     *     不过, 我们可以利用哈希表存储数据。
     *     比如： key : 存储数组的值, value ：存储数组的下标。
     *     注意题设:
     *         1, 同样的元素不能被重复利用
     *         2, 每个输入只对应一种答案
     */
    public static int[] twoSumNumSecond(int[] nums, int target){
        //参数检查
        if(nums.length < 1 || nums == null) return null;
        //返回结果
        int[] result = new int[2];
        //key：存数组的数值，value：存数组的下标
        HashMap<Integer, Integer> mHashMap = new HashMap<Integer, Integer>();
        //存储
        for(int i = 0, len = nums.length; i < len; i++)  mHashMap.put(nums[i], i);
        //查找
        for(int j = 0, len = nums.length; j < len; j++){
            int val = target - nums[j];
            if(mHashMap.containsKey(val) && j != mHashMap.get(val)){
                result[0] = j;
                result[1] = mHashMap.get(val);
                return result;
            }
        }
        return result;
    }


    /**
     * @author commonsstring@gmail.com
     * 方案三 ：前后夹击, 滑动法
     * 时间复杂度：O(N + N * logN )
     * 思路：
     *     首先, 将数组排序
     *     声明两个指针: a, b
     *     a ：指向数组第一个数
     *     b ：指向数组的最后一个数
     *     a + b  ： target
     *     将a和b所对应的值相加与target比较
     *     大于：a 右移。
     *     小于：b 左移。
     *     等于：返回原数组的下标, 注意：不是排序后的下标
     *     注意题设:
     *         1, 同样的元素不能被重复利用
     *         2, 每个输入只对应一种答案
     */
    public static int[] twoSumNumThree(int[] nums, int target){
        //参数检查
        if(nums.length < 1 || nums == null) return null;
        //key：存数组的数值，value：存数组的下标
        HashMap<Integer, Integer> mHashMap = new HashMap<Integer, Integer>();
        //存储
        for(int i = 0, len = nums.length; i < len; i++)  mHashMap.put(nums[i], i);
        //数组排序, 升序, 由小到大
        Arrays.sort(nums);
        //头指针
        int pxFirst = 0;
        //尾指针
        int pxSecond = nums.length - 1;
        //返回结果
        int[] result = new int[2];
        while(pxSecond <= nums.length - 1 && pxFirst >= 0){
            //等于, 返回下标
            //注意：该下标, 是排序后的下标, 和原始数组下标不同
            if(nums[pxFirst] + nums[pxSecond] == target){
                result[0] = mHashMap.get(nums[pxSecond]);
                result[1] = mHashMap.get(nums[pxFirst]);
                return result;
            }
            //小于, pxFirst右移动一位
            if(nums[pxFirst] + nums[pxSecond] < target){
                pxFirst++;
            }
            //大于, pxSecond左移动一位
            if(nums[pxFirst] + nums[pxSecond] > target){
                pxSecond--;
            }
        }
        return result;
    }




    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 5, 1};
        System.out.println("正确：" + Arrays.toString(twoSumNumSecond(arr, 6)));
        System.out.println(Arrays.toString(twoSumNumThree(arr, 6)));
    }


}
