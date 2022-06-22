package leetcode.greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * Assign Cookies (Easy)
 *
 * 题目描述
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃 最多一个饼干，
 * 且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩 子可以吃饱。
 *
 *
 * 顾名思义，贪心算法或贪心思想采用贪心的策略，保证每次操作都是局部最优的，从而使最 后得到的结果是全局最优的。
 */
public class $455 {
    public static void main(String[] args) {
        int result = findContentChildren(new int[]{1,2}, new int[]{1,2,3});
        System.out.println(result);
    }

    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int i = 0;
        int j = 0;
        while(i<=j & i<children.length & j<cookies.length) {
            if(children[i] <= cookies[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
