package UI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectiGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectiGUI frame = new ProjectiGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProjectiGUI() {
		setTitle("Projecti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(325, 34, 119, 206);
		contentPane.add(textPane);
		
		JButton btnQuitProgram = new JButton("Quit Program");
		btnQuitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitProgram.setBounds(335, 249, 117, 29);
		contentPane.add(btnQuitProgram);
		
		JButton btnAboutProgram = new JButton("About Projecti");
		btnAboutProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Opens About Window
				AboutProjectiGUI.main(null);
			}
		});
		btnAboutProgram.setBounds(217, 249, 126, 29);
		contentPane.add(btnAboutProgram);
		
		JButton btnNewProject = new JButton("New Project");
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Opens New Project Window
				AddProjectProjectiGUI.main(null);
			}
		});
		btnNewProject.setBounds(0, 249, 117, 29);
		contentPane.add(btnNewProject);
		
		JLabel lblProjectList = new JLabel("Project List");
		lblProjectList.setBounds(325, 6, 119, 16);
		contentPane.add(lblProjectList);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Opens Settings Window
				SettingsProjectiGUI.main(null);
			}
		});
		btnSettings.setBounds(108, 249, 117, 29);
		contentPane.add(btnSettings);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(6, 34, 307, 206);
		contentPane.add(textPane_1);
		
		JLabel lblProjectiOutput = new JLabel("Projecti Output");
		lblProjectiOutput.setBounds(6, 6, 307, 16);
		contentPane.add(lblProjectiOutput);
	}

}
