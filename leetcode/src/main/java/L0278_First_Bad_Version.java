
// https://leetcode-cn.com/problems/first-bad-version/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class L0278_First_Bad_Version extends VersionControl {
    public int firstBadVersion(int n) {
		int low = 1, high = n;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;    
    }
}