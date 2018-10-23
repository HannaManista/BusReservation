import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class BusChoice {
	
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public BusChoice() {
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<JourneyInfo> chosenBuses = new ArrayList();
		//System.out.println(ui.comboBoxFromSelection);
//		chosenBuses = connection.getByExpression("select + from mock_data where from_city like\"" + ui.comboBoxFromSelection + "%\"");
//		System.out.println(chosenBuses);
	}

	
	
}
