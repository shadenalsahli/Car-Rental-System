package project1;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.TextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

    public class CarsJFrame extends JFrame { // start CarsJFrame Class

    private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JLabel label_1_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextArea textArea;
	
	
	// CarRental obj][poi       		
    static CarRental carRental =new CarRental(100);
	
	// start the main of Class CarsJFrame
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
	    public void run() {
		    try {
		    	CarsJFrame frame = new CarsJFrame();
		  		  frame.setVisible(true);
			} catch (Exception e) {
			      e.printStackTrace(); }}
		    });}
	
    //--------------------------
	
	public CarsJFrame() {
       
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			int choise = JOptionPane.showConfirmDialog(null, "Do you want to save the new changes?", "CLOSE", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (choise == JOptionPane.YES_OPTION) {
                try {
                      carRental.saveToFile();	
                      JOptionPane.showMessageDialog(null, "Thank you for using Car Rental System\n             All changes was saved", "Thank you",
                      JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                      JOptionPane.showMessageDialog(null, "Can NOT save the data!!!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                      JOptionPane.showMessageDialog(null, "Can NOT save the data!!!", "Error", JOptionPane.ERROR_MESSAGE); }
                } else {
                      JOptionPane.showMessageDialog(null, "Thank you for using Car Rental System\n          All changes was not saved", "Thank you",
                      JOptionPane.INFORMATION_MESSAGE); }
  
                      System.exit(0); }
        });
		setResizable(false);
		setTitle("CAR RENTAL SYSTEM");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1135, 831);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setForeground(UIManager.getColor("activeCaptionText"));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			carRental.loadFromFile();
		    } catch (ClassNotFoundException | IOException e1) {}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		panel_1.setBounds(32, 346, 344, 432);
		panel_1.setBackground(new Color(245, 245, 245));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new car ");
		lblNewLabel.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 25));
		lblNewLabel.setBounds(110, 6, 189, 45);
		lblNewLabel.setToolTipText("");
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("Plate No :");
		label.setToolTipText("");
		label.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label.setBounds(38, 49, 80, 45);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Price Per Day :");
		label_1.setToolTipText("");
		label_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_1.setBounds(38, 92, 97, 45);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Model :");
		label_2.setToolTipText("");
		label_2.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_2.setBounds(37, 134, 51, 45);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Color :");
		label_3.setToolTipText("");
		label_3.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_3.setBounds(38, 176, 64, 45);
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(84, 262, 192, 109);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("Driver info :");
		label_4.setEnabled(false);
		label_4.setBounds(16, 0, 99, 45);
		panel_2.add(label_4);
		label_4.setToolTipText("");
		label_4.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 16));
		
		JLabel label_5 = new JLabel("ID :");
		label_5.setEnabled(false);
		label_5.setToolTipText("");
		label_5.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_5.setBounds(16, 37, 38, 45);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Name :");
		label_6.setEnabled(false);
		label_6.setBounds(16, 57, 38, 45);
		panel_2.add(label_6);
		label_6.setToolTipText("");
		label_6.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(55, 50, 120, 17);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(55, 70, 120, 17);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(84, 147, 97, 17);
		panel_1.add(textField_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 189, 97, 17);
		panel_1.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 105, 97, 17);
		panel_1.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(101, 63, 97, 17);
		panel_1.add(textField_5);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Economy");
		rdbtnNewRadioButton.setSelected(true);
		JRadioButton radioButton = new JRadioButton("VIP");
		JButton btnNewButton = new JButton("Add New Car");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=0;
				String name="";
				double pricePerDays = 0;
				boolean added=false;
				String plateNo = "";
				
				if (!isFilled(textField_5, "Plate No")) {
		            return; }
				plateNo = textField_5.getText();
				
		        if (!isFilled(textField_3, "Price Per Day")) {
		            return; }
		        try {
			    	pricePerDays = Double.parseDouble(textField_3.getText());
					}catch(  NumberFormatException error ) {
				    JOptionPane.showMessageDialog(null, "Enter Right Price Per Day -Digit only- ","Error",JOptionPane.ERROR_MESSAGE); 
				    textField_3.setText("");
				    return; }
		        
		        if (!isFilled(textField_4, "Model")) {
		            return; }
		        String model = textField_4.getText();
		        
		        if (!isFilled(textField_1, "Color")) {
		            return; }
		        String color = textField_1.getText();

			    if( rdbtnNewRadioButton.isSelected() ) {
				    added = carRental.addCar(new Economy(plateNo,pricePerDays,model,color));
			    }else if( radioButton.isSelected() ){
				if (!isFilled(textField, "Driver Id")) {
		            return; }
				try {
				    id = Integer.parseInt(textField.getText());}
					catch(  NumberFormatException error ) {
					JOptionPane.showMessageDialog(null, "Enter Right ID -Digit only- ","Error", JOptionPane.ERROR_MESSAGE);
				    textField.setText("");
					return; }
				   
		        if (!isFilled(textField_2, "Driver Name")) {
		            return; }
			    name = textField_2.getText();
			    
			    added = carRental.addCar( new VIP(plateNo,pricePerDays,model,color, new Driver( id, name )));}
			    
			   if(added) {
	
			         JOptionPane.showMessageDialog(null, "The car has been added successfully ..","Add New Car",JOptionPane.INFORMATION_MESSAGE);
			      }else 
				     JOptionPane.showMessageDialog(null, "The car has not been added successfully !!","Add New Car",JOptionPane.WARNING_MESSAGE);			   
			         textField_5.setText("");
		        	 textField_3.setText("");
			         textField_4.setText("");
			         textField_1.setText("");
			         textField.setText("");
			         textField_2.setText(""); }
		});		
		btnNewButton.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		btnNewButton.setBounds(110, 394, 133, 32);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		panel.setBounds(399, 346, 344, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_7 = new JLabel("Show Information");
		label_7.setToolTipText("");
		label_7.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 22));
		label_7.setBounds(91, 0, 189, 45);
		panel.add(label_7);
		textArea = new JTextArea();
		textArea.setBackground(new Color(211, 211, 211));
		textArea.setEditable(false);
		
		JButton button = new JButton("Show all available VIP");
		button.setBackground(SystemColor.infoText);
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				  textArea.setText("");
				  VIP [] a=carRental.searchAvailableVIP();
				  if(a!=null) {					
				  for(int i=0;i<a.length;i++) {
				  if(a[i]!=null)
				  textArea.append(a[i].toString()+"\n---------------------------\n");} } }
		});
		button.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		button.setBounds(31, 56, 278, 33);
		panel.add(button);
		
		JButton button_1 = new JButton("Show all available Economy");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  textArea.setText("");
				  Economy [] a=carRental.searchAvailableEconomy();
				  if(a!=null) {
				  for(int i=0;i<a.length;i++) {
			   	  if(a[i]!=null)
				  textArea.append(a[i].toString()+"\n---------------------------\n");}}}
		});		
		button_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		button_1.setBounds(31, 91, 278, 33);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 136, 278, 269);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(143, 136, 15, 96);
		panel.add(scrollBar);
		
		JLabel lblNewLabel_1 = new JLabel("CAR RENTAL SYSTEM");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 34));
		lblNewLabel_1.setBounds(411, 10, 355, 51);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		panel_3.setBounds(767, 346, 344, 282);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_8 = new JLabel("Plate No :");
		label_8.setBounds(34, 55, 68, 20);
		label_8.setToolTipText("");
		label_8.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		panel_3.add(label_8);
		
		label_1_1 = new JLabel(" No. of days :");
		label_1_1.setToolTipText("");
		label_1_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_1_1.setBounds(32, 73, 97, 45);
		panel_3.add(label_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(98, 56, 97, 17);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(113, 86, 97, 17);
		panel_3.add(textField_7);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBackground(new Color(192, 192, 192));
		panel_2_1.setBounds(77, 116, 197, 116);
		panel_3.add(panel_2_1);
		
		JLabel label_4_1 = new JLabel("Customer info :");
		label_4_1.setToolTipText("");
		label_4_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 16));
		label_4_1.setBounds(16, 13, 98, 26);
		panel_2_1.add(label_4_1);
		
		JLabel label_5_1 = new JLabel("ID :");
		label_5_1.setToolTipText("");
		label_5_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_5_1.setBounds(16, 51, 38, 17);
		panel_2_1.add(label_5_1);
		
		JLabel label_6_1 = new JLabel("Name :");
		label_6_1.setToolTipText("");
		label_6_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		label_6_1.setBounds(16, 59, 54, 34);
		panel_2_1.add(label_6_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(66, 50, 120, 17);
		panel_2_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(66, 67, 120, 17);
		panel_2_1.add(textField_9);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(66, 84, 120, 17);
		panel_2_1.add(textField_11);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setToolTipText("");
		lblPhone.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		lblPhone.setBounds(16, 80, 71, 26);
		panel_2_1.add(lblPhone);
		
		JLabel lblRentalCar = new JLabel("Rental Car");
		lblRentalCar.setToolTipText("");
		lblRentalCar.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 25));
		lblRentalCar.setBounds(122, 0, 189, 45);
		panel_3.add(lblRentalCar);
		
		JButton btnRent = new JButton("Rent");
		btnRent.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
				int id = 0;
				int days = 0;				
				if (!isFilled(textField_6, "Plate No")) {
		            return; }
				String plateNo = textField_6.getText();
				
		        if (!isFilled(textField_7, "Days")) {
		            return; }
		        try {
                    days  = Integer.parseInt(textField_7.getText());
					}catch(  NumberFormatException error ) {
				    JOptionPane.showMessageDialog(null, "Enter Right Day -Digit only- ","Error",JOptionPane.ERROR_MESSAGE); 
				    textField_7.setText("");
				    return; }
		        
		        if (!isFilled(textField_8, "ID")) {
		            return; }
		        try {
				    id = Integer.parseInt(textField_8.getText());}
					catch(  NumberFormatException error ) {
					JOptionPane.showMessageDialog(null, "Enter Right ID -Digit only- ","Error", JOptionPane.ERROR_MESSAGE);
					textField_8.setText("");
					return; }
		        
		        if (!isFilled(textField_9, "Name")) {
		            return; }
		        String name = textField_9.getText();

		        if (!isFilled( textField_11, "Phone")) {
		            return; }
			    long phone = 0;
			    String sPhone = textField_11.getText();
			    try {
			    	if( sPhone.length() != 10 )
				    	throw new IllegalArgumentException();
			    	    phone = Long.parseLong(sPhone);			         
			    }catch( NumberFormatException error ) {
					JOptionPane.showMessageDialog(null, "Enter Right phone -Digit only-","Error", JOptionPane.ERROR_MESSAGE);
					textField_8.setText("");
					return; 
			    }catch( IllegalArgumentException error ) {
			    	JOptionPane.showMessageDialog(null, "Phone must be 10 Digits","Error", JOptionPane.ERROR_MESSAGE);
			    	textField_11.setText("");
			    	return; }			    
			    Customer c = new Customer(id,name,phone);  
			    String rentBill = carRental.rentCar(plateNo,c,days);
			    
			    if( rentBill == null )				
				    JOptionPane.showMessageDialog(null, "The car was not rent successfully !!","Rent Car",JOptionPane.WARNING_MESSAGE);
			    else   
					JOptionPane.showMessageDialog(null, rentBill,"Rent Car",JOptionPane.INFORMATION_MESSAGE);
		            textField_6.setText("");
		            textField_7.setText("");
		            textField_8.setText("");
		            textField_9.setText("");
		            textField_11.setText(""); }
		});
		btnRent.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		btnRent.setBounds(134, 244, 82, 32);
		panel_3.add(btnRent);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 245, 245));
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		panel_4.setBounds(767, 640, 344, 138);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_8_1 = new JLabel("Plate No :");
		label_8_1.setBounds(41, 63, 68, 20);
		label_8_1.setToolTipText("");
		label_8_1.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		panel_4.add(label_8_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(110, 64, 97, 17);
		panel_4.add(textField_10);

		JButton btnReturnCar = new JButton("Return Car");
		btnReturnCar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			 String plateNo=	textField_10.getText();
			 if (!isFilled(textField_10, "Plate No.")) {
		            return; }	      
			 if(carRental.returnCar(plateNo)) {
		            JOptionPane.showMessageDialog(null, "The car was returned successfully ..","Return Car",JOptionPane.INFORMATION_MESSAGE);
			}else {
		            JOptionPane.showMessageDialog(null, "The car was not returned successfully ..","Return Car",JOptionPane.WARNING_MESSAGE);}
			        textField_10.setText(""); }
		});
		btnReturnCar.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		btnReturnCar.setBounds(120, 100, 111, 32);
		panel_4.add(btnReturnCar);
		
		JLabel lblReturnCar = new JLabel("Return Car");
		lblReturnCar.setBounds(119, 6, 129, 33);
		panel_4.add(lblReturnCar);
		lblReturnCar.setToolTipText("");
		lblReturnCar.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 25));
		rdbtnNewRadioButton.setSelected(true);
		
		radioButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(radioButton.isSelected()) {
					rdbtnNewRadioButton.setSelected(false); }
		       {textField.setEditable(true);
				textField_2.setEditable(true);
				textField.setEnabled(true);
				textField_2.setEnabled(true);
				label_4.setEnabled(true);
				label_5.setEnabled(true);
				label_6.setEnabled(true);}}		
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()) {
				radioButton.setSelected(false); }
				label_4.setEnabled(false);
				label_5.setEnabled(false);
				label_6.setEnabled(false);
				textField_2.setEnabled(false);
				textField.setEnabled(false);
				textField.setEditable(false);
				textField_2.setEditable(false); }
		});
		rdbtnNewRadioButton.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(101, 227, 97, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		radioButton.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD, 15));
		radioButton.setBounds(190, 227, 80, 23);
		panel_1.add(radioButton);
		 
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setBounds(-11, 73, 11407, 250);
	    contentPane.add(lblNewLabel_2);
	    lblNewLabel_2.setIcon(new ImageIcon("image/car1.png"));}
	
	    //-----------------------------
	
	    // This method show if the field is empty or not 
	    public boolean isFilled( JTextField field, String fieldName) {
        if ( !field.getText().trim().equals("")) 
        	 return true;
        
        JOptionPane.showMessageDialog( this, fieldName + " field is empty !! ", "Error",JOptionPane.ERROR_MESSAGE);
        field.requestFocus();
        return false; }
	    
 }//end CarsJFrame