package leetcode.binarysearch;

public class $540_2 {

    public static void main(String[] args) {
        System.out.println(new $540_2().singleNonDuplicate(new int[]{1,1,2,2,4,4,5,5,9}));
    }


    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(mid - 1 >= left && nums[mid - 1] == nums[mid]) {
                if(mid - 1 == left) {
                    left = mid + 1;
                }else {
                    if(((mid - 2) - left + 1) % 2 == 1) {
                        right = mid - 2;
                    }else {
                        left = mid + 1;
                    }
                }
            }else if(mid + 1 <= right && nums[mid + 1] == nums[mid]) {
                if(mid + 1 == right) {
                    right = mid - 1;
                }else {
                    if((right - (mid + 2) + 1) % 2 == 1) {
                        left = mid + 2;
                    }else {
                        right = mid - 1;
                    }
                }
            }else {
                return nums[mid];
            }
        }
        return -1;
    }
}
