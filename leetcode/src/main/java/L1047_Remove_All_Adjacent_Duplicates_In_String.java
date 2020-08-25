
// https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
class L1047_Remove_All_Adjacent_Duplicates_In_String {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : A) {
            pq.add(x);
        }

        while (K-- > 0) {
            pq.add(-pq.poll());
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += pq.poll();
        }

        return sum;
    }
}