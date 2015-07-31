package UI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddProjectProjectiGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_author;
	private JTextField textField_decription;
	private JTextField textField_estimated;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProjectProjectiGUI frame = new AddProjectProjectiGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddProjectProjectiGUI() {
		setTitle("Projecti - Add Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(6, 6, 104, 16);
		contentPane.add(lblName);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(6, 34, 104, 16);
		contentPane.add(lblAuthor);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(6, 62, 104, 16);
		contentPane.add(lblDescription);
		
		JLabel lblEstCompletion = new JLabel("Est. Completion");
		lblEstCompletion.setBounds(6, 90, 104, 16);
		contentPane.add(lblEstCompletion);
		
		textField_name = new JTextField();
		textField_name.setBounds(122, 0, 322, 28);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_author = new JTextField();
		textField_author.setBounds(122, 28, 322, 28);
		contentPane.add(textField_author);
		textField_author.setColumns(10);
		
		textField_decription = new JTextField();
		textField_decription.setBounds(122, 56, 322, 28);
		contentPane.add(textField_decription);
		textField_decription.setColumns(10);
		
		textField_estimated = new JTextField();
		textField_estimated.setBounds(122, 84, 322, 28);
		contentPane.add(textField_estimated);
		textField_estimated.setColumns(10);
	}

}
