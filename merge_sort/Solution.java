/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Sep 15 13:52:24 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution{

	public static void mergeSort( int[] nums ){
		mergeSortHelper( nums, 0, nums.length-1 );
	}

	public static void mergeSortHelper( int[] nums, int start, int end ){
		
		if( start == end )
			return;

		int mid = (start+end)/2;
		
		mergeSortHelper(nums, start, mid); 
		mergeSortHelper(nums, mid+1, end);

		merge(nums, start, mid, end);
	}

	public static void merge(int[] nums, int start, int mid, int end){
		int left=start, right=mid+1, cur=0;

		int[] result = new int[end-start+1];

		while( left<=mid && right<=end ){
			if( nums[left] <= nums[right] ){
				result[cur++] = nums[left++];
			}
			else{
				result[cur++] = nums[right++];
			}
		}

		int remind = (left>mid) ? right : left;
		int remindLen = (left>mid) ? end-right+1 : mid-left+1;

		for( int i=0; i<remindLen; i++ ){
			result[cur++] = nums[remind++];
		}

		for( int i=0; i<result.length; i++ ){
			nums[start+i] = result[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 2, 0, 9, 7, 5 };

		//int[] nums = {2, 1};
		System.out.println(Arrays.toString(nums));
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
