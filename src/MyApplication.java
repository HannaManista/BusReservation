import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyApplication {

	private UserInterface ui;
	private BusChoice busChoice;
	
	public MyApplication() {
		ui = new UserInterface();
		busChoice = new BusChoice();
		initializeWindowConnections();
	};
	
	public static void main(String[] args) {
		MyApplication myApp = new MyApplication();	
	}
	
	private void initializeWindowConnections() {
		ui.btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.frame.setVisible(false);
				busChoice.frame.setVisible(true);
			}
		});
	}
}
