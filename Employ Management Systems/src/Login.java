import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassward;
    Login(){
//        set background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        creating lable (Username)
        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);

//        creating textfile
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);


//        creating lable (Passward)
        JLabel lblpassward = new JLabel("PASSWARD");
        lblpassward.setBounds(40,70,100,30);
        add(lblpassward);

//        creating textfile(Passward)
        tfpassward = new JTextField();
        tfpassward.setBounds(150,70,150,30);
        add(tfpassward);

//        creating Button login
        JButton btlogin = new JButton("LOGIN");
        btlogin.setBounds(150,140,150,30);
        btlogin.setBackground(Color.BLACK);
        btlogin.setForeground(Color.WHITE);
        btlogin.addActionListener(this);
        add(btlogin);

//        inserting Image on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

//                  creating frame
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
//            take vale form textfield on login page
            String username = tfusername.getText();
            String passward = tfpassward.getText();

//             match the username and passward from database so creating querie
            String query = "select * from login where username = '"+username+"' and passward = '"+passward+"'";

//            step4 : execuite query
            ConnectionDb c = new ConnectionDb();
            ResultSet rs = c.s.executeQuery(query);  // store data in resultset class comes from query

//            check rs is empty or not
            if (rs.next()){
                setVisible(false);
                new Home();
            }
            else{
//                show popup for invalid entry
                JOptionPane.showMessageDialog(null,"Username and Passward Invalid");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
