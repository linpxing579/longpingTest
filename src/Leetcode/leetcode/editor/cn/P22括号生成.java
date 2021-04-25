//括号生成
//generate-parentheses
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1746 👎 0

package Leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class P22括号生成 {
    public static void main(String[] args) {
        Solution solution = new P22括号生成().new Solution();
        // TO TEST
        //()
        //()(),(())
        //()()(),  ((())), (()()),(())(),()(()),
        // 2,
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(4));
        System.out.println(solution.generateParenthesis(5));
        System.out.println(solution.generateParenthesis(6));
        System.out.println(solution.generateParenthesis(7));
        System.out.println(solution.generateParenthesis(8));
        // System.out.println(solution.generateParenthesis(1));
        // System.out.println(solution.generateParenthesis(1));
        // System.out.println(solution.generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        if (n == 1) return Collections.singletonList("()");
        if (n == 2) return Arrays.asList("()()", "(())");
        List<String> resultList = new ArrayList<>(Arrays.asList("()()", "(())"));
        int index = 3;
        while (index <= n) {
            List<String> temp = new ArrayList<>();
            for (String s : resultList) {
                for (int i = 0; i < s.length() - 1; i++) {
                    StringBuilder stringBuilder = new StringBuilder(s);
                    StringBuilder insert = stringBuilder.insert(i, "()");
                    if (!temp.contains(insert.toString())) {
                        temp.add(insert.toString());
                    }
                }
            }
            resultList = temp;
            index++;
        }
        return resultList;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if(n <= 0){
                return res;
            }
            getParenthesis("",n,n);
            return res;
        }

        private void getParenthesis(String str,int left, int right) {
            if(left == 0 && right == 0 ){
                res.add(str);
                return;
            }
            if(left == right){
                //剩余左右括号数相等，下一个只能用左括号
                getParenthesis(str+"(",left-1,right);
            }else if(left < right){
                //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                if(left > 0){
                    getParenthesis(str+"(",left-1,right);
                }
                getParenthesis(str+")",left,right-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}