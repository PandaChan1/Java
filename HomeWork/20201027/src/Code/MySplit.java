package Code;

public class MySplit {

    public static String[] mySplit(String str,String spx){
        int len = str.length();

        String[] strings = new String[len];
        int j = 0;
        String ret = "";

        for (int i = 0; i < len; i++) {
            if ((str.charAt(i)+"").equals(spx)) {
                strings[j] = ret;
                ret = "";
                j++;
            }else {
                ret += str.charAt(i);
            }
        }

        return strings;
    }
    public static void main(String[] args) {
        String str = "hello world mor";
        String[] strings = mySplit(str," ");
        for (String s :
                strings) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }
}
