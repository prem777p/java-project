import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add, view, update, remove,exit;
    Home(){
//        insert the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);


//        creating Button
        add = new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employee");
        view.setBounds(830,80,150,40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650,150,150,40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(830,150,150,40);
        remove.addActionListener(this);
        image.add(remove);

        exit = new JButton("Exit Program");
        exit.setBounds(740,220,150,40);
        exit.addActionListener(this);
        image.add(exit);

//        Creating lable
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(640,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(heading);

//        create the Frame
        setLayout(null);
        setVisible(true);
        setSize(1120,630);
        setLocation(250,100);

    }
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if (e.getSource() == view) {
            setVisible(false);
            new ViewEmployees();
        }
        else if (e.getSource() == update) {
            setVisible(false);
            new ViewEmployees();
        }
        else if (e.getSource() == exit) {
            System.exit(0);
            setVisible(false);
        }
        else if (e.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        }
    }
}
