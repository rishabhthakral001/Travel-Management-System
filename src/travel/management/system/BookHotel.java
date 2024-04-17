
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    JLabel labelusername,labelphone,labelid,labelnumber,labelprice;
    String username;
    JButton checkprice,bookpackage,back;
    BookHotel(String username){
        this.username = username;
        setLayout(null);
        setBounds(350,200,1100,600);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);
        
        try{
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpersons.setBounds(40,150,150,25);
        add(lblpersons );
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbldays.setBounds(40,190,150,20);
        add(lbldays );
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblac.setBounds(40,230,150,20);
        add(lblac );
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);
        
        JLabel lblfood  = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblfood.setBounds(40,270,150,20);
        add(lblfood );
        
        cfood= new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblid.setBounds(40,310,150,20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,310,200,20);
        labelid.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblnumber.setBounds(40,350,150,20);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,150,25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblphone.setBounds(40,390,150,20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,20);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbltotal.setBounds(40,430,150,20);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,430,150,25);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setForeground(Color.BLACK);
        bookpackage.setBackground(Color.WHITE);
        bookpackage.setBounds(200,490,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(340,490,120,25);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600 ,400 ,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,400);
        add(image);
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            
            try{
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected=cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs "+total);
                    }else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == bookpackage){
            try{
                Conn c=new Conn();
                String query = "insert into bookhotel values('"+labelusername.getText()+"' , '"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')"; 
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Sucessfully");
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
