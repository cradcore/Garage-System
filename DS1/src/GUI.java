

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private ArrayList<JLabel> jlabels;
	private JComboBox<String> comboBox;
	private JButton button;
	private Garage garage;
	private boolean clickable;
	private Ticket t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1001, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300, 300, 300};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel label1 = new JLabel("label1");
		label1.setFont(new Font("Lato", Font.BOLD, 22));
		GridBagConstraints gbcLabel1 = new GridBagConstraints();
		gbcLabel1.insets = new Insets(0, 0, 5, 0);
		gbcLabel1.gridx = 0;
		gbcLabel1.gridy = 0;
		gbcLabel1.gridwidth = 3;
		frame.getContentPane().add(label1, gbcLabel1);
		jlabels.add(label1);

		JLabel label2 = new JLabel("label2");
		label2.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel2 = new GridBagConstraints();
		gbcLabel2.insets = new Insets(0, 0, 5, 0);
		gbcLabel2.gridx = 0;
		gbcLabel2.gridy = 1;
		gbcLabel2.gridwidth = 3;
		frame.getContentPane().add(label2, gbcLabel2);
		jlabels.add(label2);

		JLabel label3 = new JLabel("label3");
		label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(clickable)
					operateGate("open");
			}
		});
		label3.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel3 = new GridBagConstraints();
		gbcLabel3.insets = new Insets(0, 0, 5, 0);
		gbcLabel3.gridx = 0;
		gbcLabel3.gridy = 2;
		gbcLabel3.gridwidth = 3;
		frame.getContentPane().add(label3, gbcLabel3);
		jlabels.add(label3);

		JLabel label4 = new JLabel("label4");
		label4.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel4 = new GridBagConstraints();
		gbcLabel4.insets = new Insets(0, 0, 5, 0);
		gbcLabel4.gridx = 0;
		gbcLabel4.gridy = 3;
		gbcLabel4.gridwidth = 3;
		frame.getContentPane().add(label4, gbcLabel4);
		jlabels.add(label4);

		JLabel label5 = new JLabel("label5");
		label5.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel5 = new GridBagConstraints();
		gbcLabel5.insets = new Insets(0, 0, 5, 0);
		gbcLabel5.gridx = 0;
		gbcLabel5.gridy = 4;
		gbcLabel5.gridwidth = 3;
		label5.setVisible(false);
		frame.getContentPane().add(label5, gbcLabel5);
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
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		frame.getContentPane().add(comboBox, gbc_comboBox);

		textField = new JTextField();
		textField.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		textField.setVisible(false);
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		button = new JButton("button");
		button.setFont(new Font("Lato", Font.PLAIN, 18));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		button.setVisible(false);
		frame.getContentPane().add(button, gbc_btnNewButton);

		JLabel label6 = new JLabel("label6");
		label6.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel6 = new GridBagConstraints();
		gbcLabel6.insets = new Insets(0, 0, 0, 5);
		gbcLabel6.gridx = 0;
		gbcLabel6.gridy = 8;
		gbcLabel6.gridwidth = 3;
		label6.setVisible(false);
		frame.getContentPane().add(label6, gbcLabel6);
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
		jlabels.get(4).setText("To begin, select an option below");
		comboBox.setSelectedIndex(0);
		jlabels.get(5).setText(String.format("Ticket price per hour: $%." + 2 + "f", garage.getPrice()));

		// Set visible statuses
		for(int i = 0; i < 6; i++)
			jlabels.get(i).setVisible(true);
		comboBox.setVisible(true);
		textField.setVisible(false);
		button.setVisible(false);
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

		// Open gate
		clickable = true;

	}

	private void operateGate(String type) {
		resetLabels();
		if(type.equals("open")) {
			// Set text and icons
			jlabels.get(0).setText("Gate opening...");
			jlabels.get(1).setText("Start time: " + t.getStartTimeToString());
			jlabels.get(2).setText("Gate is opened. Closing in 5 seconds");
			jlabels.get(3).setIcon(new ImageIcon(GUI.class.getResource("/Icons/lb.gif")));
			Timer t1 = new Timer(5000, null);
			t1.setRepeats(false);
			t1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jlabels.get(3).setIcon(new ImageIcon(GUI.class.getResource("/Icons/lb6.png")));
				}
			});
			t1.restart();
			//welcome();
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

		}
		clickable = false;
	}

	private void exitGarage() {
		resetLabels();
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
				if(textField.getText().length() == 6)
					exitInfo(textField.getText());
			}
		});

		
	}
	
	private void exitInfo(String id) {
		if(garage.getTicketDatabase().isTicketOpen(id)) {
			resetLabels();
			// Update text
			Ticket t = garage.getTicketDatabase().getTicket(id);
			jlabels.get(0).setText("Exiting garage");
			jlabels.get(1).setText("Start time: " + t.getStartTimeToString());
			jlabels.get(2).setText("End time: ");
			
			
			// Set visible statuses
			for(int i = 0; i < 3; i++)
				jlabels.get(i).setVisible(true);
			for(int i = 3; i < jlabels.size(); i++)
				jlabels.get(i).setVisible(false);
			textField.setVisible(false);
		}
		else {
			jlabels.get(5).setText("Invalid ticket #. Please try again");
			jlabels.get(5).setVisible(true);
		}
	}

	private void adminConsole() {
		resetLabels();

	}

	private void resetLabels() {
		for(int i = 0; i < jlabels.size(); i++) {
			jlabels.get(i).setText(null);
			jlabels.get(i).setIcon(null);
		}
	}

}
