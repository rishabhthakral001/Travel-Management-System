
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername,labelphone,labelid,labelnumber,labelprice;
    String username;
    JButton checkprice,bookpackage,back;
    BookPackage(String username){
        this.username = username;
        setLayout(null);
        setBounds(350,200,1100,500);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblusername.setBounds(40,70,150,20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN,16));
        labelusername.setBounds(250 ,70,200,20);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpersons.setBounds(40,150,150,20);
        add(lblpersons );
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblid.setBounds(40,190,150,20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,190,200,20);
        labelid.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblnumber.setBounds(40,230,150,20);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblphone.setBounds(40,270,150,20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,20);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbltotal.setBounds(40,310,150,20);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,310,150,25);
        labelprice.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelprice);
        
        try{
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setForeground(Color.BLACK);
        checkprice.setBackground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
        
        bookpackage = new JButton("Book Package");
        bookpackage.setForeground(Color.BLACK);
        bookpackage.setBackground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(340,380,120,25);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500 ,300 ,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost+=36000;
            }else if(pack.equals("Silver Package")){
                cost+=24000;
            }else{
                cost+=12000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs "+cost);
        }else if (ae.getSource() == bookpackage){
            try{
                Conn c=new Conn();
                String query = "insert into bookpackage values('"+labelusername.getText()+"' , '"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')"; 
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Packaged Booked Sucessfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
    }
}
