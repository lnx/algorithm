package solutions;

public class CompareVersionNumbers {
	
    int compareVersion(String v1, String v2) {
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int i = 0;
        while (i < Math.min(s1.length, s2.length)) {
            int a = Integer.parseInt(s1[i]), b = Integer.parseInt(s2[i]);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            ++i;
        }
        if (s1.length < s2.length) {
            while (i < s2.length) {
                if (Integer.parseInt(s2[i]) > 0) {
                    return -1;
                }
                ++i;
            }
            return 0;
        } else if (s1.length == s2.length) {
            return 0;
        } else {
            while (i < s1.length) {
                if (Integer.parseInt(s1[i]) > 0) {
                    return 1;
                }
                ++i;
            }
            return 0;
        }
    }

}
