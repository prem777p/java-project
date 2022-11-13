import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    //    make globle variable
    JTextField tfeducation, tffname, tfaddress, tfphone,tfemail, tfsalary, tfaadharno, tfdesignation;
    JLabel lblemployeeid;
    JButton update, back;
    String empId;
    UpdateEmployee (String empId) {
        this.empId = empId;
//        change color of frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        creating heading lable
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);

//        creating lable for detail
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        JLabel lblname = new JLabel();       // text field
        lblname.setBounds(200,150,150,30);
        add(lblname);

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

        JLabel lbldob= new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

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

        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);

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

        JLabel lblaadharno = new JLabel();
        lblaadharno.setBounds(600,350,150,30);
        add(lblaadharno);


        JLabel labelemployid = new JLabel("Employee ID : ");
        labelemployid.setBounds(50,400,150,30);
        labelemployid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemployid);

        lblemployeeid = new JLabel();
        lblemployeeid.setBounds(200,400,150,30);
        lblemployeeid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemployeeid);

        try{
            ConnectionDb conn = new ConnectionDb();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                lblaadharno.setText(rs.getString("aadhar"));
                lblemployeeid.setText(rs.getString("empId"));
            }
        }catch (Exception ee){
            ee.printStackTrace();
        }

//        create button
        update = new JButton("Update Details");
        update.setBounds(250,520,150,40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();

            try {
                ConnectionDb conn = new ConnectionDb();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email =  '"+email+"',education = '"+education+"',designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);          // to Update int database
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("cempId.getSelectedItem()");
    }
}
