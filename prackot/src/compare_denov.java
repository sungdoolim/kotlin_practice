import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class compare_denov {


	public static void compare(int l) {
		 BufferedReader br;
		 String ref="";
		 double count=0;
		 double ra;
			try {
				br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/mydna.txt"));
					 ref=br.readLine();				            			         		 	        
			         br.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}	
			
			 BufferedReader br2;
			 String ref2="";
				try {
					br2 = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/denov2.txt"));
					while(true) {		
					count=0;
					ref2=br2.readLine();
					if(ref2==null)
						{break;}
					int bound=0;
					if(ref.length()>ref2.length()){bound=ref2.length();}
					else{bound=ref.length();}
					
					for(int i=0;i<bound-1;i++) {
						if(ref.charAt(i)!=ref2.charAt(i)){count++;}		}
					int k=0;
					if(ref2.length()<l) {
					 k=l-ref2.length();
					}
					 ra=((l-(count+k))/l)*100;//50000개만 해보까--------------------------------------------------
					
					 System.out.println("Difference Count : "+(count+k));
					System.out.println("Accuracy : "+ra+"%");	// 여기는 x%로 잘 만들어 졌는지를 확인합니다.
						
				}
				         br2.close();
				} catch ( IOException e) {
					e.printStackTrace();
				}	
		
	}
}
