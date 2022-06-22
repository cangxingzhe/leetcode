package leetcode.greedy;

public class $605 {
    public static void main(String[] args) {
        System.out.println(new $605().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(new $605().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println(new $605().canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
        System.out.println(new $605().canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 0));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }
        if(flowerbed.length == 0) {
            return false;
        }
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0 && n == 1) {
                return true;
            }
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] ==0) {
                if(i-1>=0 && flowerbed[i-1] == 1) {
                    continue;
                }
                if(i+1<flowerbed.length && flowerbed[i+1] == 1) {
                    continue;
                }
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;

    }
}
