
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton bookHotel,viewBookedHotel,payments,deletePersonalDetails;
    JButton updatePersonalDetails,addPersonalDetails,viewPersonalDetails,checkPackages,bookPackages,viewPackages,viewHotels,destinations;
    Dashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1600, 65);
        p1.setBackground(new Color(133,193,233));
        add(p1);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70, 70 , Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setForeground(Color.WHITE);
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 65, 300, 900);
        p2.setBackground(new Color(133,193,233));
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 45);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 45, 300, 45);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails); 
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 90, 300, 45);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails); 
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 135, 300, 45);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails); 
        
        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, 180, 300, 45);
        checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackages.addActionListener(this);
        p2.add(checkPackages); 
        
        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(0, 225, 300, 45);
        bookPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackages.addActionListener(this);
        p2.add(bookPackages); 
        
        viewPackages = new JButton("View Packages");
        viewPackages.setBounds(0, 270, 300, 45);
        viewPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackages.addActionListener(this);
        p2.add(viewPackages); 
        
        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 315, 300, 45);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.addActionListener(this);
        p2.add(viewHotels); 
        
        bookHotel= new JButton("Book Hotels");
        bookHotel.setBounds(0, 360, 300, 45);
        bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotel.addActionListener(this);
        p2.add(bookHotel); 
        
        viewBookedHotel= new JButton("View Booked Hotels");
        viewBookedHotel.setBounds(0, 405, 300, 45);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations= new JButton("Destinations");
        destinations.setBounds(0, 450, 300, 45);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments= new JButton("Payment");
        payments.setBounds(0, 495, 300, 45);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.addActionListener(this);
        p2.add(payments);
        
        
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000 , Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setFont(new Font("Raleway",Font.PLAIN,50));
        text.setForeground(Color.BLACK);
        image.add(text);
        
        
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        } else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        } else if(ae.getSource()== updatePersonalDetails){
            new UpdateCustomer(username);
        } else if(ae.getSource()== checkPackages){
            new CheckPackage();
        } else if(ae.getSource() == bookPackages){
            new BookPackage(username);
        } else if(ae.getSource()==viewPackages){
            new ViewPackage(username);
        } else if(ae.getSource() == viewHotels){
            new CheckHotels();
        } else if(ae.getSource() == destinations){
            new Destinations();
        } else if (ae.getSource()==bookHotel){
            new BookHotel(username);
        } else if(ae.getSource()==viewBookedHotel){
            new ViewBookedHotel(username);
        } else if(ae.getSource()==payments){
            new Payment();
        } else if (ae.getSource()==deletePersonalDetails){
            new DeleteDetails(username);
        }
    }
    
    public static void main(String[] args){
       new Dashboard("Rishabh001@");
    }
}
