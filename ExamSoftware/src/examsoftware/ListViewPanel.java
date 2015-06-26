/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examsoftware;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JWindow;

/**
 *
 * @author student
 */
public class ListViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListViewPanel
     */
    int nofque;
    int quetype[];
    Images questionpanels[];
    String answers[],filenames[];    
    JPanel[] AnswerPanelsList,jlistPanel;
    JToggleButton button1,button2,button3,button4;
    String ID,Subject,Test;
    public ListViewPanel(int[] quetype,String[] answers,String[] filenames,String ID,String Subject,String Test,JToggleButton button1,JToggleButton button2,JToggleButton button3,JToggleButton button4) {
        this.answers=answers;
        this.Test=Test;
        this.nofque=quetype.length;
        this.quetype=quetype;
        this.filenames=filenames;
        questionpanels=new Images[nofque];
        AnswerPanelsList=new JPanel[nofque];
        this.button1=button1;
        this.button2=button2;
        this.button3=button3;
        this.button4=button4;
        this.ID=ID;
        this.Subject=Subject;
        initComponents();
        jPanel9.revalidate();
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1127, 605));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), null));
        jPanel8.setPreferredSize(new java.awt.Dimension(713, 80));

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        int count=0;
        for(int i=0;i<quetype.length;i++){
            if(quetype[i]!=2){
                count++;
            }
        }
        jLabel4.setText("No. Of Unattempted Questions : "+count);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setDoubleBuffered(true);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        jPanel9.setAutoscrolls(true);
        jPanel9.setPreferredSize(new java.awt.Dimension(1121, 365*nofque));
        jPanel9.setLayout(null);
        jlistPanel=new JPanel[nofque];
        jPanel9.setLayout(new GridLayout(nofque,1,5,10));

        for(int m=0;m<nofque;m++){
            jlistPanel[m]=new JPanel();
            jlistPanel[m].setBackground(Color.WHITE);

            jlistPanel[m].setLayout(new BorderLayout());
            jlistPanel[m].setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            //jlistPanel[m].add("Center",questionpanels[m]=new Images(filenames[m]) );
            jlistPanel[m].add("Center",questionpanels[m]=new Images((m+1)+".rb"));
            if(quetype[m]==0){
                jlistPanel[m].add("South",AnswerPanelsList[m]=new MultipleChoicePanel(m,answers,jLabel4));

            }
            else if(quetype[m]==1){
                jlistPanel[m].add("South",AnswerPanelsList[m]=new TorFPanel(m,answers,jLabel4));
            }
            else if(quetype[m]==2){
                jlistPanel[m].add("South",AnswerPanelsList[m]=new BlankPanel(m,answers,jLabel4));
            }
            else if(quetype[m]==3){
                jlistPanel[m].add("South",new Label(" ",Label.CENTER));

            }

            jPanel9.add(jlistPanel[m]);
        }

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(45);
        jScrollPane1.validate();
        this.jScrollPane1.getVerticalScrollBar().setDoubleBuffered(true);
        this.jScrollPane1.getVerticalScrollBar().setSize(this.getWidth(), this.getHeight());

        jScrollPane1.setViewportView(jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int unattempted=0;

        for(int i=0;i<quetype.length;i++){
            if(quetype[i]!=3 && answers[i].equals("$U")){
                unattempted++;
            }
        }
      
                jPanel8.show(false);
                jScrollPane1.show(false);
                WarningPanel dialog = new WarningPanel(unattempted,nofque,quetype,answers,ID,Subject,Test,button1,button2,button3,button4,jPanel8,jScrollPane1);
                this.setLayout(new BorderLayout());
                this.add(dialog,"Center");
                dialog.setVisible(true);
                 
                 dialog.show(true);
           this.revalidate();
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
