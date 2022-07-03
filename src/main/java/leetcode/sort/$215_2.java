package leetcode.sort;

public class $215_2 {

    public static void main(String[] args) {
        System.out.println(new $215_2().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new $215_2().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int target = nums.length - k;
        while(l < r) {
            int mid = quickSort(nums, l, r);
            if(mid == target) {
                return nums[mid];
            }else if(mid > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }


    private int quickSort(int[] nums, int l, int r) {
            int i = l;
            int j = r;
            int key = nums[i];
            while(i < j) {
                while(i < j && nums[j] > key) {
                    j--;
                }
                if(i < j) {
                    nums[i++] = nums[j];
                }
                while(i < j && nums[i] < key) {
                    i++;
                }
                if(i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = key;
            return i;
    }

}
