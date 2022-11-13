import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
//    create choice box
    Choice cempId;
    JButton delete,back;
    RemoveEmployee () {
//        set background and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


//        taken employee id
        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50,50,100,30);
        add(labelempid);

//        take empid by choice box
        cempId = new Choice();
        cempId.setBounds(200,50,150,30);
        add(cempId);

//        take id from database
        try {
            ConnectionDb conn = new ConnectionDb();
            String query = "select * from employee";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                cempId.add(rs.getString("empId"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }

//              create lable
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);

        JLabel lableEmail = new JLabel("E-mail");
        lableEmail.setBounds(50,200,100,30);
        add(lableEmail);

        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(200,200,100,30);
        add(lblEmail);

//        take id from database
        try {
            ConnectionDb conn = new ConnectionDb();
            String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblEmail.setText(rs.getString("email"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }

//        to take another vale at run time from database
        cempId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try {
                    ConnectionDb conn = new ConnectionDb();
                    String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblEmail.setText(rs.getString("email"));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

//        create delete button
        delete = new JButton("Delete");
        delete.setBounds(60,280,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

//        create delete button
        back = new JButton("Back");
        back.setBounds(200,280,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

//               to add image in frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);   // set image Ato frame
        ImageIcon i3 = new ImageIcon(i2);                    // we can't add image directly on frame
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,600,400);
        add(image);

//        create frame
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            try {
                ConnectionDb conn = new ConnectionDb();
                String query = "delete from employee where empId = '"+cempId.getSelectedItem()+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Detail Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
