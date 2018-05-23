package nowCode;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author MyPC
 *
 */
public class BubbleSort {

	
	public static void maoSort(int arr[]){
		if(arr.length < 2 || arr == null) return ;
		//外层, 每一次冒出最大值
		for(int i = arr.length - 1; i > 0; i--){
			for(int j = 0, len = i; j < len; j++){
				if(arr[j] > arr[j + 1]){
					changeIndex(arr, j , j + 1);
				}
			}
		}
	}
	
	public static void changeIndex(int arr[], int a, int b){
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}
	
	public static void main(String[] args) {
		int arr[] = GenerUtils.getRandomArr(5, 10);
		maoSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
}
