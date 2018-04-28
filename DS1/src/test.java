import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.VetoableChangeListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class test {

	private ArrayList<JLabel> jlabels;
	private ArrayList<JRadioButton> radios;
	private JDateChooser jdc;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		jlabels = new ArrayList<JLabel>();
		radios = new ArrayList<JRadioButton>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1028, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 200, 200, 200, 200};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel title = new JLabel("Reports");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Lato", Font.BOLD, 22));
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.insets = new Insets(0, 0, 5, 0);
		gbcTitle.gridx = 0;
		gbcTitle.gridy = 0;
		gbcTitle.gridwidth = 5;
		frame.getContentPane().add(title, gbcTitle);
		
		JLabel label1 = new JLabel("Please select the type of report you'd like to view:");
		label1.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel1 = new GridBagConstraints();
		gbcLabel1.insets = new Insets(0, 0, 5, 5);
		gbcLabel1.gridx = 1;
		gbcLabel1.gridy = 1;
		gbcLabel1.gridwidth = 3;
		frame.getContentPane().add(label1, gbcLabel1);
		jlabels.add(label1);
		
		
		JRadioButton radio1 = new JRadioButton("Occupancy report");
		radio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewingWindow();
			}
		});
		radio1.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcRadio1 = new GridBagConstraints();
		gbcRadio1.insets = new Insets(0, 0, 5, 5);
		gbcRadio1.gridx = 1;
		gbcRadio1.gridy = 2;
		frame.getContentPane().add(radio1, gbcRadio1);
		radios.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("Payment report");
		radio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewingWindow();
			}
		});
		radio2.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcRadio2 = new GridBagConstraints();
		gbcRadio2.insets = new Insets(0, 0, 5, 5);
		gbcRadio2.gridx = 3;
		gbcRadio2.gridy = 2;
		frame.getContentPane().add(radio2, gbcRadio2);
		radios.add(radio2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radio1);
		bg.add(radio2);
		radio1.setSelected(false);
		
		JLabel label2 = new JLabel("Please select a viewing window:");
		label2.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel2 = new GridBagConstraints();
		gbcLabel2.insets = new Insets(0, 0, 5, 5);
		gbcLabel2.gridx = 1;
		gbcLabel2.gridy = 3;
		gbcLabel2.gridwidth = 3;
		frame.getContentPane().add(label2, gbcLabel2);
		label2.setVisible(false);
		jlabels.add(label2);
		
		JRadioButton radio3 = new JRadioButton("By month");
		radio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateWindow();
			}
		});
		radio3.setFont(new Font("Lato", Font.PLAIN, 14));
		GridBagConstraints gbcRadio3 = new GridBagConstraints();
		gbcRadio3.insets = new Insets(0, 0, 5, 5);
		gbcRadio3.gridx = 1;
		gbcRadio3.gridy = 4;
		frame.getContentPane().add(radio3, gbcRadio3);
		radio3.setVisible(false);
		radios.add(radio3);
		
		JRadioButton radio4 = new JRadioButton("By day");
		radio4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateWindow();
			}
		});
		radio4.setFont(new Font("Lato", Font.PLAIN, 14));
		GridBagConstraints gbcRadio4 = new GridBagConstraints();
		gbcRadio4.insets = new Insets(0, 0, 5, 5);
		gbcRadio4.gridx = 2;
		gbcRadio4.gridy = 4;
		frame.getContentPane().add(radio4, gbcRadio4);
		radio4.setVisible(false);
		radios.add(radio4);
		
		JRadioButton radio5 = new JRadioButton("By hour");
		radio5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateWindow();
			}
		});
		radio5.setFont(new Font("Lato", Font.PLAIN, 14));
		GridBagConstraints gbcRadio5 = new GridBagConstraints();
		gbcRadio5.insets = new Insets(0, 0, 5, 5);
		gbcRadio5.gridx = 3;
		gbcRadio5.gridy = 4;
		frame.getContentPane().add(radio5, gbcRadio5);
		radio5.setVisible(false);
		radios.add(radio5);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(radio3);
		bg2.add(radio4);
		bg2.add(radio5);
		radio3.setSelected(false);
		
		JLabel label3 = new JLabel("Select the specific window:");
		label3.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel3 = new GridBagConstraints();
		gbcLabel3.insets = new Insets(0, 0, 5, 5);
		gbcLabel3.gridx = 1;
		gbcLabel3.gridy = 5;
		gbcLabel3.gridwidth = 3;
		frame.getContentPane().add(label3, gbcLabel3);
		label3.setVisible(false);
		jlabels.add(label3);

		jdc = new JDateChooser();
		jdc.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				jdc.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						System.out.println("PROPERTY CHANGE");
						System.out.println(jdc.getCalendar().getTime().toString());
					}
				});
			}
		});
		jdc.getJCalendar().setTodayButtonVisible(true);
		GridBagConstraints jdcGbc = new GridBagConstraints();
		jdcGbc.fill = GridBagConstraints.HORIZONTAL;
		jdcGbc.insets = new Insets(0, 0, 5, 5);
		jdcGbc.gridx = 2;
		jdcGbc.gridy = 6;
		jdcGbc.weightx = 1.0;
		frame.getContentPane().add(jdc, jdcGbc);
		jdc.setVisible(false);
		
		JLabel label4 = new JLabel("Type in the hour: (e.g. 1PM)");
		label4.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbcLabel4 = new GridBagConstraints();
		gbcLabel4.insets = new Insets(0, 0, 0, 5);
		gbcLabel4.gridx = 1;
		gbcLabel4.gridy = 7;
		gbcLabel4.gridwidth = 3;
		frame.getContentPane().add(label4, gbcLabel4);
		label4.setVisible(false);
		jlabels.add(label4);
		
		textField = new JTextField();
		textField.setFont(new Font("Lato", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 8;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setVisible(false);
		
		defaultWindow();
		
	}
	
	private void defaultWindow() {
		jlabels.get(0).setVisible(true);
		for(int i = 1; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(false);
		for(int i = 0; i < 2; i++)
			radios.get(i).setVisible(true);
		for(int i = 2; i < radios.size(); i++)
			radios.get(i).setVisible(false);
		jdc.setVisible(false);
	}
	
	private void viewingWindow() {
		for(int i = 0; i < 2; i++)
			jlabels.get(i).setVisible(true);
		for(int i = 2; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(false);
		for(int i = 0; i < radios.size(); i++)
			radios.get(i).setVisible(true);
		for(int i = 2; i < radios.size(); i++)
			radios.get(i).setSelected(false);
		jdc.setVisible(false);
	}
	
	private void dateWindow() {
		for(int i = 0; i < jlabels.size(); i++)
			jlabels.get(i).setVisible(true);
		for(int i = 0; i < radios.size(); i++)
			radios.get(i).setVisible(true);
		jdc.setVisible(true);
		if(radios.get(4).isSelected()) {
			jlabels.get(3).setVisible(true);
			radios.get(4).setVisible(true);
		}
	}

}
