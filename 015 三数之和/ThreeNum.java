package com;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeNum {


    /**
     * @author commonsstring@gmail.com
     * 方案一 ：蛮力法
     * leetCode : 部分未通过, 慎用！
     * 时间复杂度：O(N ^ 3)
     * 思路：
     *     将数组排序, 逐一遍历。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 1 || nums == null) return result;
        //特殊解决, 前三个为0
        if(nums.length >= 3){
            if(nums[0] == 0 && nums[1] == 0 && nums[2] == 0){
                List<Integer> tempOne = new ArrayList<Integer>();
                tempOne.add(0);
                tempOne.add(0);
                tempOne.add(0);
                result.add(tempOne);
                return result;
            }
        }
        //特殊解决, 包含3个0
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) count++;
        }
        if(count >= 3){
            List<Integer> tempOne = new ArrayList<Integer>();
            tempOne.add(0);
            tempOne.add(0);
            tempOne.add(0);
            result.add(tempOne);
        }
        //遍历数组
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; i++) {
            int aNum = nums[i];
            for(int j = 1; j < len; j++){
                int bNum = nums[j];
                for(int k = 2; k < len; k++){
                    int cNum =nums[k];
                    if(aNum + bNum == -cNum  && ((nums[i] != nums[j]) && (nums[j] != nums[k]))){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if(!result.contains(temp)){
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }



    /**
     * @author commonsstring@gmail.com
     * 方案二 ：空间换时间
     * leetCode :
     * 时间复杂度：O(N ^ 2)
     * 思路：
     *     利用三个HashSet去除重复
     *
     */




    /**
    * @author commonsstring@gmail.com
    * 方案三 ：首尾滑动法
    * leetCode : 通过
    * 时间复杂度：O(N)
    * 思路：
    *     首先, 数组排序。
    *     利用双指针, 将复杂度将为线性。
    *     公式： a + b + c = 0  ===>  a + b = -c(target)
    *     先固定一个数(faxNum)。
    *     利用固定的数取匹配另外变化的两个数的和, 见公式(target)。
    *     遇到重复值, 跳过的原因：
    *     因为固定了一个数, 那么同一个数不想固定多次, 因为结果集是一样的。
    *     注意题设:
    *         1, 结果集是升序
    *         2, 不能有重复结果
    */
    public static List<List<Integer>> threeSumSecond(int[] nums){
        //返回结果
        List<List<Integer>> result = new ArrayList<>();
        //参数检查
        if(nums.length < 1 || nums == null) return result;
        //排序数组
        Arrays.sort(nums);
        //len = nums.length - 2 ： 尾指针每次开始的时候, 都会指向尾部, 所以无须遍历 nums.length - 1 位置的数。
        for(int i = 0, len = nums.length - 2; i < len; i++){
            //固定值
            int faxNum = -nums[i];
            //固定数后面的数组首尾指针
            int pxFirst = i + 1;
            int pxSecond = nums.length - 1;
            while(pxFirst < pxSecond){
                //目标值
                int target = nums[pxFirst] + nums[pxSecond];
                //相等
                if(faxNum == target){
                    //数组转List
                    result.add(Arrays.asList(nums[i], nums[pxFirst], nums[pxSecond]));
                    //记录首指针
                    int tempPxFirst = pxFirst;
                    //首指针遇到重复值跳过
                    while(pxFirst < pxSecond && nums[pxFirst] == nums[tempPxFirst]) pxFirst++;
                    //尾指针自减
                    pxSecond--;
                }else if(target < faxNum){
                    pxFirst++;
                }else if(target > faxNum){
                    pxSecond--;
                }
            }
            //外层移动, 遇到相同的值, 跳过
            int preI = i;
            while(i < nums.length && nums[i] == nums[preI]) i++;
            /**
             * 注意for循环结束后, i 会自增1
             */
            i--;
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, 2, -1, -4};
//        int[] arr = {0, 0, 0};
//        int[] arr = {1, 0, -1};
        int[] arr = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum(arr));
        System.out.println(threeSumSecond(arr));
    }

}
