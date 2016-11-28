
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Homepage extends JFrame {

	/**
	 * This is the default serialversionuid.
	 */
	private static final long serialVersionUID = 1L;

	private JPanel m_contentPane;
	
	public Homepage(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,303,189);
		m_contentPane = new JPanel();
		m_contentPane.setLayout(null);
		setContentPane(m_contentPane);
		m_contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		JButton button = new JButton("run");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DBDemo app = new DBDemo();
				app.run();
			}
		});
		button.setBounds(48,34,170,66);
		m_contentPane.add(button);
	}
	
	
}
