package Management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ClockMessageGui extends JPanel implements Runnable{
    Calendar today = Calendar.getInstance();
    int i = today.get(Calendar.AM_PM);
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    String time = sdf.format(new Date());
    JLabel timeLabel, ampmLabel;
    String[] ampm = {"AM", "PM"};
    public ClockMessageGui(){
         this.setLayout(null);
         timeLabel = new JLabel(time);
         timeLabel.setBounds(0,0,100,70);
         timeLabel.setFont(new Font("",Font.BOLD, 25));
         timeLabel.setForeground(new Color(170,170,170));
          
         ampmLabel = new JLabel(ampm[i]);
         ampmLabel.setBounds(33,0,100,110);
         ampmLabel.setFont(new Font("",Font.BOLD, 20));
         ampmLabel.setForeground(new Color(170,170,170));
          
         add(timeLabel, BorderLayout.NORTH);
         add(ampmLabel, BorderLayout.CENTER);
     }
     public void run(){
         do{
             try{
                 Thread.sleep(1000);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
             timeLabel.setText(sdf.format(new Date()));
         }while(true);
     }
 }