package UI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AboutProjectiGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutProjectiGUI frame = new AboutProjectiGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AboutProjectiGUI() {
		setTitle("About Projecti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjecti = new JLabel("Projecti");
		lblProjecti.setBounds(5, 5, 440, 60);
		lblProjecti.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjecti.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		contentPane.add(lblProjecti);
		
		JLabel lblNewLabel = new JLabel("Version 0.0.1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 77, 440, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblUniversityOfToledo = new JLabel("University of Toledo");
		lblUniversityOfToledo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversityOfToledo.setBounds(5, 105, 440, 16);
		contentPane.add(lblUniversityOfToledo);
		
		JLabel lblEecsHonors = new JLabel("EECS 2500 Honors Project");
		lblEecsHonors.setHorizontalAlignment(SwingConstants.CENTER);
		lblEecsHonors.setBounds(5, 133, 440, 16);
		contentPane.add(lblEecsHonors);
		
		JLabel lblChrisHousel = new JLabel("Chris Housel - Kisora Thomas");
		lblChrisHousel.setHorizontalAlignment(SwingConstants.CENTER);
		lblChrisHousel.setBounds(5, 161, 440, 16);
		contentPane.add(lblChrisHousel);
		
		JLabel lblJasonGorges = new JLabel("Jason Gorges - Sean Talapia");
		lblJasonGorges.setHorizontalAlignment(SwingConstants.CENTER);
		lblJasonGorges.setBounds(5, 189, 440, 16);
		contentPane.add(lblJasonGorges);
	}

}
