import java.util.Arrays;
import java.util.Scanner;

public class HJ3{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] inputArray = new int[1000];
        int index = 0;
        while(sc.hasNextInt() && index < 1000) {
            inputArray[index] = sc.nextInt();
            index++;
        }
        sc.close();
        operation(inputArray);
        int[] res = new int[index];
        for (int i = 0; i <res.length ; i++) {
            res[i] = inputArray[i];
        }

        for(int i = index - 1;i >= 0;i--) {
            if(inputArray[i] != 0 && inputArray[i] != inputArray[i + 1]) {
                System.out.println(inputArray[i]);
            }
        }
    }
    private static void operation(int[] array) {
        int index = 0;
        while(array[index] != 0 ) {
            int n = array[index];
            array[index] = 0;
            index = index + n + 1;
        }
        //排序
        for(int i = 0;i < array.length - 1;i++) {
            boolean flag = true;
            for(int j = 0;j < array.length - 1 - i;j++) {
                if(array[j] < array[j + 1]) {
                    flag = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if(flag) {
                return;
            }
        }
//        Arrays.sort(array);
    }
}
