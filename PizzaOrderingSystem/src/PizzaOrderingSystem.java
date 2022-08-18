import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class PizzaOrderingSystem extends JFrame {

	private Image img_pizza1 = new ImageIcon(PizzaOrderingSystem.class.getResource("Pizza/pizza-1.jpeg")).getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH);
	private Image img_pizza2 = new ImageIcon(PizzaOrderingSystem.class.getResource("Pizza/pizza-2.png")).getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH);
	private Image img_pizza3 = new ImageIcon(PizzaOrderingSystem.class.getResource("Pizza/pizza-3.jpeg")).getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JComboBox cboFlavor;
	private JRadioButton rdoSmall;
	private JRadioButton rdoMedium;
	private JRadioButton rdoLarge;
	private JCheckBox chkExtraCheese;
	private JCheckBox chkExtraMeat;
	private JCheckBox chkMushroom;
	private JCheckBox chkBlackOlives;
	private JCheckBox chkOnions;
	private JCheckBox chkSausage;
	private JRadioButton rdoDineIn;
	private JRadioButton rdoTakeOut;
	private JRadioButton rdoDelivery;
	private JButton btnBillOut;
	private JButton btnOrderAgain;
	private JTextArea txaOrderDetails;
	private String[] flavor = {"Pepperoni", "BBQ Chicken", "Hawaiian", "Vegetarian", "Bacon and Cheese"};
	private JLabel lblSmallPrice;
	private JLabel lblMediumPrice;
	private JLabel lblLargePrice;
	private double addOnPrice = 0.00;
	private JLabel lblQuantity;
	private int qty = 1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaOrderingSystem frame = new PizzaOrderingSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PizzaOrderingSystem() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				loadFlavors();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 496);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza Flavor:");
		lblNewLabel.setBounds(6, 6, 199, 16);
		contentPane.add(lblNewLabel);
		
		cboFlavor = new JComboBox();
		cboFlavor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrice();
			}
		});
		cboFlavor.setBounds(16, 24, 262, 27);
		contentPane.add(cboFlavor);
		
		JLabel lblNewLabel_1 = new JLabel("Size and Price:");
		lblNewLabel_1.setBounds(6, 63, 199, 16);
		contentPane.add(lblNewLabel_1);
		
		rdoSmall = new JRadioButton("Small");
		buttonGroup.add(rdoSmall);
		rdoSmall.setBounds(16, 79, 141, 23);
		contentPane.add(rdoSmall);
		
		rdoMedium = new JRadioButton("Medium");
		buttonGroup.add(rdoMedium);
		rdoMedium.setBounds(16, 101, 141, 23);
		contentPane.add(rdoMedium);
		
		rdoLarge = new JRadioButton("Large");
		buttonGroup.add(rdoLarge);
		rdoLarge.setBounds(16, 125, 141, 23);
		contentPane.add(rdoLarge);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add Ons:");
		lblNewLabel_1_1.setBounds(6, 160, 199, 16);
		contentPane.add(lblNewLabel_1_1);
		
		chkExtraCheese = new JCheckBox("Extra Cheese");
		chkExtraCheese.setBounds(6, 176, 128, 23);
		contentPane.add(chkExtraCheese);
		
		chkExtraMeat = new JCheckBox("Extra Meat");
		chkExtraMeat.setBounds(6, 200, 128, 23);
		contentPane.add(chkExtraMeat);
		
		chkMushroom = new JCheckBox("Mushroom");
		chkMushroom.setBounds(6, 224, 128, 23);
		contentPane.add(chkMushroom);
		
		chkSausage = new JCheckBox("Sausage");
		chkSausage.setBounds(150, 224, 128, 23);
		contentPane.add(chkSausage);
		
		chkOnions = new JCheckBox("Onions");
		chkOnions.setBounds(150, 200, 128, 23);
		contentPane.add(chkOnions);
		
		chkBlackOlives = new JCheckBox("Black Olives");
		chkBlackOlives.setBounds(150, 176, 128, 23);
		contentPane.add(chkBlackOlives);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Choose:");
		lblNewLabel_1_1_1.setBounds(6, 259, 199, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		rdoDelivery = new JRadioButton("Delivery");
		buttonGroup_1.add(rdoDelivery);
		rdoDelivery.setBounds(16, 322, 141, 23);
		contentPane.add(rdoDelivery);
		
		rdoTakeOut = new JRadioButton("Take Out");
		buttonGroup_1.add(rdoTakeOut);
		rdoTakeOut.setBounds(16, 298, 141, 23);
		contentPane.add(rdoTakeOut);
		
		rdoDineIn = new JRadioButton("Dine In");
		buttonGroup_1.add(rdoDineIn);
		rdoDineIn.setBounds(16, 276, 141, 23);
		contentPane.add(rdoDineIn);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1_1.setBounds(6, 353, 199, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty--;
				lblQuantity.setText(String.valueOf(qty));
			}
		});
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton.setBounds(16, 368, 72, 33);
		contentPane.add(btnNewButton);
		
		lblQuantity = new JLabel("1");
		lblQuantity.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(100, 377, 60, 16);
		contentPane.add(lblQuantity);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty++;
				lblQuantity.setText(String.valueOf(qty));
			}
		});
		btnNewButton_2.setBackground(new Color(173, 255, 47));
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton_2.setBounds(171, 368, 72, 33);
		contentPane.add(btnNewButton_2);
		
		btnBillOut = new JButton("Bill Out");
		btnBillOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrderDetails();
			}
		});
		btnBillOut.setBounds(64, 402, 117, 29);
		contentPane.add(btnBillOut);
		
		btnOrderAgain = new JButton("Order Again ");
		btnOrderAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderAgain();
			}
		});
		btnOrderAgain.setBounds(64, 431, 117, 29);
		contentPane.add(btnOrderAgain);
		
		JLabel lblPizza1 = new JLabel("");
		lblPizza1.setIcon(new ImageIcon(img_pizza1));
		lblPizza1.setBounds(290, 6, 117, 73);
		contentPane.add(lblPizza1);
		
		JLabel lblPizza2 = new JLabel("");
		lblPizza2.setIcon(new ImageIcon(img_pizza2));
		lblPizza2.setBounds(419, 6, 117, 73);
		contentPane.add(lblPizza2);
		
		JLabel lblPizza3 = new JLabel("");
		lblPizza3.setIcon(new ImageIcon(img_pizza3));
		lblPizza3.setBounds(548, 6, 117, 73);
		contentPane.add(lblPizza3);
		
		JLabel lblNewLabel_3 = new JLabel("Other Details:");
		lblNewLabel_3.setBounds(290, 105, 199, 16);
		contentPane.add(lblNewLabel_3);
		
		txaOrderDetails = new JTextArea();
		txaOrderDetails.setBounds(290, 133, 375, 316);
		contentPane.add(txaOrderDetails);
		
		lblSmallPrice = new JLabel("");
		lblSmallPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmallPrice.setBounds(150, 83, 128, 16);
		contentPane.add(lblSmallPrice);
		
		lblMediumPrice = new JLabel("");
		lblMediumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMediumPrice.setBounds(150, 105, 128, 16);
		contentPane.add(lblMediumPrice);
		
		lblLargePrice = new JLabel("");
		lblLargePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblLargePrice.setBounds(150, 129, 128, 16);
		contentPane.add(lblLargePrice);
	}
	
	private void loadFlavors()
	{
		for(String flavors : flavor)
		{
			cboFlavor.addItem(flavors);
		}
	}
	
	private void showPrice()
	{
		if(cboFlavor.getSelectedIndex() == 0)
		{
			lblSmallPrice.setText("100.00");
			lblMediumPrice.setText("120.00");
			lblLargePrice.setText("140.00");
		}
		else if(cboFlavor.getSelectedIndex() == 1)
		{
			lblSmallPrice.setText("130.00");
			lblMediumPrice.setText("150.00");
			lblLargePrice.setText("170.00");
		}
		else if(cboFlavor.getSelectedIndex() == 2)
		{
			lblSmallPrice.setText("90.00");
			lblMediumPrice.setText("110.00");
			lblLargePrice.setText("140.00");
		}
		else if(cboFlavor.getSelectedIndex() == 3)
		{
			lblSmallPrice.setText("110.00");
			lblMediumPrice.setText("130.00");
			lblLargePrice.setText("150.00");
		}
		else 
		{
			lblSmallPrice.setText("120.00");
			lblMediumPrice.setText("140.00");
			lblLargePrice.setText("160.00");
		}
	}
	
	private String addOnPrice()
	{
		String addOns = "";
		
		if(chkExtraCheese.isSelected()) 
		{
			addOnPrice += 10.00;
			addOns += "\n\t" + chkExtraCheese.getText() + "\t\t" + "10.00";
		}
		if(chkExtraMeat.isSelected()) 
		{
			addOnPrice += 15.00;
			addOns += "\n\t" + chkExtraMeat.getText() + "\t\t" + "15.00";
		}
		if(chkMushroom.isSelected()) 
		{
			addOnPrice += 7.00;
			addOns += "\n\t" + chkMushroom.getText() + "\t\t" + "7.00";
		}
		if(chkBlackOlives.isSelected()) 
		{
			addOnPrice += 8.00;
			addOns += "\n\t" + chkBlackOlives.getText() + "\t\t" + "8.00";
		}
		if(chkOnions.isSelected()) 
		{
			addOnPrice += 5.00;
			addOns += "\n\t" + chkOnions.getText() + "\t\t" + "5.00";
		}
		if(chkSausage.isSelected()) 
		{
			addOnPrice += 10.00;
			addOns += "\n\t" + chkSausage.getText() + "\t\t" + "10.00";
		}
		
		return addOns;
	}
	
	private String sizeOfPizza()
	{
		String size = "";
		if(rdoSmall.isSelected())
			size = rdoSmall.getText();
		else if(rdoMedium.isSelected())
			size = rdoMedium.getText();
		else if(rdoLarge.isSelected())
			size = rdoLarge.getText();
		
		return size;
	}
	
	private double priceOfPizza()
	{
		double pizzaPrice = 0;
		if(rdoSmall.isSelected())
			pizzaPrice = Double.parseDouble(lblSmallPrice.getText());
		else if(rdoMedium.isSelected())
			pizzaPrice = Double.parseDouble(lblMediumPrice.getText());
		else if(rdoLarge.isSelected())
			pizzaPrice = Double.parseDouble(lblLargePrice.getText());
		
		return pizzaPrice;
	}
	
	private String serviceMethod()
	{
		String service = "";
		if(rdoDineIn.isSelected())
			service = "DINE IN";
		else if(rdoTakeOut.isSelected())
			service = "TAKE OUT";
		else if(rdoDelivery.isSelected())
			service = "FOR DELIVERY\t\t50.00";
		
		return service;
	}
	
	private double serviceFee()
	{
		double fee = 0.00;
		if(rdoDineIn.isSelected())
			fee = 0.00;
		else if(rdoTakeOut.isSelected())
			fee = 0.0;
		else if(rdoDelivery.isSelected())
			fee = 50.00;
		
		return fee;
	}
	
	private double subtotal()
	{
		addOnPrice = 0;
		addOnPrice();
		double subtotal = 0.00;
		subtotal = addOnPrice + priceOfPizza() + serviceFee();
		
		return subtotal;
	}
	
	private void orderAgain()
	{
		txaOrderDetails.setText(null);
	}
	private void showOrderDetails()
	{
		double totalPrice = 0;
		int quantity = Integer.parseInt(lblQuantity.getText());
		totalPrice = subtotal() * quantity;
		txaOrderDetails.setText("\nFLAVOR: \t" + cboFlavor.getSelectedItem() + "\n\nSIZE: \t" + sizeOfPizza() + "\n\nPRICE: \t" + priceOfPizza()
								+ "\n\nADD ONS: \t" + addOnPrice() + "\n\nSERVICE: \t" + serviceMethod() + "\n\nQuantity: \tx" + quantity
								+ "\n\n*******************************************************************"
								+ "\n\nTOTAL PRICE: \t" + totalPrice);
	}
	

	
}
