package examsoftware;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswerFileGenerator {
	String[] answers;String ID,Subject,Test;
	char[] Code=new char[]  {'Y','H','E','S','O','C','V','X','D','U','I','G','L','B','K','R','Z','T','N','W','J','P','F','M','A','Q','$','$','$','$','$','$','y','h','e','s','o','c','v','x','d','u','i','g','l','b','k','r','z','t','n','w','j','p','f','m','a','q'};
       
        public AnswerFileGenerator(String[] answers,String ID, String Subject,String Test){
		this.ID=ID;
                this.Subject=Subject;
                this.Test=Test;
		this.answers=answers;
		
		File file=new File("/home/");
                String[] users=file.list();
                for(int i=0;i<users.length;i++){
                    try{
                        WriteAns("file:/home/"+users[i]+"/");
                    }catch(Exception e){}
                }
		
    }
    
    void WriteAns(String path) throws FileNotFoundException, IOException{
        Date date=new Date();
	URI url = null;
        DataOutputStream out = null;
        
        try {   
            if(date.getDate()<10 && date.getMonth()>8){
				url=new URI(path+"/Desktop/"+ID+"_"+Subject+"_"+Test+"_0"+date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+".rb");
            }
            else if(date.getDate()>9 && date.getMonth()<9){
            	url=new URI(path+"/Desktop/"+ID+"_"+Subject+"_"+Test+"_"+date.getDate()+"-0"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+".rb");
            }
            else if(date.getDate()<10 && date.getMonth()<9){
                url=new URI(path+"/Desktop/"+ID+"_"+Subject+"_"+Test+"_0"+date.getDate()+"-0"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+".rb");
           }           
        } catch (Exception e) {e.printStackTrace();}
        
        
        
           File file=new File(url);
           file.createNewFile();
           out = new DataOutputStream(new FileOutputStream(file));
		for(int i=0;i<answers.length;i++)
		{
			try {
				for(int j=0;j<99;j++){
					out.writeChars(String.valueOf((int)(Math.random()*10)));
					
				}
				if(answers[i].equalsIgnoreCase("$A")){out.writeChars(String.valueOf(0));}
				else if(answers[i].equalsIgnoreCase("$B")){out.writeChars(String.valueOf(1));}
				else if(answers[i].equalsIgnoreCase("$C")){out.writeChars(String.valueOf(2));}
				else if(answers[i].equalsIgnoreCase("$D")){out.writeChars(String.valueOf(3));}
				else if(answers[i].equalsIgnoreCase("$T")){out.writeChars(String.valueOf(4));}
				else if(answers[i].equalsIgnoreCase("$F")){out.writeChars(String.valueOf(5));}
				else if(answers[i].equalsIgnoreCase("$N")){out.writeChars(String.valueOf(6));}
				else if(answers[i].equalsIgnoreCase("$U")){out.writeChars(String.valueOf(7));}
                else {
                	String temp=new String(answers[i]);
                	for(int j=0;j<temp.length();j++){
				int c=((int)temp.charAt(j))-65;
                		if((c>25&&c<32)||(c<0 )|| (c>57)){
							continue;
				}
				temp=temp.substring(0,j)+String.valueOf(Code[c])+temp.substring(j+1,temp.length());
			}
                	out.writeChars("8"+temp+"9");
               	
                }
			} catch (IOException e) {e.printStackTrace();}
			
		}
		try {
			out.close();
		} catch (IOException e) {e.printStackTrace();}


    }    
	
}
