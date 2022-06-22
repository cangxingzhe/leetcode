package leetcode;

public class $215 {

    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,5,6,4};
        int result = new $215().findKthLargest(array, 2);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int target = nums.length - k;
        while(l < r) {
            int mid = quickSelection(nums, l, r);
            if(target == mid) {
                return nums[mid];
            }
            if(mid < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return nums[l];

    }

    public int quickSelection(int[] nums, int l, int r) {
        int i = l;
        int j = r;
        int x = nums[i];
        while(i < j) {
            while(i < j && nums[j] > x) {
                j--;
            }
            if(i < j) {
                nums[i++] = nums[j];
            }
            while(i < j && nums[i] < x) {
                i++;
            }
            if(i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = x;
        return i;
    }
}
