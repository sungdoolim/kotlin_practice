package mobile_software.week4;

public class week4_Main {
    public static void main(String[] args) {

        int[][] ar = {{1,2},
                      {3,4},
                      {5,6},
                      {7,8}};

        int[][] br = {{1,2,3,4},
                      {5,6,7,8}};

        int tmp=0;
        int [][]tmp2=new int[2][2];
        int k1=0,k2=0;
        for(int i=0;i<4;i++){
            tmp=0;
            for(int j=0;j<2;j++){
                tmp+=ar[i][j]*br[j][i];
            }
            tmp2[k1][k2]=tmp;
           // System.out.println(tmp2[k1][k2]);
            if(k2<1)
                k2++;
            else {
                k2=0;
                k1++;
            }
        }

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(tmp2[i][j]+" ");

            }
            System.out.println();
        }




    }
}
