package Leetcode;

import java.util.*;

public class Test {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int count = 0;
        int i1 = 0;
        int[] result = new int[nums1.length > nums2.length ? nums2.length :nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = index; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i1++] = nums1[i];
                    index = j +1;
                    break;
                }
            }
        }
        return Arrays.copyOf(result, count);
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int index = digits.length;
        int plus = 1;
        for (int i = digits.length -1 ; i > -1 ; i--) {
            int sum = digits[i] + plus;
            plus = sum/10;
            result[index--] = sum%10;
        }

        if (plus == 1) {
            result[0] = 1;
           return result;
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            int re = target - nums[i];
            if (map.containsKey(re)) {
                continue;
            }
            map.put(re, i);
        }
        return result;
    }

    public boolean isValidSudoku(char[][] board) {

        char[][] heng = new char[9][10];
        char[][] shu = new char[9][10];
        char[][] fang = new char[9][10];
        int index;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }
                int i1 = board[i][j] - '0';
                if (heng[i][i1] != 0) {
                    return false;
                }
                heng[i][i1] = 1;

                if (shu[i][i1] != 0) {
                    return false;
                }
                shu[i][i1] = 1;

                if (i < 3 && j < 3) {
                    index = 1;
                } else if (i < 3 &&  j < 6) {
                    index = 2;
                } else if (i < 3) {
                    index = 3;
                } else if (i < 6 && j < 3) {
                    index = 4;
                } else if (i < 6 && j < 6) {
                    index = 5;
                } else if (i < 6) {
                    index = 6;
                } else if (j < 3) {
                    index = 7;
                } else if (j < 6) {
                    index = 8;
                } else  {
                    index = 9;
                }
                if (fang[index - 1][i1] != 0) {
                    return false;
                }
                fang[index - 1][i1] = 1;
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        //(i,j) (j,n-i+1)
/*        给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

        原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]*/
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i ; j < n - i - 1; j++) {
                int temp = 0;
                int value = matrix[i][j];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    int tempRomw = row;
                    row = col;
                    col = n - tempRomw - 1;
                    temp = matrix[row][col];
                    matrix[row][col] = value;
                    value = temp;
                }

            }
        }
    }

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[len - i -1];
            s[len - i - 1] = s[i];
            s[i] = temp;
        }
    }

    // 方法太差
    public int reverse(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        String reverse = s.reverse().toString();
        if (x <0) {
            reverse = reverse.replace("-","");
            reverse = "-" + reverse;
        }

        try {
            return Integer.valueOf(reverse.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    //蠢
    public int firstUniqChar(String s) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (temp[index] > 0) {
                temp[index] = -1;
            }
            if (temp[index] == 0) {
                temp[index] = i + 1;
            }
        }
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (temp[i] > 0 && temp[i] -1 < index) {
                index = temp[i] - 1;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        //蠢
        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }

        return true;
    }

    //大小写相差32，转换可以使用二进制或与32
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if ((str.charAt(0) < '0' || str.charAt(0) > '9') && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c < '0' || c > '9') && !(s.length() == 0 && (c == '-' || c == '+'))) {
               break;
            }
            s.append(c);
        }
        if (s.length() == 1 && (s.charAt(0) == '-' || s.charAt(0) == '+') ) return 0;
        long l = Long.parseLong(s.toString());
        if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE ;
        if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) l;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            int count = 1;
            char c = result.charAt(0);
            StringBuilder temp = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (c == result.charAt(j)) {
                    count+=1;
                } else {
                    temp.append(count).append(c);
                    count = 1;
                    c = result.charAt(j);
                }
            }
            if (c == result.charAt(result.length() - 1)) {
                temp.append(count).append(c);
            }
            result = temp.toString();
        }
        return  result;

        //1
        //11
        //21
        //1211
        //111221
        //312211
        //13112221
        //1113213211
        //31131211131221
        //13211311123113112211
        //11131221
        //31121122
        //1321122122
        //1113


    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].equals("")) {
            return "";
        }
        char c = strs[0].charAt(0);
        String shortStr = strs[0];
        for (int i = 1; i < strs.length; i++) {

            if (strs[i].equals("") || strs[i].charAt(0) != c) {
                return "";
            }
            if (shortStr.length() > strs[i].length()) {
                shortStr = strs[i];
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (shortStr.charAt(i) != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(shortStr.charAt(i));
        }
        return result.toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //坑
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode head2 = head;
        while (head2 != null) {
            count+=1;
            head2 = head2.next;
        }
        head2 = head;
        int index = 0;
        while (head2 != null) {
            if (index == count - n -1) {
                head2.next = head2.next.next;
                break;
            }
            index += 1;
            head2 = head2.next;
        }

        return head;

        // index = 0 ,head2 = 1
        // index = 1 ,h = 2
        //index = 2, h = 3
    }

    public ListNode create(){
        ListNode head = new ListNode(1);
        ListNode head1 = head;
        for (int i = 2; i <= 5; i++) {
            head1.next = new ListNode(i);
            head1 = head1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        char[][] re = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        test.isValidSudoku(re);
//        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        test.rotate(ints);

//        System.out.println(test.reverse(-123));
//        System.out.println(test.firstUniqChar("dabbcb"));
//        System.out.println(0xdf);
//        System.out.println(test.myAtoi("42"));
//        System.out.println(test.myAtoi("2147483648"));
//        System.out.println(Integer.MAX_VALUE);

//        System.out.println(test.countAndSay(1));
        System.out.println(test.removeNthFromEnd(test.create(),2));
    }


}
