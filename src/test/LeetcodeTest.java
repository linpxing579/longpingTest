package test;

import bean.ReturnResult;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetcodeTest {

    public static int lengthOfLongestSubstring(String s) {
       int max = 0;
        Set<Character> set = new HashSet<>(s.length());
        int i = 0,j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int max = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

    //4
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > length2) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
            int templen = length2;
            length2 = length1;
            length1 = templen;
        }

        int halflen = (length1 + length2)/2;   //??
        int imin = 0;
        int imax = length1;
        while (imin <= imax) {
            int i = (imin + imax) /2;
            int j = halflen - i;

        }
        return 0;
    }

    public String longestPalindrome(String s) {
        StringBuilder s1 = new StringBuilder(s).reverse();
        if (s.equals(s1.toString())) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(),result = new StringBuilder();
        int sLength = s.length();
        for (int k = 0; k < sLength; k++) {
            if (s.charAt(k) == s1.charAt(k)) {
                stringBuilder.append(s.charAt(k));
            } else {
                if (stringBuilder.length() > result.length()) {
                    result = new StringBuilder(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
            }
        }

        return result.length() > 0 ? result.toString() : s.charAt(0) + "";
    }

    public int reverse(int x) {
        try {
            boolean isf = false;
            if (-x > 0) {
                isf = true;
                x = -x;
            }
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));

            if (isf) {
                return -(Integer.valueOf(stringBuilder.reverse().toString()));
            } else {
                return Integer.valueOf(stringBuilder.reverse().toString());
            }
        } catch (Exception e) {
            return 0;
        }

    }

    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        int i ,length = str.length();
        for (i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (sb.length() == 0 && c == ' ') {
                continue;
            }
            if ((c >= '0' && c <= '9') || (sb.length() == 0 && (c == '-' || c == '+'))) {
                sb.append(str.charAt(i));
            } else
                break;
        }

        if (sb.length() == 0 || (sb.length() == 1 && (sb.charAt(0) == '-' || sb.charAt(0) == '+' ))) {
            return 0;
        }

        try {
            long l = Long.parseLong(sb.toString());
            if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return Integer.valueOf(sb.toString());
        } catch (Exception e) {
            return sb.charAt(0) == '-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }

    public int myAtoi2(String str) {
        String reg = "^[/-/+]?\\d+";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            try {
                long l = Long.parseLong(matcher.group(0));
                if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                return Integer.valueOf(matcher.group(0));
            } catch (Exception e) {
                return matcher.group(0).charAt(0) == '-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length , i = 0, j = 1, result = 0;
        while (i < length && j < length) {
            if (nums[i] != nums [j]) {
                i++;
                result += 1;
                nums[i] = nums [j];
            }
            j++;
        }
       return result;
    }

    public int maxProfit(int[] prices) {
        int result = 0, length = prices.length, min = -1;
        if (length > 1 && prices[0] < prices[1]){
            min = prices[0];
        }
        for (int i = 1; i < length - 1; i++) {

            if (min == -1 && prices[i] <= prices[i+1]) {
                min = prices[i];
                continue;
            }

            if (min > -1 && prices[i] >= prices[i+1]) {
                result += prices[i] - min;
                min = -1;
            }
        }

        if (length > 1 && min > -1 && prices[length -1] > prices[length -2]) {
            result += prices[length - 1] - min;
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 1; i < len; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                max += temp;
            }
        }
        return max;
    }

    public void rotate(int[] nums, int k) {

        int len = nums.length,temp;
        k = k % len;
        while (k-- > 0) {
            temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }
    }

    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        return stringBuilder.reverse().toString().equals(String.valueOf(x));
    }

    //11
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i <= j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j])* (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }

    public String intToRoman(int num) {
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1} ;
        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"} ;
        StringBuilder sb = new StringBuilder() ;

        for(int i = 0 ; i < number.length ; i++){
            while(num >= number[i]){
                sb.append(s[i]) ;
                num -= number[i] ;
            }
            if(num == 0){
                break ;
            }
        }
        return sb.toString() ;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public ReturnResult ts(){
        ReturnResult fail = ReturnResult.FAIL;
        fail.setData(1);
        return fail;
    }

//
    public static void main(String[] args) {
//        lengthOfLongestSubstring(" ");
        LeetcodeTest leetcodeTest = new LeetcodeTest();
//        leetcodeTest.reverse(100);
//        leetcodeTest.myAtoi("20000000000000000000");
//        leetcodeTest.myAtoi2("20000000000000000000");
//        System.out.println(leetcodeTest.removeDuplicates(new int[]{1,1,2}));
//        System.out.println(leetcodeTest.maxProfit(new int[]{1,9,6,9,1,7,1,1,5,9,9,9}));
//        System.out.println(leetcodeTest.isPalindrome(-1));

//        int a = 0,b = 0,n = 0,m = 0;
//        int price = a / n;

    }


    /*
    *   10000   1000 10
    *
    * */
}
