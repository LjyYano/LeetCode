import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/merge-intervals/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class L0056_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> ans = new ArrayList<>();
    	if (intervals == null || intervals.size() == 0) {
			return ans;
		}
    	
    	// sort by start
    	Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end;
			}
		});
    	
    	Interval o1 = intervals.get(0);
    	for(int i = 1; i < intervals.size(); i++) {
    		Interval o2 = intervals.get(i);
    		if (o1.end >= o2.start) {
				o1 = new Interval(o1.start, Math.max(o1.end, o2.end));
			} else {
				ans.add(o1);
				o1 = o2;
			}
    	}
    	
    	ans.add(o1);
		return ans;
    }
}