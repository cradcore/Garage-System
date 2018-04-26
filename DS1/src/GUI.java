import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	private JFrame frame;
	private Garage garage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI(new Garage(50));
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
	public GUI(Garage garage) {
		initialize();
		this.garage = garage;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<JLabel> jlabels = new ArrayList<JLabel>();
		frame = new JFrame();
		frame.setBounds(100, 100, 1001, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{350, 350, 303, 0};
		gridBagLayout.rowHeights = new int[]{0, 64, 61, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel welcome1 = new JLabel("         Welcome to the parking garage!");
		welcome1.setFont(new Font("Lato", Font.BOLD, 24));
		welcome1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcWelcome1 = new GridBagConstraints();
		gbcWelcome1.insets = new Insets(0, 0, 5, 5);
		gbcWelcome1.gridx = 0;
		gbcWelcome1.gridy = 2;
		gbcWelcome1.gridwidth = 3;
		frame.getContentPane().add(welcome1, gbcWelcome1);
		jlabels.add(welcome1);
		
		JLabel welcome2 = new JLabel("");
		welcome2.setIcon(new ImageIcon(GUI.class.getResource("/Icons/garage-icon.png")));
		GridBagConstraints gbcWelcome2 = new GridBagConstraints();
		gbcWelcome2.insets = new Insets(0, 0, 5, 5);
		gbcWelcome2.gridx = 1;
		gbcWelcome2.gridy = 3;
		frame.getContentPane().add(welcome2, gbcWelcome2);
		jlabels.add(welcome2);
		
		JLabel welcome3 = new JLabel("To begin, select an option below:");
		welcome3.setHorizontalAlignment(SwingConstants.CENTER);
		welcome3.setFont(new Font("Lato", Font.PLAIN, 16));
		GridBagConstraints gbcWelcome3 = new GridBagConstraints();
		gbcWelcome3.insets = new Insets(0, 0, 5, 5);
		gbcWelcome3.gridx = 1;
		gbcWelcome3.gridy = 4;
		frame.getContentPane().add(welcome3, gbcWelcome3);
		jlabels.add(welcome3);
		
		JLabel enter0 = new JLabel("You are entering the garage");
		enter0.setFont(new Font("Lato", Font.BOLD, 20));
		GridBagConstraints gbcEnter0 = new GridBagConstraints();
		gbcEnter0.insets = new Insets(0, 0, 5, 5);
		gbcEnter0.gridx = 1;
		gbcEnter0.gridy = 7;
		frame.getContentPane().add(enter0, gbcEnter0);
		enter0.setVisible(false);
		jlabels.add(enter0);
		
		JLabel enter1 = new JLabel("Please click the ticket below");
		enter1.setHorizontalAlignment(SwingConstants.CENTER);
		enter1.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcEnter1 = new GridBagConstraints();
		gbcEnter1.insets = new Insets(0, 0, 5, 5);
		gbcEnter1.gridx = 1;
		gbcEnter1.gridy = 8;
		frame.getContentPane().add(enter1, gbcEnter1);
		enter1.setVisible(false);
		jlabels.add(enter1);
		
		JLabel enter2 = new JLabel("to receive your ticket");
		enter2.setFont(new Font("Lato", Font.PLAIN, 18));
		enter2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcEnter2 = new GridBagConstraints();
		gbcEnter2.insets = new Insets(0, 0, 5, 5);
		gbcEnter2.gridx = 1;
		gbcEnter2.gridy = 9;
		frame.getContentPane().add(enter2, gbcEnter2);
		enter2.setVisible(false);
		jlabels.add(enter2);
		
		JLabel enter3 = new JLabel("");
		enter3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openGate(jlabels);
			}
		});
		enter3.setIcon(new ImageIcon(GUI.class.getResource("/Icons/woo_icon_ticket.png")));
		GridBagConstraints gbcEnter3 = new GridBagConstraints();
		gbcEnter3.insets = new Insets(0, 0, 5, 5);
		gbcEnter3.gridx = 1;
		gbcEnter3.gridy = 13;
		frame.getContentPane().add(enter3, gbcEnter3);
		enter3.setVisible(false);
		jlabels.add(enter3);
		
		JLabel enter4 = new JLabel("TICKET NUMBER");
		enter4.setFont(new Font("Lato", Font.BOLD, 18));
		GridBagConstraints gbcEnter4 = new GridBagConstraints();
		gbcEnter4.insets = new Insets(0, 0, 5, 5);
		gbcEnter4.gridx = 1;
		gbcEnter4.gridy = 14;
		frame.getContentPane().add(enter4, gbcEnter4);
		enter4.setVisible(false);
		jlabels.add(enter4);


		JLabel enter5 = new JLabel("Do not lose this ticket #, otherwise you won't be able to leave the garage!");
		enter5.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcEnter5 = new GridBagConstraints();
		gbcEnter5.gridx = 0;
		gbcEnter5.gridy = 15;
		gbcEnter5.gridwidth = 3;
		frame.getContentPane().add(enter5, gbcEnter5);
		enter5.setVisible(false);
		jlabels.add(enter5);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex() == 1) {
					comboBox.setVisible(false);
					enterGarage(jlabels);
				}
				else if(comboBox.getSelectedIndex() == 2) {
					comboBox.setVisible(false);
					exitGarage(jlabels);
				}
				else if(comboBox.getSelectedIndex() == 3) {
					comboBox.setVisible(false);
					adminConsole(jlabels);
				}
			}
		});
		comboBox.setFont(new Font("Lato", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"(Select an option)", "Enter garage", "Exit garage", "Admin console"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
	}
	
	private void enterGarage(ArrayList<JLabel> jlabels) {
		for(int i = 0; i < 3; i++)
			jlabels.get(i).setVisible(false);
		for(int i = 3; i < 8; i++)
			jlabels.get(i).setVisible(true);
		jlabels.get(7).setText("Ticket #" + garage.getTicketDatabase().createTicket().toString().substring(0, 10));
	}
	
	private void exitGarage(ArrayList<JLabel> jlabels) {
		
	}
	
	private void adminConsole(ArrayList<JLabel> jlabels) {
		
	}
	
	private void openGate(ArrayList<JLabel> jlabels) {
		
	}

}
