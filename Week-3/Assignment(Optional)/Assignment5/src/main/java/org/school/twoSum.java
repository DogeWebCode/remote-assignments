package org.school;

import java.util.Arrays;
import java.util.HashMap;


public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.print(Arrays.toString(twosum(nums, 9)));
    }

    public static int[] twosum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //If the .get method does not find the corresponding Key(target - nums[i]) in the map, it will return Null.
            Integer sumIndex = sum.get(nums[i]);
            if(sumIndex != null) {
                return new int[]{sumIndex, i};
            }
            //target reduces the number of the current array, so you can see how much you need to add to get to target.
            //Key is the value to be found, Value is Index.
            sum.put(target - nums[i], i);
        }
        return nums;
    }

    /*
    public static int[] twosum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }
    */

    /*
    For example:
    twoSum([2, 7, 11, 15], 9);
    Should returns:
    [0, 1]
    Because:
    nums[0]+nums[1] is 9
     */
}
