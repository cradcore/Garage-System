import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {

	private JFrame frmParkingGarageGui;
	private JTextField textField;
	private ArrayList<JLabel> jlabels;
	private JComboBox<String> comboBox;
	private JButton button;
	private Garage garage;
	private boolean clickable;
	private Ticket t;
	private JLabel Home;
	private JPanel mainJP;
	private GridBagConstraints gbcHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmParkingGarageGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		jlabels = new ArrayList<JLabel>();
		garage = new Garage(50);
		clickable = false;
		initialize();
		welcome();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmParkingGarageGui = new JFrame();
		frmParkingGarageGui.setTitle("Parking Garage GUI");
		frmParkingGarageGui.setBounds(100, 100, 1001, 581);
		frmParkingGarageGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 309, 190, 106, 289};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmParkingGarageGui.getContentPane().setLayout(gridBagLayout);
		mainJP = (JPanel) frmParkingGarageGui.getContentPane();

		Home = new JLabel();
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				resetLabels();
				for(int i = 0; i < button.getActionListeners().length; i++)
					button.removeActionListener(button.getActionListeners()[i]);
				if(!mainJP.isVisible()) {
					mainJP.setVisible(true);
					frmParkingGarageGui.setContentPane(mainJP);
				}
				welcome();
			}
		});
		Home.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/Icons/home-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		gbcHome = new GridBagConstraints();
		gbcHome.insets = new Insets(0, 0, 5, 5);
		gbcHome.gridx = 0;
		gbcHome.gridy = 0;
		frmParkingGarageGui.getContentPane().add(Home, gbcHome);

		JLabel label1 = new JLabel("label1");
		label1.setFont(new Font("Lato", Font.BOLD, 22));
		GridBagConstraints gbcLabel1 = new GridBagConstraints();
		gbcLabel1.insets = new Insets(0, 0, 5, 0);
		gbcLabel1.gridx = 0;
		gbcLabel1.gridy = 1;
		gbcLabel1.gridwidth = 5;
		frmParkingGarageGui.getContentPane().add(label1, gbcLabel1);
		jlabels.add(label1);

		JLabel label2 = new JLabel("label2");
		label2.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel2 = new GridBagConstraints();
		gbcLabel2.insets = new Insets(0, 0, 5, 0);
		gbcLabel2.gridx = 0;
		gbcLabel2.gridy = 2;
		gbcLabel2.gridwidth = 5;
		frmParkingGarageGui.getContentPane().add(label2, gbcLabel2);
		jlabels.add(label2);

		JLabel label3 = new JLabel("label3");
		label3.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel3 = new GridBagConstraints();
		gbcLabel3.insets = new Insets(0, 0, 5, 0);
		gbcLabel3.gridx = 0;
		gbcLabel3.gridy = 3;
		gbcLabel3.gridwidth = 5;
		frmParkingGarageGui.getContentPane().add(label3, gbcLabel3);
		jlabels.add(label3);

		JLabel label4 = new JLabel("label4");
		label4.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel4 = new GridBagConstraints();
		gbcLabel4.insets = new Insets(0, 0, 5, 0);
		gbcLabel4.gridx = 0;
		gbcLabel4.gridy = 4;
		gbcLabel4.gridwidth = 5;
		frmParkingGarageGui.getContentPane().add(label4, gbcLabel4);
		jlabels.add(label4);

		JLabel label5 = new JLabel("label5");
		label5.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel5 = new GridBagConstraints();
		gbcLabel5.insets = new Insets(0, 0, 5, 0);
		gbcLabel5.gridx = 0;
		gbcLabel5.gridy = 5;
		gbcLabel5.gridwidth = 5;
		label5.setVisible(false);
		frmParkingGarageGui.getContentPane().add(label5, gbcLabel5);
		jlabels.add(label5);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String option = comboBox.getSelectedItem().toString();
				if(option.equals("Enter garage"))
					enterGarage();
				else if(option.equals("Exit garage")) 
					exitGarage();
				else if(option.equals("Admin console")) 
					adminConsole();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"(Select an option)", "Enter garage", "Exit garage", "Admin console"}));
		comboBox.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 6;
		frmParkingGarageGui.getContentPane().add(comboBox, gbc_comboBox);

		textField = new JTextField();
		textField.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 7;
		textField.setVisible(false);
		frmParkingGarageGui.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		button = new JButton("button");
		button.setFont(new Font("Lato", Font.PLAIN, 18));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		button.setVisible(false);
		frmParkingGarageGui.getContentPane().add(button, gbc_btnNewButton);

		JLabel label6 = new JLabel("label6");
		label6.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel6 = new GridBagConstraints();
		gbcLabel6.gridx = 0;
		gbcLabel6.gridy = 9;
		gbcLabel6.gridwidth = 5;
		label6.setVisible(false);
		frmParkingGarageGui.getContentPane().add(label6, gbcLabel6);
		jlabels.add(label6);
	}

	private void welcome() {	
		// Set text and icons
		resetLabels();
		jlabels.get(0).setText("Welcome to the parking garage!");
		jlabels.get(1).setIcon(new ImageIcon(GUI.class.getResource("/Icons/garage-icon.png")));
		jlabels.get(2).setText("Garage availability: " + garage.getTicketDatabase().getNumOpenTickets() + " out of " + garage.getCapacity() + " spots");
		if(garage.getTicketDatabase().getNumOpenTickets() >= garage.getCapacity())
			jlabels.get(3).setText("Garage is currently full.");
		else jlabels.get(3).setText("Garage has " + (garage.getCapacity() - garage.getTicketDatabase().getNumOpenTickets()) + " spots available!");
		jlabels.get(4).setText("<html><br>To begin, select an option below<br><br></html>");
		comboBox.setSelectedIndex(0);
		jlabels.get(5).setText(String.format("Ticket price per hour: $%." + 2 + "f", garage.getPrice()));

		// Set visible statuses
		for(int i = 0; i < 6; i++)
			jlabels.get(i).setVisible(true);
		comboBox.setVisible(true);
		textField.setVisible(false);
		button.setVisible(false);
		Home.setVisible(false);
	}

	private void enterGarage() {

		// Set text and icons
		resetLabels();
		jlabels.get(0).setText("You are entering the garage");
		jlabels.get(1).setText("Please \"grab\" your ticket below by clicking the ticket");
		jlabels.get(2).setIcon(new ImageIcon(GUI.class.getResource("/Icons/ticket-icon.png")));
		t = garage.getTicketDatabase().createTicket();
		jlabels.get(3).setText("Ticket #" + t.toString().substring(4, 10));
		jlabels.get(4).setText("Do not lose this ticket # or you will not be able to leave the garage!");
		// Set visible statuses
		for(int i = 5; i < jlabels.size(); i++) 
			jlabels.get(i).setVisible(false);
		comboBox.setVisible(false);
		button.setVisible(false);
		Home.setVisible(false);

		// Open gate
		clickable = true;
		
		jlabels.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(clickable)
					operateGate("enter", null);
			}
		});

	}

	private void operateGate(String type, String change) {
		resetLabels();
		if(type.equals("enter")) {
			// Set text and icons
			jlabels.get(0).setText("Gate opening...");
			jlabels.get(1).setText("[Start time]: " + t.getStartTimeToString());
			jlabels.get(2).setText("Gate is opened. Closing in 5 seconds");
			jlabels.get(3).setIcon(new ImageIcon(GUI.class.getResource("/Icons/lb.gif")));
			
			// Set visible statuses
			textField.setVisible(false);
			button.setVisible(false);
			for(int i = 0; i < 4; i++)
				jlabels.get(i).setVisible(true);
			for(int i = 4; i < jlabels.size(); i++)
				jlabels.get(i).setVisible(false);
			
			// Run timer
			Timer t1 = new Timer(5000, null);
			t1.setRepeats(false);
			t1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jlabels.get(3).setIcon(new ImageIcon(GUI.class.getResource("/Icons/lb6.png")));
				}
			});
			t1.restart();
			Timer t2 = new Timer(6500, null);
			t2.setRepeats(false);
			t2.restart();
			t2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					welcome();
				}
			});
		}
		else {
			// Set text and icons
			jlabels.get(0).setText("Gate opening...");
			jlabels.get(1).setText("Thanks for visiting, have a great day!");
			jlabels.get(2).setText("Gate is opened. Closing in 5 seconds");
			jlabels.get(3).setIcon(new ImageIcon(GUI.class.getResource("/Icons/lb.gif")));
			jlabels.get(4).setText(change);
			jlabels.get(5).setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/Icons/bye.gif")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
			jlabels.get(5).setText(null);
			
			// Set visibility statuses
			for(int i = 0; i < 5; i++)
				jlabels.get(i).setVisible(true);
			textField.setVisible(false);
			button.setVisible(false);
			Home.setVisible(false);
			
			// Timer
			Timer t1 = new Timer(5000, null);
			t1.setRepeats(false);
			t1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jlabels.get(3).setIcon(new ImageIcon(GUI.class.getResource("/Icons/lb6.png")));
				}
			});
			t1.restart();
			Timer t2 = new Timer(6500, null);
			t2.setRepeats(false);
			t2.restart();
			t2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					welcome();
				}
			});
		}
		clickable = false;
	}

	private void exitGarage() {
		resetLabels();
		Home.setVisible(true);
		// Set text and icons
		jlabels.get(0).setText("Exiting garage");
		jlabels.get(1).setIcon(new ImageIcon(GUI.class.getResource("/Icons/exit-icon.png")));
		jlabels.get(2).setText("Thank you for visiting!");
		jlabels.get(3).setText("Please enter your 6-digit ticket number below");

		// Set visible statuses
		for(int i = 0; i < 4; i++)
			jlabels.get(i).setVisible(true);
		for(int i = 4; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(false);
		textField.setVisible(true);
		comboBox.setVisible(false);

		// Get ticket #
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(textField.getText().length() == 6) {
					if(garage.getTicketDatabase().isTicketOpen(textField.getText()))
						textFieldRmKL(this);
					exitInfo(textField.getText());
				}
				else if(textField.getText().length() < 6) {
					jlabels.get(5).setText(null);
				}
			}
		});

	}

	private void textFieldRmKL(KeyAdapter kl) {
		textField.removeKeyListener(kl);
	}

	private void exitInfo(String id) {
		if(garage.getTicketDatabase().isTicketOpen(id)) {
			resetLabels();
			Home.setVisible(false);

			// Update text
			Ticket t = garage.getTicketDatabase().getTicket(id);
			t.closeTicketCalculateCost(garage.getPrice());
			jlabels.get(0).setText("Exiting garage");
			jlabels.get(1).setText("<html><center>[Start time]: " + t.getStartTimeToString() + "<br>[End time]: " + t.getEndTimeToString() + "<br><br></center></html>");
			jlabels.get(2).setText(String.format("Total time stayed: %." + 0 + "f hours, %." + 0 + "f minutes", Math.floor(t.timeStayed() / 60.0), t.timeStayed() % 60));
			jlabels.get(3).setText(String.format("Total amount owed: $%." + 2 + "f", t.getPrice()));
			jlabels.get(4).setText(" ");
			textField.setText(null);
			jlabels.get(5).setText("Please enter how much money you are putting in above");
			button.setText("Go");
			ActionListener bAL = new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkMoneyData()) {
						double amountPayed = Double.parseDouble(textField.getText());
						if(amountPayed >= t.getPrice()) {
							jlabels.get(5).setText(String.format("Total change: $%." + 2 + "f", amountPayed - t.getPrice()));
							textField.setVisible(false);
							button.setVisible(false);
							garage.getTicketDatabase().updateDatabase();
							operateGate("exit", jlabels.get(5).getText());
							buttonRmAL(this);
						}
						else jlabels.get(5).setText(String.format("Please enter at least $%." + 2 + "f. Please try again", t.getPrice()));

					}
					else {
						jlabels.get(5).setText("Please enter a valid amount (e.g. 4.00)");
					}
				}
			};

			button.addActionListener(bAL);

			// Set visible statuses
			for(int i = 0; i < jlabels.size(); i++)
				jlabels.get(i).setVisible(true);
			textField.setVisible(true);
			button.setVisible(true);
		}
		else {
			jlabels.get(5).setText("Invalid ticket #. Please try again");
			jlabels.get(5).setVisible(true);
		}
	}
	
	private void buttonRmAL(ActionListener al) {
		button.removeActionListener(al);
	}

	private boolean checkMoneyData() {
		for(int i = 0; i < textField.getText().length(); i++) {
			if (!(Character.isDigit(textField.getText().charAt(i)) || textField.getText().charAt(i) == '.'))
				return false;
		}
		if(textField.getText().length() == 0)
			return false;

		return true;
	}

	private void adminConsole() {
		resetLabels();
		// Set text and icons
		jlabels.get(0).setText("Admin console");
		jlabels.get(1).setText("Please enter the password to login");
		jlabels.get(2).setText("(For sake of assignment, it doesn't matter what password you enter here, just clock go)");
		button.setText("Go");

		// Set visible statuses
		for(int i = 0; i < 3; i++)
			jlabels.get(i).setVisible(true);
		for(int i = 3; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(false);
		textField.setVisible(true);
		button.setVisible(true);
		comboBox.setVisible(false);
		Home.setVisible(true);

		// Enter admin console
		ActionListener abAL = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminConsoleInfo();
				buttonRmAL(this);
			}
		};

		button.addActionListener(abAL);
	}

	private void adminConsoleInfo() {
		// Set text and icons
		jlabels.get(1).setText("<html><center>Please select an option below:<br><br></center></html>");
		jlabels.get(2).setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/Icons/settings-icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		jlabels.get(2).setText("     (Change settings)");
		jlabels.get(3).setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/Icons/reports-icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		jlabels.get(3).setText("         (View reports)");


		// Set visible statuses
		for(int i = 0; i < 4; i++) 
			jlabels.get(i).setVisible(true);
		for(int i = 4; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(false);
		textField.setVisible(false);
		button.setVisible(false);
		comboBox.setVisible(false);
		Home.setVisible(true);

		// Add action listeners
		MouseAdapter settingsMA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				settingsScreen();
				rmML(this);
			}
		};
		jlabels.get(2).addMouseListener(settingsMA);

		MouseAdapter reportsMA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				reportsScreen();
				rmML(this);
			}
		};
		jlabels.get(3).addMouseListener(reportsMA);
	}

	private void rmML(MouseAdapter ml) {
		jlabels.get(2).removeMouseListener(ml);
		jlabels.get(3).removeMouseListener(ml);
	}

	private void settingsScreen() {
		// Set text and icons
		jlabels.get(0).setText("Settings");
		jlabels.get(1).setText("<html><center>Please select the setting you would like to change below:<br><br></center></html>");
		jlabels.get(2).setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/Icons/price-icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		jlabels.get(2).setText("    (Change price per hour)                   ");
		jlabels.get(3).setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/Icons/parking-icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		jlabels.get(3).setText("    (Change number of spots available)");

		// Set visible statuses
		for(int i = 0; i < 4; i++) 
			jlabels.get(i).setVisible(true);
		for(int i = 4; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(false);
		textField.setVisible(false);
		button.setVisible(false);
		comboBox.setVisible(false);
		Home.setVisible(true);

		// Add action listeners
		MouseAdapter priceMA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jlabels.get(4).setText("<html><center>Please enter the price per hour to change to:<br></center></html>");
				jlabels.get(4).setVisible(true);
				jlabels.get(3).setVisible(false);
				textField.setText(null);
				textField.setVisible(true);
				button.setVisible(true);
				rmML(this);
			}
		};
		jlabels.get(2).addMouseListener(priceMA);

		MouseAdapter spotsMA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jlabels.get(4).setText("<html><center>Please enter the number of spots available:<br></center></html>");
				jlabels.get(4).setVisible(true);
				jlabels.get(2).setVisible(false);
				textField.setText(null);
				textField.setVisible(true);
				button.setVisible(true);
				rmML(this);
			}
		};
		jlabels.get(3).addMouseListener(spotsMA);

		ActionListener sAL = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Changing price
				if(jlabels.get(2).isVisible()) {
					// If price is not valid
					if(textField.getText().length() == 0) {
						jlabels.get(5).setText("Price cannot be blank. Please try again");
						jlabels.get(5).setVisible(true);
						textField.setText(null);
						return;
					}
					for(int i = 0; i < textField.getText().length(); i++) {
						if(!(Character.isDigit(textField.getText().charAt(i)) || textField.getText().charAt(i) == '.')) {
							jlabels.get(5).setText("Price not valid. Please try again");
							jlabels.get(5).setVisible(true);
							textField.setText(null);
							return;
						}
					}
					// Price is valid
					garage.updatePrice(Double.parseDouble(textField.getText()));
					jlabels.get(5).setText("Price updated!");
					jlabels.get(5).setVisible(true);
					Timer t = new Timer(2000, null);
					// Show price change confirmation page for 2 seconds, and then go back
					t.setRepeats(false);
					t.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							settingsScreen();
							t.removeActionListener(this);
						}
					});
					t.restart();
					buttonRmAL(this);
					
					
				}
				// Changing spots
				else if (jlabels.get(3).isVisible()) {
					// If number of spots is valid
					if(textField.getText().length() == 0) {
						jlabels.get(5).setText("Number of spots can not be blank");
						jlabels.get(5).setVisible(true);
						textField.setText(null);
						return;
						
					}
					for(int i = 0; i < textField.getText().length(); i++) {
						if(!Character.isDigit(textField.getText().charAt(i))) {
							jlabels.get(5).setText("Please enter a valid number");
							jlabels.get(5).setVisible(true);
							textField.setText(null);
							return;
						}
					}
					
					// Number is valid
					garage.updateSpots(Integer.parseInt(textField.getText()));
					jlabels.get(5).setText("Number of spots updated!");
					jlabels.get(5).setVisible(true);
					Timer t = new Timer(2000, null);
					// Show change confirmation page for 2 seconds, and then go back
					t.setRepeats(false);
					t.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							settingsScreen();
							t.removeActionListener(this);
						}
					});
					t.restart();
					buttonRmAL(this);
					
				}
				
				//settingsScreen();
			}
		};
		button.addActionListener(sAL);
	}

	private void reportsScreen() {
		resetLabels();
		
		// Set text and icons
		frmParkingGarageGui.getContentPane().setVisible(false);
		mainJP = (JPanel) frmParkingGarageGui.getContentPane();
		test reportScreen = new test(garage);
		frmParkingGarageGui.setContentPane(reportScreen.getPanel());
		frmParkingGarageGui.getContentPane().add(Home, gbcHome);
		
	}

	private void resetLabels() {
		for(int i = 0; i < jlabels.size(); i++) {
			jlabels.get(i).setText(null);
			jlabels.get(i).setIcon(null);
		}
		textField.setText(null);
	}

}
