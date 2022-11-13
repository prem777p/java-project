import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int num = ran.nextInt(999999);

//    make globle variable
    JTextField tfname, tffname, tfaddress, tfphone,tfemail, tfsalary, tfaadharno, tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblemployeeid;
    JButton add, back;
    AddEmployee(){
//        change color of frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        creating heading lable
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);

//        creating lable for detail
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        tfname = new JTextField();       // text field
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);

        tffname = new JTextField();       // text field
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);

        dcdob = new JDateChooser();      // for dob creating calender button
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);

        tfsalary = new JTextField();       // text field
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);

        tfaddress = new JTextField();       // text field
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);

        tfphone = new JTextField();       // text field
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("E-mail");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);

        tfemail = new JTextField();       // text field
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel labelHE = new JLabel("Higher Education");
        labelHE.setBounds(400,300,150,30);
        labelHE.setFont(new Font("serif",Font.PLAIN,20));
        add(labelHE);

        String courses[] = {"","BBA","BCA","BA","BCOM","BTech","MBA","MCA","MA","MTech","MSC","BSC"};
        cbeducation = new JComboBox(courses);       // text field
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);

        tfdesignation = new JTextField();       // text field
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel labelaadharno = new JLabel("Aadhar No.");
        labelaadharno.setBounds(400,350,150,30);
        labelaadharno.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadharno);

        tfaadharno = new JTextField();       // text field
        tfaadharno.setBounds(600,350,150,30);
        add(tfaadharno);


        JLabel labelemployid = new JLabel("Employee ID : ");
        labelemployid.setBounds(50,400,150,30);
        labelemployid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemployid);

        lblemployeeid = new JLabel("" + num);
        lblemployeeid.setBounds(200,400,150,30);
        lblemployeeid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemployeeid);

//        create button
        add = new JButton("Add Details");
        add.setBounds(250,520,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,520,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

//        creating frame
        setVisible(true);
        setSize(900,700);
        setLocation(300,50);

    }
    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadharno.getText();
            String empId = lblemployeeid.getText();

            try {
                ConnectionDb conn = new ConnectionDb();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);          // to inset int database
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
}
