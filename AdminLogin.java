import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Event;
public class AdminLogin extends JFrame {

	private Image img_logo = new ImageIcon(AdminLogin.class.getResource("res/admin.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JPanel panel_2;
	private JLabel iconLogo;
	private JLabel lblX;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel lblLoginMsg = new JLabel("");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	/**
	 * 
	 */
	public AdminLogin() {
		setUndecorated(true);
		Image icon = new ImageIcon(this.getClass().getResource("res/information.png")).getImage(); 
		this.setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(200, 217, 300, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUser.getText().equals("Username")) {
					txtUser.setText("");
					
				} else {
					txtUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUser.getText().equals("")) {
					txtUser.setText("Username");
				}
			}
		});
		txtUser.setBorder(null);
		txtUser.setText("Username");
		txtUser.setBounds(10, 11, 280, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(200, 283, 300, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPass.getText().equals("Password")) {
				txtPass.setEchoChar('●');
				txtPass.setText(""); }
				else {
					txtPass.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equals("")) {
					txtPass.setText("Password");
					txtPass.setEchoChar((char)0);
				}
			}
		});
		txtPass.setBorder(null);
		txtPass.setEchoChar((char)0);
		txtPass.setText("Password");
		txtPass.setBounds(10, 11, 280, 20);
		panel_1.add(txtPass);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				if(txtUser.getText().equalsIgnoreCase("Admin_01") && txtPass.getText().equals("AdminOne") ||
				   txtUser.getText().equalsIgnoreCase("Admin_02") && txtPass.getText().equals("AdminTwo") ||
				   txtUser.getText().equalsIgnoreCase("Admin_03") && txtPass.getText().equals("AdminThree")) {
					lblLoginMsg.setText("");
					JOptionPane.showMessageDialog(null, "Login Successfully");
					dispose();
					AdminPage adminpage = new AdminPage();
					
					
					adminpage.setVisible(true);
					
				}
				else if(txtUser.getText().equals("") || txtUser.getText().equals("Username") ||
						  txtPass.getText().equals("") || txtPass.getText().equals("Password")) {
					lblLoginMsg	.setText("Input  all requirements.");
				} else {
					lblLoginMsg	.setText("Invalid Account.");
				}
			}
		});
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(200, 350, 300, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(122, 11, 65, 27);
		panel_2.add(lblNewLabel);
		
		iconLogo = new JLabel("");
		iconLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		iconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		iconLogo.setBounds(200, 0, 300, 190);
		contentPane.add(iconLogo);
		iconLogo.setIcon(new ImageIcon(img_logo));
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
		});
		lblX.setForeground(new Color(255, 250, 250));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(669, 11, 21, 33);
		contentPane.add(lblX);
		
		lblLoginMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMsg.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoginMsg.setBounds(210, 406, 282, 33);
		contentPane.add(lblLoginMsg);
		setLocationRelativeTo(null);
	}
}