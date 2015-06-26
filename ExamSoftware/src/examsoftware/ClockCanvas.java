/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examsoftware;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Guru
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


public class ClockCanvas extends Canvas implements Runnable{
	int x,y,z=0;
	private Thread timer=null;
	String ID,Subject,Test;
        String answers[];
        Copycat copy;
	public ClockCanvas(int x,int y, JPanel XamPanel,String ID, String Subject,String Test ,String[] answers,Copycat copy){
                this.x=x;
                this.y=y;
                this.ID=ID;
                this.Subject=Subject;
                this.Test=Test;
                this.answers=answers;
                this.copy=copy;
		timer=new Thread(this);
		timer.start();
               
	}
	public void run() {
		// TODO Auto-generated method stub
		 while(x!=0||y!=0||z!=0){
		     	try{
		     		timer.sleep(1000);
		     	}catch(InterruptedException e){}
		     	
		     	if(z==0 &&(x!=0||y!=0)){
		     		z=59;
		     		if(y==0 && x!=0){
		     			y=59;
		     			x=x-1;        			
		     		}
		     		else{
		     			y=y-1;
		     		}
		       	}
		 		else{
		 			z=z-1;
		 		}
		     	
		     	repaint();
		      
		      
			
		}
		 if(x==0&&y==0&&z==0){
     

      if(copy.isShowing()){
          System.exit(0);//put code here
      }                
      new AnswerFileGenerator(answers,ID,Subject,Test); 
      System.exit(0);
		 }
	}
	public void paint(Graphics g){
		
	    g.setFont(new Font("TimesRoman",Font.BOLD,16));
	    if(z<10 && y>9){
			g.drawString("0"+x+":"+y+":0"+z,20,20);
		}
		else if(z>9 && y<10 ){
			g.drawString("0"+x+":0"+y+":"+z,20,20);
		}
		else if(z<10 && y<10){
			g.drawString("0"+x+":0"+y+":0"+z,20,20);
		}
		else if(z>9 && y>9){
		g.drawString("0"+x+":"+y+":"+z,20,20);
		}
	}
	

}

