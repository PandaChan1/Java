package day12_11;

import java.util.*;


/**
 * 输出全部出栈序列，未按字典排序
 * 方法：
 * 1、回溯得到全排列
 * 2、对每个全排列的结果进行验证
 * 3、输出
 */
public class stackTest {

    static List<List<Integer>> lists = new ArrayList<>();
    static List<String > res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) return;
            int[] array = new int[n];

            for(int i = 0; i < n;i++) {
                int t = Integer.parseInt(sc.next());
                array[i] = t;
            }

            int[] temp = Arrays.copyOfRange(array,0,n);
            //全排列
            dfs(array, 0,n - 1);

            //验证出栈序列的合法性,并输出
            check(temp);

            Collections.sort(res);
            for (String str :
                    res) {
                System.out.println(str);
            }
        }
    }

    private static void check(int[] array) {
        int i = 0;
        while(i < lists.size()) {
            List<Integer> list = lists.get(i);

            boolean b = checkChild(list,array);
            if (b) {  //输出序列
//                for (int j = 0; j < list.size(); j++) {
//                    if (j == 0) {
//                        System.out.print(list.get(j));
//                    }else {
//                        System.out.print(" " + list.get(j));
//                    }
//                }
//                System.out.println();

                String s = arrToStr(list,list.size());
                res.add(s);
            }

            i++;

        }

    }

    private static String arrToStr(List<Integer> list, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            if (i != n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static boolean checkChild(List<Integer> list,int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0,j = 0; i < array.length; i++) {
            stack.push(array[i]);

            while(j < list.size() && !stack.isEmpty() && stack.peek() == list.get(j)) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
        }



    //先进行全排列
    private static void dfs(int[] array,int start, int end) {
        if (start == end) {  //找到一个排列
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
            lists.add(list);
            return;
        }


      for (int i = start; i <= end;i++) {
          swap(array,start,i);
            dfs(array,start + 1,end);
          swap(array,start,i);
      }
    }

    private static void swap(int[] array, int start, int i) {
        int temp = array[start];
        array[start] = array[i];
        array[i] = temp;
    }

}
