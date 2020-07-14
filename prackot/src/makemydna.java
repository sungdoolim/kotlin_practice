//2015112120 임성두
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class makemydna {

	public static void make(int k,int n,int l) {
		// TODO Auto-generated method stub
	
		String ref ="";
		char[]dna= {'A','G','C','T'};
	
		writefile(dna,l);// 50만길이의 dna를 파일에 씁니다
		ref=inputfile();// 위에서 쓴 파일을 불러옵니다
		StringBuilder strref=new StringBuilder(ref);
		String []shortread=makeShortread(strref, k, n,10,dna);
		writeShortread(shortread);// shortread를 파일에 씁니다
		
		
	}
	
	
	// 맨 밑에부터 두개의 메서드를 제외하면 전부 file 입출력 메서드로 큰 의미를 가지지 않습니다.
	// 맨 밑 두개는 makeShortread 메서드와 makeMyDna 메서드를 말합니다
	
	


	static String inputfile() {
		 BufferedReader br;
		 String ref="";
			try {
				br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/input.txt"));
					 ref=br.readLine();				            			         		 	        
			         br.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}	
			return ref;
	}
	static void writeShortread(String[]shortread) {
		try {	
			  PrintWriter pw;
					pw = new PrintWriter("C:/Users/bohee/Desktop/shortread.txt");
					for(int i=0;i<shortread.length;i++) {
					pw.println(shortread[i]);}
				        pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		System.out.println("end writeShortread");
	}
	static void writefile(char[]dna,int l) {
		try {	
			System.out.println("gg");
	  PrintWriter pw;
			pw = new PrintWriter("C:/Users/bohee/Desktop/input.txt");
			
			int a=5;
			int c=0;
			int count=0;
			  for(int i=0; i<l; i++) {//50000 만 해보자-------------------------------------------------------
		         
				  if(i%500==0) {
					  System.out.println(i);
				  }
		    //두번의 중복은 허용 합니다
		    //즉 같은 값이 3번 나올수 있습니다.
		    //aagggt 처럼 g가 3번까지 반복이 가능하며
		    // 4개이상 반복되어 나올수 없는 것 입니다.
		          
		            c= (int) (Math.random()*4);
		            if(a==c) {// 바로 직전의 값과 같다면 중복되므로 count를 올려줄지 중복을 제거 할지 결정합니다.
		            	if(count>=2) {
		            		//중복count가 이미 2라면 , 즉 중복으로 3번 나온 후 4번째 같은 값이 나오게 되면 값을 바꿉니다.
		            		while(a==c) {
		            			c= (int) (Math.random()*4);
		            		}count=0;// 값을 바꾸고 나면 count를 초기화 합니다.
		            	}
		            	else {
		            	count++;// 전 값에 동일하게 중복되고, 아직 중복된 값이 3개 이하 일때는 중복을 허용하고 count를 올립니다.
		            	}
		            }
		            a=c;          
		            pw.print(dna[a]);
		        }
		        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("end write file");
	}
	
	
	
	
	

	static String[] makeShortread(StringBuilder ref,int k,int n,double x,char[] dna) {
	
		int rl=ref.length();
		
		int ratio=(int)(rl*(x/100));
		int tmp2;
		
		
		ArrayList<Integer>a=new ArrayList<>();
		for(int i=0;i<ratio;i++) {
			tmp2=(int)(Math.random()*rl);
			while(a.contains(tmp2)) {
				tmp2=(int)(Math.random()*rl);
			}a.add(tmp2);
			
		}
	
		char t;
		char diff;
		for(int i=0;i<ratio;i++) {
			t=ref.charAt(a.get(i));
			diff=dna[(int)(Math.random()*4)];
			while(t==diff) {
				diff=dna[(int)(Math.random()*4)];
			}
			//System.out.println(a.get(i)+": "+t+","+diff);
		ref.setCharAt(a.get(i),diff);// 이 ref는 x%다른 mydna입니다.
		}//System.out.println(ref);
		
		int l=rl-k;
		String [] shortread=new String[n];
		int randomtmp;		
		for(int i=0;i<n;i++){
			randomtmp=(int)(Math.random()*l);
			//System.out.println(randomtmp);
			shortread[i]=ref.substring(randomtmp, randomtmp+k);
			
		}
		shortread[0]=ref.substring(0,k);
		

		try {	
			  PrintWriter pw;
					pw = new PrintWriter("C:/Users/bohee/Desktop/mydna.txt");
					
					pw.print(ref);
					
				        pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		System.out.println("mydna 쓰기 완료");
return shortread;		
		
	}

}
