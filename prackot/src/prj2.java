

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

public class prj2 {
    static int COUNT=0;
    static int DENOVCOUNT=0;

    // 50만
    //1000/5000-10     27% 잘 안되네
    //1000/5000/ 7

    //1000/7000/ 10     0.034% / 0.09 /0.09
    //1500 5000 500000 10 0.4% / 7 / 잘 안도미
    //250 20000 500000 10  0.3// 잘 안됨
    //500000 2000 3000 10 0.49 0.41  0.3 0.449 0.47



    //10만

    //10만 100/2000/ 10   실패
    // 10만/ 200/3000/ 10  실패
    // 10만 / 500/1000/10   실패

    //10만 500 2000 100000 10   0.3 /0.4/0.4/0.4
    //100000 500 2000 10
    //250 4000 100000 10 0.46 /6% 간혹 실패

    //5만
    //50000 300 2500 10   0.75% /0.67 /0.91/0.91

    //250 2000 50000 10   0.28% 0.4% /0.44% 간혹 실패....
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.print("mydna의 길이 입력 : ");
        int l=sc.nextInt();//50만
        System.out.print("shortread 문자열 하나의 길이 입력 : ");
        int k=sc.nextInt();//50만 기준 2000
        System.out.print("shortread 개수 입력: ");
        int n=sc.nextInt();//50만 기준 3000

        makemydna.make(k,n,l);
        ArrayList<String> shortread=fileshort();

        System.out.println("일치 최소 개수 입력 : ");
        int r=sc.nextInt(); // 몇개까지 일치하면 합칠 것 인지를 결정합니다.

