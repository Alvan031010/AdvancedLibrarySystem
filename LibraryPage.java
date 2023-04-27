import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LibraryPage extends JFrame {

	private JPanel contentPane;
	private JTextField BookField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryPage frame = new LibraryPage();
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
	public LibraryPage() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new LineBorder(new Color(238, 130, 238), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOKS AVAILABLE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 730, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("[ 0 ] : Kanojo Okarishimasu | Author: Miyajima Reiji");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 140, 583, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("[ 1 ] : Gal Gohan  | Author: Marii Taiyō ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 198, 583, 47);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("[ 2 ] : Mayo Chiki  | Author: Hajime Asano");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 256, 583, 47);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("BOOKS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 93, 302, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NO OF COPIES");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(593, 88, 147, 47);
		contentPane.add(lblNewLabel_3);
		
		JLabel copy0 = new JLabel();
		copy0.setText("2");
		copy0.setFont(new Font("Tahoma", Font.BOLD, 15));
		copy0.setBounds(656, 140, 45, 47);
		contentPane.add(copy0);
		
		JLabel copy1 = new JLabel();
		copy1.setText("3");
		copy1.setFont(new Font("Tahoma", Font.BOLD, 15));
		copy1.setBounds(656, 198, 45, 47);
		contentPane.add(copy1);
		
		JLabel copy2 = new JLabel();
		copy2.setText("4");
		copy2.setFont(new Font("Tahoma", Font.BOLD, 15));
		copy2.setBounds(656, 256, 45, 47);
		contentPane.add(copy2);
		
		BookField = new JTextField();
		BookField.setHorizontalAlignment(SwingConstants.CENTER);
		BookField.setBounds(64, 384, 190, 36);
		contentPane.add(BookField);
		BookField.setColumns(10);
		
		JLabel labelOutput = new JLabel("");
		labelOutput.setBounds(10, 329, 583, 44);
		
		JButton RentButton = new JButton("RENT");
		RentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inv book1 = new Inv("Kanojo Okarishimasu","Miyajima Reiji", 2);
				Inv book2 = new Inv("Gal Gohan","Marii Taiyō", 3);
				Inv book3 = new Inv("Mayo Chiki","Hajime Asano", 4);
				
				Inv[] mangas = { book1, book2, book3 };
				
				String userInput = BookField.getText();
				
			    int num = Integer.parseInt(userInput); // make the text in text field into integer
			    
				 if (num < 0 ) { 
					 labelOutput.setText("NO COPIES AVAILABLE");							
		         } else if (num >= mangas.length) { 
		        	 labelOutput.setText("INDEX DOES NOT EXIST. TRY AGAIN"); // if the input is less than the number of index
		         }
		         else {  
		        	 //borrow method
		             mangas[num].borrowBook(labelOutput);
		         }
				
				
		}});
		RentButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		RentButton.setBounds(610, 382, 92, 36);
		contentPane.add(RentButton);
		
		
		contentPane.add(labelOutput);
		
		
		setLocationRelativeTo(null);
	}
}
