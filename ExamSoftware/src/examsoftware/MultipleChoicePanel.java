/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examsoftware;

import javax.swing.JLabel;

/**
 *
 * @author Guru
 */
public class MultipleChoicePanel extends javax.swing.JPanel {

    /**
     * Creates new form MultipleChoicePanel
     */
    int qno;
    String answers[];
    JLabel UnattemptedLabel;
    public MultipleChoicePanel(int i,String answers[],JLabel UnattemptedLabel) {
        this.qno=i;
        this.UnattemptedLabel=UnattemptedLabel;
        this.answers=answers;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(255, 255, 255));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jToggleButton1.setText("A");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("B");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("C");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("D");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected()==true){answers[qno]="$A";}
        else {answers[qno]="$U";}    
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        countattemptquest();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton2.isSelected()==true){answers[qno]="$B";}
        else {answers[qno]="$U";}    
        jToggleButton1.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        countattemptquest();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton3.isSelected()==true){answers[qno]="$C";}
        else {answers[qno]="$U";}    
        jToggleButton2.setSelected(false);
        jToggleButton1.setSelected(false);
        jToggleButton4.setSelected(false);
        countattemptquest();
        
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton4.isSelected()==true){answers[qno]="$D";}
        else {answers[qno]="$U";}           
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton1.setSelected(false);
        countattemptquest();
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        jToggleButton1.setSelected(false);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
         switch(answers[qno].toString().charAt(1)){
            case 'A':{
                    jToggleButton1.setSelected(true);
                    jToggleButton2.setSelected(false);
                    jToggleButton3.setSelected(false);
                    jToggleButton4.setSelected(false);
                    countattemptquest();
                break;
            }
                
            case 'B':{
                    jToggleButton1.setSelected(false);
                    jToggleButton2.setSelected(true);
                    jToggleButton3.setSelected(false);
                    jToggleButton4.setSelected(false);
                    countattemptquest();
                break;
            }
            case 'C':{
                    jToggleButton1.setSelected(false);
                    jToggleButton2.setSelected(false);
                    jToggleButton3.setSelected(true);
                    jToggleButton4.setSelected(false);
                    countattemptquest();
                break;
            }
            case 'D':{
                    jToggleButton1.setSelected(false);
                    jToggleButton2.setSelected(false);
                    jToggleButton3.setSelected(false);
                    jToggleButton4.setSelected(true);
                    countattemptquest();
                break;
            }
            case 'E':{
                    jToggleButton1.setSelected(false);
                    jToggleButton2.setSelected(false);
                    jToggleButton3.setSelected(false);
                    jToggleButton4.setSelected(false);
                    countattemptquest();
                break;
            }           
        }
           
    }//GEN-LAST:event_formAncestorAdded

    private void countattemptquest(){
        int unattempted=0;
       
        for(int i=0;i<answers.length;i++){            
          if(answers[i].equals("$U")){
               unattempted++;               
          }          
        }
        UnattemptedLabel.setText("No. Of Unattempted Questions: "+unattempted);
        UnattemptedLabel.repaint();
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JToggleButton jToggleButton3;
    public javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables
}