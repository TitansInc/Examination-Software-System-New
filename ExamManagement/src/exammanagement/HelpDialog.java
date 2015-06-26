/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exammanagement;

import javax.swing.JFrame;

/**
 *
 * @author student
 */
public class HelpDialog extends javax.swing.JDialog {

    /**
     * Creates new form WarningDialog
     */
    String MarksPattern="Note :\n\n1. Marks Pattern's values must be a numeric, which can either be a float or an integer\n2. Successive values must be seperated by a comma(,)\n3. All values need not be entered on a single line. They can be entered across multiple lines.\n4. If the question is a Descriptive,then enter marks as 0\n5. Marks Pattern for all the questions must be entered\n\nExample:\n\n	If there are 10 questions of which first five carry 1 marks each, and next four carry\n 	0.5 marks each and the last one is a descriptive(0 marks). Then the marks pattern\n	can be given as any one of the many possiblities, of which two are shown below:\n	\n	1,1,1,1,1,0.5,0.5,0.5,0.5,0       (Note that there is no comma(,) after the last value)\n\n        (or)\n\n	1,1		            (Since values can be entered across multiple lines)\n	1,		            (This is one of the many possibilities)\n	1,1\n	0.5,0.5,0.5,\n	0.5,\n	0";
    String CorrectAnswers="Note :\n" +
"1. Multiple answers must be seperated by a comma(,)\n" +
"2. All answers need not be entered on a single line. They can be entered across multiple lines.\n" +
"3. Answers of all the questions should be entered\n" +
"4. You can choose \"Case Sensitive\" evaluation, for the 'text answers' to be evaluated Case-Sensitively.\n" +
"5. Following values should be used as substitution rule for the respective answers:\n" +
"\n" +
"	i.   For 'A','B','C',D' enter A,B,C,D respectively\n" +
"	ii.  For True use T, and for False use F\n" +
"	iii. If the question is a descriptive, enter N\n" +
"	iv.  for 'text' answers enclose the text between $ signs\n" +
"           example: $Hey! boy? i didn't do nothing!$, $He said,\"I didn't do anything!\".$\n" +
"\n" +
"Example:\n" +
"\n" +
"	If there are 10 questions of which first 9 have answers as A,B,C,D,True,False,This ain't a text answer, True,D, and the last one is a descriptive. Then enter any one of the many possiblities, of which two are shown below:\n" +
"\n" +
"	A,B,C,D,T,F,$This ain't a text answer$,T,D,N	(There is no comma(,) after the last value)\n" +
"	\n" +
"	(or)\n\n" +
"	A,B,C,				(Answers can be entered across multiple lines)\n" +
"	D,				(This is one of the many possibilities)\n" +
"	T,\n" +
"	F,$This ain't a text answer$,\n" +
"	T,D,N	";
    
    String QuestionType="Note :\n" +
"1. Successive Question types must be seperated by a comma(,)\n" +
"2. All values need not be entered on a single line. They can be entered across multiple lines.\n" +
"3. Question type of all the questions must be entered\n" +
"4. Following values should be used as substitution rule for the respective Question types:\n" +
"\n" +
"	i.   For Multiple choice question, enter M \n" +
"	ii.  For True or False question, enter TF\n" +
"	iii. If the question is a descriptive, enter D\n" +
"	iv.  for 'text-type' questions enter T (Don't confuse it with 'TF',which stands for True or False)\n" +
"\n" +
"Example:\n" +
"\n" +
"	If there are 10 questions of which if the first 4 are Multiple choice, 5th and 6th are True or False type, next 3 are 'text-answer' type of questions, and the last one is a descriptive. Then enter any one of the many possiblities, of which two are shown below:\n" +
"\n" +
"	M,M,M,M,TF,TF,T,T,T,D	  	(There is no comma(,) after the last value)\n" +
"	\n" +
"	(or)\n" +
"\n" +
"	M,M,M				(Answers can be entered across multiple lines)\n" +
"	TF,				(This is one of the many possibilities)\n" +
"	TF,				(Don't confuse TF with T)\n" +
"	T,T,\n" +
"	T,D";
    public HelpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    void Help(int helptype){
         if(helptype==1){
            jTextPane1.setText(MarksPattern);
        }
        else if(helptype==2){
            jTextPane1.setText(CorrectAnswers);
        }
        else if(helptype==3){
            jTextPane1.setText(QuestionType);
        }
        else if(helptype==4){
            jTextPane1.setText("Procedure for entering Marks Pattern :\n\n"+MarksPattern+"\n\n\n"+"Procedure for entering Correct Answers :\n\n"+CorrectAnswers+"\n\n\n"+"Procedure for entering QuestionType :\n\n"+QuestionType+"\n\n");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(21, 21, 21));
        setLocationByPlatform(true);
        setUndecorated(true);
  	try{     
//	 setOpacity(0.97F);
	}catch(Exception e){}
        jButton1.setForeground(new java.awt.Color(1, 1, 1));
        jButton1.setText("Okay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}