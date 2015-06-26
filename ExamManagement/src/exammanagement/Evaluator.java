/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exammanagement;

/**
 *
 * @author zubaeyr
 */
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Evaluator {
	
	char[] Decode=new char[]  {'Y','N','F','I','C','W','L','B','K','U','O','M','X','S','E','V','Z','P','D','R','J','G','T','H','A','Q','$','$','$','$','$','$','y','n','f','i','c','w','l','b','k','u','o','m','x','s','e','v','z','p','d','r','j','g','t','h','a','q'};
        URL url,outputurl;
	float MarksPattern[];
	String CorrectAnswers[],Test,SubjectName;
	Map<String, String> studMarks = new HashMap<String, String>();
        float AdditionalMarks=0;
	boolean casesensitive=true;	
	
	Evaluator(String Answers[],float[] MarksPattern,URL url,URL outputurl,String Test,String SubjectName,float AdditionalMarks,boolean casesensitive){
		this.url=url;
                this.outputurl=outputurl;
                this.Test=Test;
                this.casesensitive=casesensitive;
                this.SubjectName=SubjectName;
		this.CorrectAnswers=Answers;
		this.MarksPattern=MarksPattern;
                this.AdditionalMarks=AdditionalMarks;
		File file=new File(url.getPath());
		String[] filenames=file.list();
		for(int i=0;i<filenames.length;i++){
			
			try{
                            if(filenames[i].trim().endsWith(".rb")){
                                Decode(filenames[i]);
                            }
			}catch(Exception e){e.printStackTrace();}
		}
		PrintMarks();

	}
	
	
	void Decode(String filename) throws MalformedURLException{
			URL url2=new URL("file:"+url.getPath().toString()+"/"+filename.trim());
			File f=new File(url2.getPath());
			String ID=filename.substring(0,filename.indexOf("_"));
                        
			try {
				DataInputStream d=new DataInputStream(new FileInputStream(f));
				int j;
				String answers="";
				while((j=d.read())!=-1){
					if(j!=0)
						answers=answers+String.valueOf((char)j);
				}
				d.close();
				int count=1,i=0,h=0;
				float marks=0;
				
				String[] studentsanswers=new String[CorrectAnswers.length];
				while(i<answers.length()){	
					if(count%100==0){
						if(answers.substring(i, i+1).equals("0")){studentsanswers[h]="A";}
						else if(answers.substring(i,i+1).equals("1")){studentsanswers[h]="B";}
						else if(answers.substring(i,i+1).equals("2")){studentsanswers[h]="C";}
						else if(answers.substring(i,i+1).equals("3")){studentsanswers[h]="D";}
						else if(answers.substring(i,i+1).equals("4")){studentsanswers[h]="T";}
						else if(answers.substring(i,i+1).equals("5")){studentsanswers[h]="F";}
						else if(answers.substring(i,i+1).equals("6")){studentsanswers[h]="N";}
						else if(answers.substring(i,i+1).equals("7")){studentsanswers[h]="U";}
						else if(answers.substring(i,i+1).equals("8")){
							int end=answers.substring(i+1,answers.length()).indexOf("9");
							String temp=answers.substring(i+1,i+1+end).trim();							
                                                for(int k=0;k<temp.length();k++){
                                                        int c=((int)temp.charAt(k))-65;
                                                        if((c>25&&c<32)||(c<0 )|| (c>57)){
									continue;
							}
                                                            temp=temp.substring(0,k)+String.valueOf(Decode[c])+temp.substring(k+1,temp.length());
							}
                                                studentsanswers[h]=temp;
							i=i+1+end;
						}
						h++;
					}
					count++;
					i++;
					
				}
                           
                                if(casesensitive){
                                   
                                    for(int l=0;l<studentsanswers.length;l++){
					if(studentsanswers[l].equals(CorrectAnswers[l])){
						marks=marks+MarksPattern[l];
					}
                                    }
                                }
                                else{
                                  
                                    for(int l=0;l<studentsanswers.length;l++){
					if(studentsanswers[l].toLowerCase().equals(CorrectAnswers[l].toLowerCase())){
						marks=marks+MarksPattern[l];
					}
                                    }
                                }
			studMarks.put(ID, String.valueOf(marks+AdditionalMarks));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void PrintMarks(){
         
            
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(Test+" "+SubjectName+" Marks");     
            XSSFRow row;
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            style.setAlignment(HorizontalAlignment.CENTER);
            Cell cell; 
            row=sheet.createRow(0);
            cell=row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("Student ID");
            cell=row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue("Marks");
            font.setBold(false);
            style.setFont(font);
            int i=1;
            for (Map.Entry<String, String> entry : studMarks.entrySet()) {
                try {
                       row = sheet.createRow(i);
                       String ID=entry.getKey();
                       String Marks=entry.getValue();           
                       cell = row.createCell(0);
                       cell.setCellValue(ID);
                       cell=row.createCell(1);
                       cell.setCellValue(Marks);
                       i++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            Date date=new Date();
            try{
                URL url2 = null;
                if(date.getDate()<10 && date.getMonth()>8){
                    url2=new URL("file:"+outputurl.getPath().toString()+"/"+SubjectName+"_"+Test+"-Marks"+"_0"+date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+".xlsx");
            }
            else if(date.getDate()>9 && date.getMonth()<9){
            	url2=new URL("file:"+outputurl.getPath().toString()+"/"+SubjectName+"_"+Test+"-Marks"+"_"+date.getDate()+"-0"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+".xlsx");
            }
            else if(date.getDate()<10 && date.getMonth()<9){
                url2=new URL("file:"+outputurl.getPath().toString()+"/"+SubjectName+"_"+Test+"-Marks"+"_0"+date.getDate()+"-0"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+".xlsx");
            }
                File f=new File(url2.getPath());
                FileOutputStream out = new FileOutputStream(f);
                workbook.write(out);
                out.close();
            }catch(Exception e){e.printStackTrace();}
        }
       
	
}
