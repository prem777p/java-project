import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener {
    JTable table;
    Choice cempId;  // check box for search button

//    make global button
    JButton search, print, update, back;
    ViewEmployees(){
//        set background of frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        make lable for search
        JLabel lblsearch = new JLabel("Search by Employee Id");
        lblsearch.setBounds(20,20,150,20);
        add(lblsearch);

        cempId = new Choice();
        cempId.setBounds(180,20,150,20);
        add(cempId);

//        fill search check box
        try {
            ConnectionDb conn = new ConnectionDb();
            ResultSet rs = conn.s.executeQuery("select * from employee");  // query for take data from database and store in resultset class

            // for fill search bar check box
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//              object for creating table
        table = new JTable();

//        read database to show data
        try {
            ConnectionDb conn = new ConnectionDb();
            ResultSet rs = conn.s.executeQuery("select * from employee");  // query for take data from database and store in resultset class
            table.setModel(DbUtils.resultSetToTableModel(rs)); // inset all data in rs

            // for fill search bar check box
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        for scroll bar after full of page
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

//        make button
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

//        create frame
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search){
            String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'"; // query for take data from database for search
            try {
                ConnectionDb conn = new ConnectionDb();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else if (e.getSource() == print){
            try {
                table.print();     //by java to access printer
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else if (e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(cempId.getSelectedItem());
        }
        else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployees();
    }
}
