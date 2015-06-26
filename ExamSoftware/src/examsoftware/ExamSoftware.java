/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examsoftware;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author zubaeyr
 */
public class ExamSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       JFrame frame=new JFrame();
       Login lgwin=new Login(frame);
       frame.setUndecorated(true);       
       frame.setLayout(new BorderLayout());
       frame.setBackground(new java.awt.Color(16, 14, 14));
       frame.add(lgwin);
       frame.setSize(328,208);
       frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
      try{
           frame.setOpacity(0.92f);
       }catch(Exception e){}
    }
    
}
