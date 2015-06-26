/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examsoftware;

/**
 *
 * @author Zubaeyr
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExamDetailsChck {
       char[] Decode=new char[]  {'Y','N','F','I','C','W','L','B','K','U','O','M','X','S','E','V','Z','P','D','R','J','G','T','H','A','Q','$','$','$','$','$','$','y','n','f','i','c','w','l','b','k','u','o','m','x','s','e','v','z','p','d','r','j','g','t','h','a','q'};
       int[] decodenum=new int[] {4,6,3,5,1,2,0,8,9,7};
	ExamDetailsChck(String[] examdets){
		DataInputStream d = null;
                
		try {
			d = new DataInputStream(getClass().getResourceAsStream("/examsoftware/avengers.rb"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String str;
		int f=0;
		try {
			while((str=d.readLine())!=null)
			{
				examdets[f]=Decode(str);
                                f++;
			}
                        d.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
                
		
		
	}
        String Decode(String temp){
		for(int k=0;k<temp.length();k++){
			int c=((int)temp.charAt(k))-65;
    		if((c>25&&c<32)||(c<0 )|| (c>57)){
    			 int t1=(int)temp.charAt(k);
 				if(t1>=48 && t1<=57){
                     int t2=Integer.valueOf(String.valueOf(temp.charAt(k)));
                     temp=temp.substring(0,k)+String.valueOf(decodenum[t2])+temp.substring(k+1,temp.length());
 				}		
			}
    		else{
    			temp=temp.substring(0,k)+String.valueOf(Decode[c])+temp.substring(k+1,temp.length());
    		}

			
    	}
		
		return temp;
	}
        void Questiontype(int[] quetype){
                int k,f=0;
                DataInputStream d = null;
                try {
                    d = new DataInputStream(getClass().getResourceAsStream("/examsoftware/qt.rb"));
                } catch (Exception e1) {
        		e1.printStackTrace();
                }
                try {
			while((k=d.read())!=-1)
			{       try{
                                    quetype[f]=(Integer.valueOf(String.valueOf((char)k)).intValue());
                                }catch(Exception e){}
				f++;
			}
                        d.close();

		} catch (IOException e) {}
     

        }
      
}


