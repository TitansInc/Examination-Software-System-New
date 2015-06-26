/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exammanagement;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class CreateExam {
	URL imagesurl,outputurl;
	URL impliciturl=new URL(getClass().getResource("").getPath().substring(0, getClass().getResource("").getPath().lastIndexOf("!")));
//	URL impliciturl=new URL("file:/home/zubaeyr/Desktop/ExamManagement/ExamManagement.jar");
	String Subject, Test,SubjectPass, SuperPass,Noofque,hours,minutes,qtype,Compatability;
        int[] numeric=new int[] {6,4,5,2,0,3,1,9,7,8};
      
        char[] Code=new char[]  {'Y','H','E','S','O','C','V','X','D','U','I','G','L','B','K','R','Z','T','N','W','J','P','F','M','A','Q','$','$','$','$','$','$','y','h','e','s','o','c','v','x','d','u','i','g','l','b','k','r','z','t','n','w','j','p','f','m','a','q'};
        CreateExam(String Subject,String SubjectPass,String SuperPass,String Test,String Noofque,String hours,String minutes,String qtype,URL imagesurl,URL outputurl,String Compatability) throws Exception{
		this.Compatability=Compatability;
		this.imagesurl=imagesurl;
		this.outputurl=outputurl;
		this.Subject=Subject;
		this.Test=Test;
		this.SubjectPass=SubjectPass;
                this.SuperPass=SuperPass;
		this.Noofque=Noofque;
		this.hours=hours;
		this.minutes=minutes;
		this.qtype=qtype;
                File temp=null;
                System.out.println(impliciturl);
                if(Compatability.equals("JDK6")){
                    temp=new File(outputurl.getPath()+"/temporary/ExamSources6/examsoftware/Avengers/");
                    temp.mkdirs();
                    temp=new File(outputurl.getPath()+"/temporary/ExamSources6/META-INF/");
                    temp.mkdirs();

                }
                else{
                    temp=new File(outputurl.getPath()+"/temporary/ExamSources8/examsoftware/Avengers/");
                    temp.mkdirs();
                    temp=new File(outputurl.getPath()+"/temporary/ExamSources8/META-INF/");
                    temp.mkdirs();

                }
                
		temp=new File(outputurl.getPath()+"/temporary/");

		CreateExamDetails();
		CompressQuestions();
		DeleteTemp(temp);
	}
	
	void DeleteTemp(File temp){
		File[] files=temp.listFiles();
		for(int i=0;i<files.length;i++){
			if(!files[i].isDirectory()){
				files[i].delete();
			}
			else{
				DeleteTemp(files[i]);
			}
		}
		temp.delete();
	}
	
	void CompressQuestions() throws Exception{
		//Add Question Images
		File file=new File(imagesurl.getPath());
		File[] files=file.listFiles();
		int count=0;
		for(int i=0;i<files.length;i++){
			if(files[i].isFile()){
				count++;
			}
		}
		String[] filenames=new String[count];
		int j=0;
		for(int i=0;i<files.length;i++){
				if(files[i].isFile()){
					if(files[i].getPath().contains("/")){
                                        filenames[j]=files[i].getPath().toString().substring(files[i].getPath().toString().lastIndexOf('/')+1,files[i].getPath().toString().length());                                            
                                        }
                                        else{
                                        filenames[j]=files[i].getPath().toString().substring(files[i].getPath().toString().lastIndexOf("\\")+1,files[i].getPath().toString().length());                                            
                                        }

					j++;
				}
		}
		FileOutputStream f =new FileOutputStream(outputurl.getPath()+"/"+Subject+"_"+Test+".jar");
		CheckedOutputStream csum =new CheckedOutputStream(f, new CRC32());
		ZipOutputStream out =new ZipOutputStream(new BufferedOutputStream(csum));
		
		for(int i = 0; i < filenames.length; i++) {
			BufferedInputStream in =new BufferedInputStream(new  FileInputStream(imagesurl.getPath()+"/"+filenames[i]));
			out.putNextEntry(new ZipEntry("examsoftware/Avengers/"+filenames[i].substring(0, filenames[i].lastIndexOf("."))+".rb"));
			int c;
			while((c = in.read()) != -1)
				out.write(c);
			in.close();
		}
		//Adding QuestionImages done	
		//Extract Sources files from current jar file to a temporary folder
		
		BufferedInputStream fi=new BufferedInputStream(new FileInputStream(impliciturl.getPath()));//exammanagement.jar
		CheckedInputStream csumi =new CheckedInputStream(fi, new CRC32());
		ZipInputStream in2 =new ZipInputStream(new BufferedInputStream(csumi));
		ZipEntry ze;		
		
				
		while((ze = in2.getNextEntry()) != null) {
                    if(Compatability.equals("JDK6")){
			if(ze.getName().contains("ExamSources6")){
				File f1=new File(outputurl.getPath()+"/temporary/"+ze.getName());
			
                                if(!ze.getName().contains(".")&&!f1.exists()){
					f1.mkdirs();
				}
				
				if(ze.getName().contains(".")){
					BufferedOutputStream out1=new BufferedOutputStream(new FileOutputStream(outputurl.getPath()+"/temporary/"+ze.getName()));
					int x;
					while((x = in2.read()) != -1)
						out1.write(x);
					out1.close();
				}
                                
			}
                    }
                    else{
			if(ze.getName().contains("ExamSources8")){
				File f1=new File(outputurl.getPath()+"/temporary/"+ze.getName());
			
                                if(!ze.getName().contains(".")&&!f1.exists()){
					f1.mkdirs();
				}
				
				if(ze.getName().contains(".")){
					BufferedOutputStream out1=new BufferedOutputStream(new FileOutputStream(outputurl.getPath()+"/temporary/"+ze.getName()));
					int x;
					while((x = in2.read()) != -1)
						out1.write(x);
					out1.close();
				}
                                
			}
                    }
		}
		in2.close();
                if(Compatability.equals("JDK6")){
                    file=new File(outputurl.getPath()+"/temporary/ExamSources6/examsoftware/");
                    Add(file,out,"examsoftware");	
                    file=new File(outputurl.getPath()+"/temporary/ExamSources6/META-INF/");
                    Add(file,out,"META-INF");		
                  
                }
                else{
                    file=new File(outputurl.getPath()+"/temporary/ExamSources8/examsoftware/");
                    Add(file,out,"examsoftware");	
                    file=new File(outputurl.getPath()+"/temporary/ExamSources8/META-INF/");
                    Add(file,out,"META-INF");		
                  
                }
                out.finish();
                out.close();
                f.close();   
                File file1=new File(outputurl.getPath()+"/"+Subject+"_"+Test+".jar");
                file1.setExecutable(true);
                         
        }
	String Encode(String temp){
        for(int j=0;j<temp.length();j++){
			int c=((int)temp.charAt(j))-65;
            		if((c>25&&c<32)||(c<0 )|| (c>57)){
                           int t1=(int)temp.charAt(j);
            				if(t1>=48 && t1<=57){
                                int t2=Integer.valueOf(String.valueOf(temp.charAt(j)));
                                temp=temp.substring(0,j)+String.valueOf(numeric[t2])+temp.substring(j+1,temp.length());

            				}
                             
            		}
                            else{
    			      temp=temp.substring(0,j)+String.valueOf(Code[c])+temp.substring(j+1,temp.length());
                            }
            		 
		}
                return temp;
        }
	void CreateExamDetails() throws IOException{
	      String newLine = System.getProperty("line.separator");
              DataOutputStream out=null,out2=null;
              if(Compatability.equals("JDK6")){
            	    out = new DataOutputStream(new FileOutputStream(outputurl.getPath()+"/temporary/ExamSources6/examsoftware/avengers.rb"));
                    out2 = new DataOutputStream(new FileOutputStream(outputurl.getPath()+"/temporary/ExamSources6/examsoftware/qt.rb"));
                }
              else{
                    out = new DataOutputStream(new FileOutputStream(outputurl.getPath()+"/temporary/ExamSources8/examsoftware/avengers.rb"));
                    out2 = new DataOutputStream(new FileOutputStream(outputurl.getPath()+"/temporary/ExamSources8/examsoftware/qt.rb"));
              }
             
	      out.writeBytes(Encode(Subject)+newLine);
	      out.writeBytes(Encode(SubjectPass)+newLine);
	      out.writeBytes(Encode(Noofque)+newLine);
	      out.writeBytes(Encode(hours)+newLine);
	      out.writeBytes(Encode(minutes)+newLine);
	      out.writeBytes(Encode(Test)+newLine);
              out.writeBytes(Encode(SuperPass));
	      out.flush();
	      out.close();
	      out2.writeBytes(qtype);
	      out2.flush();
	      out2.close();	      
	}
	
	void Add(File file,ZipOutputStream out,String RelativePath) throws IOException{
		String[] filenames=file.list();
                File fx=null;
		for(int i = 0; i < filenames.length; i++) {
                       if(Compatability.equals("JDK6")){
                           fx=new File(outputurl.getPath()+"/temporary/ExamSources6/"+RelativePath+"/"+filenames[i]);
                       }
                       else{
                           fx=new File(outputurl.getPath()+"/temporary/ExamSources8/"+RelativePath+"/"+filenames[i]);
                       }

			if(!fx.isDirectory()){
				BufferedInputStream in =new BufferedInputStream(new  FileInputStream(fx));
        
				out.putNextEntry(new JarEntry(RelativePath+"/"+filenames[i]));
				int c;
				while((c = in.read()) != -1)
					out.write(c);
				in.close();
			}
		}
	}
	
}
