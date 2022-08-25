import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Server extends JFrame {

	private JPanel contentPane;
	private ServerSocket server;
	private Socket socket;
	private DataInputStream in;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server(6666);
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
	public Server(int port) {
		try
		{ 
			// we start our server
			server = new ServerSocket(port);
			server.getLocalPort();
			server.getLocalSocketAddress();
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
		
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(177, 194, 85, 21);

		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SERVER");
		lblNewLabel.setBounds(361, 10, 68, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setBounds(34, 54, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setBounds(34, 93, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbShowIP = new JLabel("127.0.0.1");
		lbShowIP.setBounds(106, 54, 104, 13);
		contentPane.add(lbShowIP);
		
		JLabel lbShowPort = new JLabel(String.valueOf(server.getLocalPort()));
		lbShowPort.setBounds(106, 93, 45, 13);
		contentPane.add(lbShowPort);
		

	}
}
