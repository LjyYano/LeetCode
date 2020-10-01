class Solution {
    public int[][] merge(int[][] intervals) {
		//Base case
        if(intervals == null || intervals.length == 0)
            return new int[0][0];
        
		//Sort the input based on start value of intervals
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		
		//Start value of first input is always the least as the input is sorted
        int start = intervals[0][0];
        int end = Integer.MAX_VALUE;
        
        List<int[]> result = new ArrayList<>();
        
		
        for(int[] interval: intervals){
            if(interval[0] <= end)
                end = (end == Integer.MAX_VALUE) ? interval[1]: Math.max(end,interval[1]);
            else{
                result.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
		//The last interval would be skipped in the loop. Hence, add it separately
        result.add(new int[]{start,end});
        
		//Convert the result list to int[][] and return (Please suggest if there is a better way to do this)
        int[][] res = new int[result.size()][];
        for(int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        
        return res;
    }
}