package day11_29;

public class test {
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.reorganizeString("aaabc"));
    }
    public String reorganizeString(String s) {
        int[] chars = new int[26];
        for(int i = 0; i < s.length();i++) {
            char temp = s.charAt(i);
            chars[temp - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(sb.length() < s.length()) {
            if(chars[index] != 0) {
                char tmp = (char)(index + 'a');
                sb.append(tmp);
                chars[index]--;
            }
            index++;
            if(index == chars.length) {
                index = 0;
            }
        }


        String ans = sb.toString();

        for(int i = 0; i < ans.length() - 1;i++) {
            if(ans.charAt(i) == ans.charAt(i + 1)) {
                return "";
            }
        }
        return ans;
    }
}
