package leetcode.greedy;

public class $605_2 {

    public static void main(String[] args) {
/*        System.out.println(new $605_2().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(new $605_2().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println(new $605_2().canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
        System.out.println(new $605_2().canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 0));
        System.out.println(new $605_2().canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 1));
        System.out.println(new $605_2().canPlaceFlowers(new int[]{0,0,1,0,1}, 1));*/
        System.out.println(new $605_2().canPlaceFlowers(new int[]{0,1,0}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }
        int len = flowerbed.length;
        if(len == 1) {
            if(n > len) {
                return false;
            }
            return flowerbed[0] == 0;
        }
        for (int i = 0; i < len; i++) {
            if(flowerbed[i] == 1) {
                continue;
            }
            if(i == 0 && flowerbed[i+1] == 1) {
                continue;
            }
            if(i == len - 1 &&flowerbed[i-1] == 1) {
                continue;
            }

            if(i-1>=0 && i+1 <= (len-1) &&(flowerbed[i-1] == 1 || flowerbed[i+1] == 1)) {
                continue;
            }
            flowerbed[i] = 1;
            n--;
            if(n == 0) {
                break;
            }
        }
        return n == 0;

    }
}
