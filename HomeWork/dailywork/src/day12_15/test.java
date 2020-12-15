package day12_15;

public class test {
    public static void main(String[] args) {
    test t = new test();
        System.out.println(t.monotoneIncreasingDigits(100));
    }

    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();

        int flg = chars.length;
        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                flg = i;
                chars[i - 1]--;
            }
        }

        for (int i = flg; i < chars.length; i++) {
            chars[i] = '9';
        }

        String s = new String(chars);
        int ans = Integer.parseInt(s);

        return ans;
    }
}
