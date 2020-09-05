package Leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
            candies[i] = candies[i] + extraCandies;
        }

        for (int candy : candies) {
            if (candy >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] candies = {4,2,1,1,2};
        List<Boolean> booleans = kidsWithCandies(candies, 1);
        System.out.println(booleans);
    }
}
