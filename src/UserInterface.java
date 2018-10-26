import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTable;

import com.sun.glass.events.MouseEvent;
//import com.toedter.calendar.JDateChooser;

public class UserInterface{

	public JFrame frame;
	private  DBConnect connect;

	private String comboBoxFromSelection;
	private String comboBoxToSelection;
	
	private JComboBox comboBoxFrom;
	private JComboBox comboBoxTo;
	private JTextField textFieldTo;
	private JTextField textFieldFrom;
	public JButton btnSubmit;
	
	public UserInterface() {
		connect = new DBConnect();
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		JLabel lblFrom = new JLabel("From");
		JLabel lblTo = new JLabel("To");
		
		comboBoxFrom = new JComboBox();
		
		comboBoxTo = new JComboBox();
		
		textFieldFrom = new JTextField();
		textFieldFrom.setColumns(10);
		textFieldFrom.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(e.getKeyCode()!= KeyEvent.VK_ENTER) {
						String textFieldString = textFieldFrom.getText();
						String query =  "select * from mock_data where from_city like \"" + textFieldString + "%\"";
						FillCombo(query, "comboBoxFrom");
					}
				}
				catch(Exception ex) {
					System.out.println("Error: "+ex);
				}	
			}
		});
		
		textFieldTo = new JTextField();
		textFieldTo.setColumns(10);
		textFieldTo.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(e.getKeyCode()!= KeyEvent.VK_ENTER) {
						String textFieldString = textFieldTo.getText();
						String query =  "select * from mock_data where to_city like \"" + textFieldString + "%\"";
						FillCombo(query, "comboBoxTo");
					}
				}
				catch(Exception ex) {
					System.out.println("Error: "+ex);
				}
			}
		});
		
		//JDateChooser dateChooser = new JDateChooser();
		
		JButton btnSelectFrom = new JButton("Select");
		btnSelectFrom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBoxFromSelection = (String)comboBoxFrom.getSelectedItem();
				System.out.println(comboBoxFromSelection);
				textFieldFrom.setText(comboBoxFromSelection);
			}
		});
		
		JButton btnSelectTo = new JButton("Select");
		btnSelectTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxToSelection = (String)comboBoxTo.getSelectedItem();
				System.out.println(comboBoxToSelection);
				textFieldTo.setText(comboBoxToSelection);				
			}
		});
		
		btnSubmit = new JButton("Submit");
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(23)
						.addComponent(lblFrom)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									//.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBoxFrom, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldFrom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
								.addGap(18)
								.addComponent(lblTo))
							.addComponent(btnSelectFrom))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxTo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldTo, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
							.addComponent(btnSelectTo))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFrom)
						.addComponent(textFieldFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTo)
						.addComponent(textFieldTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelectFrom)
						.addComponent(btnSelectTo))
					.addGap(28)
					//.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	// method fills the chosen ComboBox with database's elements given by the query
	private void FillCombo(String query, String WhichCombo) {
		try {
			if(WhichCombo.equals("comboBoxFrom"))	{
				comboBoxFrom.removeAllItems();
				HashSet<String> comboHashSet = connect.getStringHashSetByExpression(query, "from_city");
				for(String chosenElement : comboHashSet) {
					comboBoxFrom.addItem(chosenElement);
				}
			}
			else if(WhichCombo.equals("comboBoxTo")) {
				comboBoxTo.removeAllItems();
				HashSet<String> comboHashSet = connect.getStringHashSetByExpression(query, "to_city");
				for(String chosenElement : comboHashSet) {
					comboBoxTo.addItem(chosenElement);	
				}
			}
		}
		catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	
	public void getSelectedItemComboBox(String chosenCityComboBox) {	
		try{
			if(chosenCityComboBox.equals("comboBoxFrom")) {
				Object selectedObject = comboBoxFrom.getSelectedItem();
				System.out.println(selectedObject.toString());
				textFieldFrom.setText(selectedObject.toString());
			}
			else if(chosenCityComboBox.equals("comboBoxTo")) {
				textFieldTo.setText(null);	
				Object selectedObject = comboBoxTo.getSelectedItem();
				System.out.println(selectedObject.toString());
				textFieldTo.setText(selectedObject.toString());	
			}
		}
		catch(Exception ex) {
			System.out.println("Error: "+ ex);
		}
	}
}
