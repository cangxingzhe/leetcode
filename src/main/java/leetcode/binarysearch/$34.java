package leetcode.binarysearch;

import java.util.Arrays;

public class $34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $34()
                .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        int[] result = new int[]{-1, -1};
        if(nums.length == 0) {
            return result;
        }
        while(l <= r) {
            mid = l + (r - l)/2;
            if(nums[mid] == target) {
                break;
            }else if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        if(nums[mid] == target) {
            Arrays.fill(result, mid);
            l = mid - 1;
            while(l >= 0 && nums[l] == target) {
                result[0] = l;
                l--;
            }
            r = mid;
            while(r < nums.length && nums[r] == target) {
                result[1] = r;
                r++;
            }
        }

        return result;
    }
}
