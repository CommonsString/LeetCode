package nowCode;

import java.util.Arrays;

public class GenerUtils {
	
	
	/**
	 * 两数交换
	 */
	public static void swapNum(int[] arr, int numFirst, int numSecond){
		int temp = arr[numFirst];
		arr[numFirst] = arr[numSecond];
		arr[numSecond] = temp;	
	}
	
	/**
	 * 对数器 :
	 * 证明贪心策略
	 */
	public static void rightMathine(){
		//测试次数
		int testTime = 500000;
		//随机范围
		int maxSize = 100;
		int maxValue = 100;
		boolean success = true;
		for(int i = 0; i < testTime; i++){
			int[] arrOne = GenerUtils.getRandomArr(maxSize, maxValue);
			int[] arrTwo = GenerUtils.coppyArray(arrOne);
			//TODO:绝对正确的方法
			//TODO:测试的方法
			if(GenerUtils.isEqual(arrOne, arrTwo)){
				success = false;
				break;
			}
		}
		System.out.println(success ? "正确" : "错误");
		int[] arr = GenerUtils.getRandomArr(maxSize, maxValue);
		GenerUtils.printArray(arr);
		//TODO:测试方法
		GenerUtils.printArray(arr);
	}
	
	/**
	 * 打印数组
	 */
	public static void printArray(int[] arr){
		//params check
		if(arr.length < 1 || arr == null) return ;
		for(int i = 0, len = arr.length; i < len; i++){
			System.out.print(arr[i] + " ");
		}
		System.err.println();
	}
	
	
	/**
	 * 比较器
	 */
	public static boolean isEqual(int[] first, int[] second){
		//参数检查
		if((first == null && second != null) || (first != null && second == null)){
			return false;
		}
		if(first == null || second == null){ 
			return false;
		}
		if(first.length != second.length){
			return false;
		}
		for(int i = 0, len = first.length; i < len; i++){
			if(first[i] != second[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 复制数组
	 */
	public static int[] coppyArray(int[] arr){
		if(arr.length < 1 || arr == null) return null;
		int[] temp = new int[arr.length];
		for(int i = 0, len = arr.length; i < len; i++){
			temp[i] = arr[i];
		}
		return temp;
	}
	
	
	/**
	 * 随机数组发生器
	 */
	public static int[] getRandomArr(int size, int value){
		//生成长度随机的数组
		int random = (int) ((size + 1) * Math.random());
		int[] arr = new int[random];
		//赋值
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int) ((value + 1) * Math.random()) - (int)(value * Math.random());
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(getRandomArr(5, 10)));
	}

}
