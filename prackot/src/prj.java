
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class prj {
    static ArrayList<ArrayList<String>> resultList;
    static ArrayList<String> resultString;
    static int COUNT=0;
    static int DENOVCOUNT=0;

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        ArrayList shortread=fileshort(50000);//30 * 20000 // 30 30000

        int r=sc.nextInt(); // 몇개까지 일치하면 합칠까?
        String result=brute(shortread,r);
        System.out.println(COUNT);
    }


    @SuppressWarnings("unchecked")
    static String brute(ArrayList<String>shortread,int r) throws IOException {
        String result="";
        ArrayList<String> shorttmp;
        int len=shortread.size();
        System.out.println("length = "+len);
        //System.out.println(shortread.size());
//        for(int i=0;i<len;i++) {
//            DENOVCOUNT=0;
//            System.out.println(i+"번째");
//
//            shorttmp=(ArrayList<String>) shortread.clone();
//            //	len=shorttmp.size();
//            String res=shorttmp.get(i);
//            shorttmp.remove(i);
//
//            denov(shorttmp,res,i,r);
//        }

            shorttmp=(ArrayList<String>) shortread.clone();
            //	len=shorttmp.size();
            String res=shorttmp.get(0);
            shorttmp.remove(0);

            denov(shorttmp,res,0,r);

        return result;
    }
    static int denov(ArrayList<String> shorttmp,String res,int i, int r) throws IOException {

        int len_short=300;//short의 길이---------------------------------------
       //100/1500
        //  300 /1000
        // 1000/300 /10
        //1000/200/
        //2000/100/50
        //50/4000/5----------이거 해보기
        //100/2000/5-------얘도..?
        //200/1000/5---안되네...
        //5000/50/1000
        //500/20/300
        //500/30/200
        //5000/50/300
        //200/300/
        //50000/300/2000
        //500000/300/20000


        // 50만
        //1000/5000-10     27% 잘 안되네
        //1000/5000/ 7
        //50만 /1000/7000/ 10     0.034% / 0.09 /0.09

        //10만
        //10만 500/2000/ 10   0.3 /0.4/0.4
        //10만 100/2000/ 10   실패
        // 10만/ 200/3000/ 10  실패
        // 10만 / 500/1000/10   실패

        //5만
        //300/2500 / 10   0.75% /0.67 /0.91/0.91
        //




        DENOVCOUNT++;
        String result=res;


       // if(DENOVCOUNT%100==0)
       // {
            System.out.println("count: "+DENOVCOUNT+", "+result.length());

    //   }

        if(DENOVCOUNT>=10100){
            if(result.length()>48000)
            { writefile(result);
            return 1;}
            return 0;
        }

        String compare;
        String subtmp;
        String subtmp2;String subtmp3;
        int d,j;
        ArrayList<String>tmp;
        int len=shorttmp.size();
        int rindex;
        int rl;int ret;

        int subrl;
        //	System.out.println(len);
        for(j=0;j<len;j++) {

            if(result.length()>=49500) {
                writefile(result);
                return 1;
            }
            compare=shorttmp.get(j);

            subtmp=compare.substring(0,r);
            subtmp2=compare.substring(r);

            if(result.contains(subtmp)) {

                //int rindex=result.indexOf(subtmp);
                rindex=result.lastIndexOf(subtmp);
                rl=result.length();

                subrl=rl-rindex;
                if(subrl==r) {

                    result+=subtmp2;
                    tmp=(ArrayList<String>) shorttmp.clone();

                    tmp.remove(j);len--;
                    Collections.shuffle(tmp);
                   ret= denov(tmp,result,j,r);
                   if(ret==1)
                       return 1;


                }else if(subrl<len_short&&subrl>r) {
                    d=subrl-r;
                    subtmp3=subtmp2.substring(0,d);
                    if(result.substring(rl-d).equals(subtmp3)) {
                        result+=subtmp2.substring(d);

                        tmp=(ArrayList<String>) shorttmp.clone();

                        tmp.remove(j);len--;
                        Collections.shuffle(tmp);
                      ret=  denov(tmp,result,j,r);
                      if (ret==1)
                          return 1;
                        //	shorttmp.remove(j);len--;
                        //	 denov(tmp,result,j,r);
                    }

                }
                else {
                    continue;
                }



            }}
        if(result.length()>=49500) {
            //shorttmp,result
//            resultList.add(shorttmp);
       //     resultString.add(result);
//
            COUNT++;

            writefile(result);
//            try {
//                BufferedWriter bw=new BufferedWriter(new FileWriter("C:/Users/bohee/Desktop/denov.txt",true));
//                PrintWriter pw;
//                pw = new PrintWriter(bw,true);
//
//                pw.println(result);
//                pw.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
            System.out.println(result.length()+"denov 쓰기 완료----------------------------------------");

            return 1;

        }
        return 0;

    }
static void writefile(String result){
                try {
                BufferedWriter bw=new BufferedWriter(new FileWriter("C:/Users/bohee/Desktop/denov.txt",true));
                PrintWriter pw;
                pw = new PrintWriter(bw,true);

                pw.println(result);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
                }
}

    static ArrayList<String> fileshort(int n) {
        ArrayList<String> strlist=new ArrayList<String>();
        BufferedReader br;
        //	String []shortread=new String[n];
        try {
            String str;
            br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/shortread.txt"));
            //	int i=0;
            while(true) {
                str=br.readLine();
                if(str==null)
                { break;}
                //	shortread[i]=str;
                strlist.add(str);
                //	i++;
            }br.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        //return shortread;

        return strlist;
    }

}
