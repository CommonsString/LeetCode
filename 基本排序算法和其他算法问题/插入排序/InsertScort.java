package nowCode;

import java.util.Arrays;

/**
 * 插入排序
 *
 */
public class InsertScort {


	public static void insertSort(int arr[]){
		//参数检查
		if(arr.length < 2 || arr == null) return ;
		for(int i = 1; i < arr.length; i++){
			for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
				changeIndex(arr, j, j + 1);
			}
		}
	}
	
	public static void changeIndex(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {3, 4, 1, 5, 6};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
}