        double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        brute(shortread,r,l,k);
        double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        double msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        // System.out.println(COUNT);
        sc.close();
        System.out.println("restricted denov");
        compare_denov.compare(l);
        System.out.println("Excuting Time : "+msecDiffTime/1000+"seconds");

//         beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println("trivial : ");
        trivial.triv(k, n, l);
//
//    	 afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//    	 msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
//     	System.out.println("Excuting Time : "+msecDiffTime/1000+"seconds");
    }
    @SuppressWarnings("unchecked")
    static void brute(ArrayList<String>shortread,int r,int l,int k) throws IOException {


        System.out.println("length = "+shortread.size());

        denov(shortread,shortread.remove(0),r,l,k);
        // 첫 번째 shortread를 시작으로 하여 알고리즘을 진행합니다.
        // 제한 사항 - shortread의 0번 인덱스를 항상 시작 점으로 둔다(mydna의 시작점을 shortread의 0범 인덱스에 저장 시켜 놓음)
        // 바로 밑에 주석처리 코드는 원래 denove알고리즘의 목적과 맞지만, bruteforce로서 상당한 시간을 요구하기에 위 처럼 제한 사항을 둡니다.
//   ArrayList<String> shorttmp;
//    for(int i=0;i<shortread.size();i++){System.out.println(i);
// shorttmp=(ArrayList<String>) shortread.clone();
//   denov(shorttmp,shorttmp.remove(i),r,l,k);
//  }
//

    }
    @SuppressWarnings("unchecked")
    static int denov(ArrayList<String> shorttmp,String res,int r,int l,int k) throws IOException {


        DENOVCOUNT++;
        String result=res;
        System.out.println("count: "+DENOVCOUNT+", "+result.length());
//        if(DENOVCOUNT>=400){
//        	// 재귀적으로 호출하는 함수가 1000회 이상일 때 어느정도 길이가 만들어 졌다면 파일에 쓰고 메서드를 종료합니다
//            if(result.length()>l*0.95)
//            { writefile(result);
//            return 1;}
//            return 1;
////            else if(result.length()<l*0.75) {
////            	//길이가 75% 미만이 만들어 졌다면 계속 진행합니다.
////            	return 0;
////            }
//
//        }

        String compare,subtmp, subtmp2, subtmp3;
        int d,j,rl,rindex,ret,subrl;
        ArrayList<String>tmp;
        int len=shorttmp.size();

        for(j=0;j<len;j++) {

            if(result.length()>=l*0.995) {
                // 반복을 하다 99.5%에 달하는 길이의 문자열이 완성되면 메서드를 끝냅니다.
                // 이는 무수히 많은 경우가 나올 수 있지만, 반복되는 경우가 많기에 메서드를 끝내도 된다 판단했습니다.
                writefile(result);
                return 1;
            }
            compare=shorttmp.get(j);//현재 완성시킬 result문자열과 비교를 할 shortread를 가져옵니다.
            subtmp=compare.substring(0,r);//shortread에서 r개만큼 앞 부분을 따로 저장을 합니다.
            subtmp2=compare.substring(r);// 위 코드의 나머지 부분을 따로 저장합니다.
            if(result.contains(subtmp)) {// result문자에 shortread의 앞 부분이 포함되는지를 확인합니다.

                rindex=result.lastIndexOf(subtmp);
                rl=result.length();
                subrl=rl-rindex;
                if(subrl==r) {// result에 비교하는 shortread의 앞 부분이 포함되어 있고, 포함된 인덱스와 result의 길이의 차이가 0이라면
                    // 즉 result의 맨 끝 부분과 이어 붙일 shortread의 앞 부분이 일치한다면 일치하는 부분을 제외한 나머지 부분을 result에 더하여 저장합니다.
                    result+=subtmp2;
                    tmp=(ArrayList<String>) shorttmp.clone();
                    tmp.remove(j);//len--;
                    //Collections.shuffle(tmp);
                    ret= denov(tmp,result,r,l,k);// 성공적으로 이었다면 이은 shortread는 제거하고, 다시 denov 메서드를 재귀 호출 합니다.
                    if(ret==1) {return 1;}
                }else if(subrl<k&&subrl>r) {
                    //result에 비교하는 shortread의 앞 부분이 포함되어 있고, 포함된 인덱스와 result의 길이의 차이가 shortread의 길이보다 작다면,
                    // 즉 일치하는 부분이 임의로 정한 숫자보다 많은 경우
                    d=subrl-r;
                    subtmp3=subtmp2.substring(0,d);// 차이나는 만큼 다시 스트링을 따로 저장하며 이 부분도 result에 포함되는지를 비교합니다.
                    if(result.substring(rl-d).equals(subtmp3)) {// result와 같다면 이어 붙입니다.
                        result+=subtmp2.substring(d);
                        tmp=(ArrayList<String>) shorttmp.clone();
                        tmp.remove(j);//len--;
                        //   Collections.shuffle(tmp);
                        ret=  denov(tmp,result,r,l,k);
                        if (ret==1) {  return 1;}
                    }
                }

            }
        }
        if(result.length()>=l*0.995) {
            // 길이가 어느정도 (99.5%로 정함) 길게 나왔다면 파일에 쓰고 메서드를 종료합니다.
            // 길이가 길게 나오는 경우가 상당히 많지만 같은 문자열이 반복되는 경우가 대부분이라 하나의 문자열만을 비교합니다.
            writefile(result);
            return 1;
        }
        return 0;
    }
    static void writefile(String result) throws IOException{
        try {
            System.out.println("write");

            PrintWriter pw;
            pw = new PrintWriter("C:/Users/bohee/Desktop/denov.txt");
            pw.print(result);
            pw.close();
//                BufferedWriter bw=new BufferedWriter(new FileWriter("C:/Users/bohee/Desktop/denov.txt",true));
//                PrintWriter pw;
//                pw = new PrintWriter(bw,true);
//
//                pw.println(result);
//                pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static ArrayList<String> fileshort() {
        ArrayList<String> strlist=new ArrayList<String>();
        BufferedReader br;
        try {
            String str;
            br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/shortread.txt"));
            while(true) {
                str=br.readLine();
                if(str==null)
                { break;}
                strlist.add(str);
            }br.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return strlist;
    }
}
