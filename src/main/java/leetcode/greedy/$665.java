package leetcode.greedy;

public class $665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1)   return true;
        boolean flag = nums[0] <= nums[1]; // 标识是否还能修改
        // 遍历时，每次需要看连续的三个元素
        for (int i = 1; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i + 1])  // 出现递减
            {
                if (flag)   // 如果还有修改机会，进行修改
                {
                    if (nums[i + 1] >= nums[ i - 1])// 修改方案1
                        nums[i] = nums[i + 1];
                    else                            // 修改方案2
                        nums[i + 1] = nums[i];
                    flag = false;                   // 用掉唯一的修改机会
                }
                else        // 没有修改机会，直接结束
                    return false;
            }
        }
        return true;
    }
}
