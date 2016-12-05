import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class EmployeeMenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMenuPage frame = new EmployeeMenuPage();
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
	public EmployeeMenuPage() {
		//set up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//set up contents
		JLabel lblEmployeePortal = new JLabel("Employee Portal");
		lblEmployeePortal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeePortal.setBounds(145, 22, 140, 28);
		contentPane.add(lblEmployeePortal);
		
		JButton btnUserRecords = new JButton("Non-Employee User Records");
		btnUserRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new EmployeeUserRecordPage();
			}
			});
		btnUserRecords.setBounds(100, 101, 200, 63);
		contentPane.add(btnUserRecords);
		
		JButton btnNewEmployee = new JButton("New Employee");
		btnNewEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new NewEmployeePage();
			}
			});
		btnNewEmployee.setBounds(340, 101, 124, 63);
		contentPane.add(btnNewEmployee);
		
		//archive fields
		JButton btnArchive = new JButton("Archive Users");
		btnArchive.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				//will uncomment when function is added
				DatabaseManager dbm = new DatabaseManager();
				try {
					dbm.archive();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(new JFrame(), "All users archived as of " + new Date(System.currentTimeMillis()));
				setVisible(true);
			}
		});
		btnArchive.setBounds(120, 399, 124, 63);
		contentPane.add(btnArchive);
		
		//logout fields
		JButton btnLogOut = new JButton("< Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new MainMenuPage();
			}
			});
		btnLogOut.setBounds(10, 11, 89, 23);
		contentPane.add(btnLogOut);
		
		
		
		//show page
		setVisible(true);
	}
}
