
// https://leetcode-cn.com/problems/merge-sorted-array/
class L0088_Merge_Sorted_Array {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, end = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) A[end--] = A[i--];
            else A[end--] = B[j--];
        }
        
        while(j >= 0) A[end--] = B[j--];
    }
}