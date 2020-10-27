package Code;

import java.util.Scanner;

class LoginException extends Exception {

    public LoginException() {

    }

    public LoginException(String message) {
        super(message);
    }
}

public class ExceptionEx {
    public static final String USER_NAME = "chen";
    public static final int PASSWORD = 11236;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号:");
        String ID = scanner.next();
        System.out.println("请输入密码:");
        int password = scanner.nextInt();
        try {
            if (ID == null || !ID.equals(USER_NAME) || password != PASSWORD) {
                throw new LoginException("账号错误");
            }else {
                System.out.println("登录成功");
            }

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
