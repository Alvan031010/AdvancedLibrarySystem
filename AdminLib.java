

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLib extends JFrame {

	private JPanel contentPane;
	AdminLogin adminlogin = new AdminLogin();
	LibrarianLogin librarianlogin = new LibrarianLogin();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLib frame = new AdminLib();
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
	public AdminLib() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		panel_2.setBounds(150, 70, 150, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAdmin.setForeground(Color.black);
				
				adminlogin.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAdmin.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAdmin.setForeground(Color.black);
			}
		});
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdmin.setBounds(10, 11, 130, 36);
		panel_2.add(lblAdmin);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(150, 170, 150, 60);
		contentPane.add(panel_2_1);
		
		JLabel lblLibrarian = new JLabel("LIBRARIAN");
		lblLibrarian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLibrarian.setForeground(Color.red);
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				librarianlogin.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLibrarian.setForeground(Color.black);
			}
		});
		
		
		lblLibrarian.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLibrarian.setBounds(10, 11, 130, 36);
		panel_2_1.add(lblLibrarian);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(0, 0, 0));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminLib.this.dispose();
				}}
		});
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(424, 0, 26, 32);
		contentPane.add(lblX);
		setLocationRelativeTo(null);
	}
}
