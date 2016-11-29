import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class UserPaymentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPaymentPage frame = new UserPaymentPage();
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
	public UserPaymentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserPayment = new JLabel("User Payment");
		lblUserPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserPayment.setBounds(160, 11, 104, 24);
		contentPane.add(lblUserPayment);
		
		JLabel lblFeesDue = new JLabel("Fees Due:");
		lblFeesDue.setBounds(119, 76, 49, 14);
		contentPane.add(lblFeesDue);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		lblPaymentAmount.setBounds(82, 121, 86, 14);
		contentPane.add(lblPaymentAmount);
		
		JLabel feesLabel = new JLabel("______________");
		feesLabel.setBounds(178, 76, 86, 14);
		contentPane.add(feesLabel);
		
		JButton payNowButton = new JButton("Pay Now");
		payNowButton.setBounds(175, 181, 89, 23);
		contentPane.add(payNowButton);
		
		JFormattedTextField paymentAmountTextfield = new JFormattedTextField();
		paymentAmountTextfield.setBounds(178, 118, 86, 20);
		contentPane.add(paymentAmountTextfield);
		
		JButton button = new JButton("<");
		button.setBounds(10, 11, 46, 23);
		contentPane.add(button);
	}

}
