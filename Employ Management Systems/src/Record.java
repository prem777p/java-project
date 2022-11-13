import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Record extends JFrame implements ActionListener {

    Record(){
        setLayout(null);                                     // not use defalt layout
//        to write if frame use JLable class
        JLabel heading = new JLabel("EMPLOY MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);  //  place any positon on frame
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLUE);
        add(heading);

//       to add image in frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700, Image.SCALE_DEFAULT);   // set image Ato frame
        ImageIcon i3 = new ImageIcon(i2);                    // we can't add image directly on frame
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);


//        add button on frame
        JButton clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setBounds(400,400,300,70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.white);
        clickHere.addActionListener(this);               // when button is click then tell work of button
        image.add(clickHere);


//        Set background color of frame
        getContentPane().setBackground(Color.WHITE);


//        Create Frame
        setSize(1170,650);
        setLocation(200,50);                         // set location of frame on screen
        setVisible(true);

//                           for blinking heading by this logic
        while (true){
                heading.setVisible(false);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){ }
                heading.setVisible(true);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){ }
        }
    }

//     override method due to ActionListner Interface
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();             // open login page
    }

    public static void main(String[] args) {
        new Record();
    }

}
