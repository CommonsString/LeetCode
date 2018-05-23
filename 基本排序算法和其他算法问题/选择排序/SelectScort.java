package nowCode;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectScort {

	public static void selectScrot(int arr[]){
		//参数判断
		if(arr.length < 2 || arr == null) return ;
		//外层
		for(int i = 0, len = arr.length - 1; i < len; i++){
			//记录最小值下标
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++){
				//全程只交换下标
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			} 
			//找出最小，交换
			changeIndex(arr, i, minIndex);
		}
		
	}
	
	public static void changeIndex(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}	
	
	public static void main(String[] args) {
		int arr[] = {3, 4, 1, 5, 6};
		selectScrot(arr);
		System.out.println(Arrays.toString(arr));
	}	
	
}
