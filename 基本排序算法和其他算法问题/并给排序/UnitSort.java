package nowCode;

import java.util.Arrays;


/**
 * 并归排序 commonsstring@gmail.comm
 */
public class UnitSort {
	
	public static void mergeSort(int[] arr){
		//参数检查
		if(arr.length < 2 || arr == null) return ;
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] arr, int L, int R){
		//只要一个数, 返回
		if(L == R) return;
		//计算中值
		int mid = L + ((R - L) >> 1);
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}
	
	
	public static void merge(int[] arr, int L, int mid, int R){
		//声明辅助数组
		int[] temp = new int[R - L + 1];
		//声明指针
		int pxFirst = L;
		int pxSecond = mid + 1;
		int i = 0;
		//谁小填谁, 并移动指针和下标
		while(pxFirst <= mid && pxSecond <= R){
			temp[i++] = arr[pxFirst] < arr[pxSecond] ? arr[pxFirst++] : arr[pxSecond++];
		}
		//pxFirst没越界, 说明pxSecond越界
		while(pxFirst <= mid){
			//将pxFisrst剩余的数, 填写到数组
			temp[i++] = arr[pxFirst++];
		}
		
		while(pxSecond <= R){
			temp[i++] = arr[pxSecond++];
		}
		//复制原数组
		for(int j = 0; j < temp.length; j++){
			arr[L + j] = temp[j];
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 4, 5, 7};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
