package day11_24;

public class split_numbers {
    public static void main(String[] args) {
        System.out.println(splitNum("abs123455a51ds361"));
    }

    public static String splitNum(String str) {
        String[] splits = str.split("[a-z]");
        String res = "";
        for (int i = 0; i < splits.length; i++) {

            if (splits[i].length() > res.length()) {
                res = splits[i];
            }

        }
        return res;
    }
}
