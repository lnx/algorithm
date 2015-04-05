package solutions;

public class LongestCommonSubstring {
	
    int longestCommonSubstring(String s1, String s2) {
    	int ret = 0;
    	int len1 = s1.length(), len2 = s2.length();
    	int[][] dp = new int[len1 + 1][len2 + 1];
    	for (int i = 1; i <= len1; ++i) {
    		for (int j = 1; j <= len2; ++j) {
    			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
    				dp[i][j] = dp[i - 1][j - 1] + 1;
    			}
    			ret = Math.max(ret, dp[i][j]);
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	String s1 = "abcdf";
    	String s2 = "cbcda";
		System.out.println(new LongestCommonSubstring().longestCommonSubstring(s1, s2));
	}

}
