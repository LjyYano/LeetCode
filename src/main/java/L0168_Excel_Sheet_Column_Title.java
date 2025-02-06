
// https://leetcode-cn.com/problems/excel-sheet-column-title/
public class L0168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
		
		if (n < 27) {
			return (char) ('A' + (n - 1)) + "";
		}

		if (n % 26 == 0) {
			return convertToTitle(n / 26 - 1) + 'Z';
		}

		return convertToTitle(n / 26) + convertToTitle(n % 26);
	
        
    }
}