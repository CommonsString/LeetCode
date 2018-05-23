package nowCode;


/**
 * 小和问题
 * @author MyPC
 *
 */
public class minSum {

	
	public static int mergeSort(int[] arr){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		return mergeSort(arr, 0, arr.length - 1);
	}
	
	public static int mergeSort(int[] arr, int L, int R){
		if(L == R) return 0;
		//计算中点
		int mid = L + ((R - L) >> 1);
		return
		mergeSort(arr, L, mid)+
		mergeSort(arr, mid + 1, R)+
		merge(arr, L, mid, R);
	}
	
	public static int merge(int[] arr, int L, int mid , int R){
		//辅助数组
		int[] temp = new int[R - L + 1];
		//参数
		int i = 0;
		//指针
		int pxFirst = L;
		int pxSecond = mid + 1;
		//小和
		int result = 0;
		while(pxFirst <= mid && pxSecond <= R){
			result += arr[pxFirst] < arr[pxSecond] ? (R - pxSecond + 1) * arr[pxFirst] : 0;
			temp[i++] = arr[pxFirst] < arr[pxSecond] ? arr[pxFirst++] : arr[pxSecond++]; 
		}
		
		while(pxFirst <= mid){
			temp[i++] = arr[pxFirst++];
		}
		
		while(pxSecond <= R){
			temp[i++] = arr[pxSecond++];
		}
		
		//copy arr, 辅助数组的长度
		for(int j = 0; j < temp.length; j++){
			arr[L + j] = temp[j];
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 4, 5, 7};
		System.out.println(mergeSort(arr));
	}
	
	
}
