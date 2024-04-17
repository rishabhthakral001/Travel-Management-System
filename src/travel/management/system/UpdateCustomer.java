
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail,tfname,tfgender,tfid;
    JButton update,back;

    
    UpdateCustomer(String username){ 
        setLayout(null);
        setBounds(500,200,850,550);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220 ,50,150,25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        
        tfid=new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber); 
        
        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220 ,170,150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        tfgender=new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry); 
        
        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress); 
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone); 
        
        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(30,370,150,25);
        add(lblemail); 
        
        tfemail=new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        
        update = new JButton("UPDATE");
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.setBounds( 70,430,100,25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds( 220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(400, 300 , Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,400);
        add(image);
        
        try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer where username = '"+username+"'");
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               tfid.setText(rs.getString("id"));
               tfnumber.setText(rs.getString("number"));
               tfname.setText(rs.getString("name"));
               tfgender.setText(rs.getString("gender"));
               tfcountry.setText(rs.getString("country"));
               tfaddress.setText(rs.getString("address"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
           }
        } catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==update){
            String username = labelusername.getText();
            String id=tfid.getText();
            String number= tfnumber.getText();
            String name=tfname.getText();
            String gender = tfid.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            
            try{
                Conn c= new Conn();
                String query="update customer set username = '"+username+"', id = '"+id+"' , number = '"+number+"' , name = '"+name+"' , gender = '"+gender+"' , country = '"+country+"' , address = '"+address+"' , phone = '"+phone+"' , email = '"+email+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Updated Sucessfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
        
        
        
    }
    public static void main(String[] Args ){
    }
}
