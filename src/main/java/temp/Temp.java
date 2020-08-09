package temp;

public class Temp {
    int[][] paths;
    public int uniquePaths (int m, int n) {
        // write code here
        if(paths==null){
            paths = new int[m][n];
        }
        if(paths[m-1][n-1]!=0){
            return paths[m-1][n-1];
        }else if(m==1||n==1){
            paths[m-1][n-1]=1;
        }else{
            paths[m-1][n-1]=uniquePaths(m-1,n)+uniquePaths(m,n-1);
        }
        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
        System.out.println(temp.uniquePaths(3,7));
    }
}
