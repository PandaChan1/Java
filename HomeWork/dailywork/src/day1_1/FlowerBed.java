package day1_1;

/**
 *@ClassName: FlowerBed
 *@Description leetcode605 种花问题
 *@Author PandaChan1
 *@Date 2021/1/1
 *@Time 15:31
 */


public class FlowerBed {
    public static void main(String[] args) {
        FlowerBed f = new FlowerBed();
        System.out.println(f.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 1}, 2));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {  //一次走两步
            //题目说明，已有的花严格按照规则摆放，所以当前为1，那么当前的下一个就是0
            //因此遇到1我们就跳两格，然后判断
            if(flowerbed[i] == 0) {  //当前为0，则判断下一个是否为0；如果是最后一个为0那么直接可以填充
                if(i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                }else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}
