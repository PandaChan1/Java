package day12_2;

public class robot {
private int ans = 0;
private int x;
private int y;
    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        robot r = new robot();
        System.out.println(r.countway(x, y));
    }
    private  int countway(int x, int y) {
    this.x = x;
    this.y = y;
    ans = dfs(0,0);
    return ans;
    }

    public  int dfs(int row,int col) {


        if (row == this.x - 1 && col == this.y - 1) {
            return 1;
        }

        if (row >= this.x || col >= this.y) {
            return 0;
        }


        return dfs(row + 1,col) + dfs(row,col + 1);
  }
}
