package Code.PackagingTest;
/**
 *@ClassName: BankUser
 *@Description 类的封装实现
 *@Author PandaChan1
 *@Date 2020/10/26
 *@Time 17:23
 */


class BankUser{
    private String userName;
    private int userAge;
    private int userMoney;
    private String userPhone;
    int date;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userMoney=" + userMoney +
                ", userPhone='" + userPhone + '\'' +
                ", date=" + date +
                '}';
    }
}
public class Packaging {
    public static void main(String[] args) {
        BankUser bankUser = new BankUser();
        bankUser.setUserName("王");
        bankUser.setUserAge(23);
        bankUser.setUserMoney(20000);
        bankUser.setUserPhone("131-9999-2131");
        bankUser.date = 2020;
        System.out.println(bankUser.toString());
    }
}
