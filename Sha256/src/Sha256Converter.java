/**
	@author Antonio Fuscaldo
	@version 1.0.1
*/

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.Window.Type;

public class Sha256Converter {

	private JFrame frame;
	private JTextField ConvertString;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sha256Converter window = new Sha256Converter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sha256Converter() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setResizable(false);
		frame.setBounds(100, 100, 578, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Inserisci il testo da convertire");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(16, 16, 213, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblStringaConvertita = new JLabel("Stringa convertita");
		lblStringaConvertita.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblStringaConvertita.setBounds(16, 333, 127, 16);
		frame.getContentPane().add(lblStringaConvertita);

		ConvertString = new JTextField();
		ConvertString.setBounds(26, 361, 526, 29);
		frame.getContentPane().add(ConvertString);
		ConvertString.setColumns(10);

		JButton btnConverti = new JButton("Converti");
		btnConverti.setBounds(230, 430, 117, 29);
		frame.getContentPane().add(btnConverti);

		JEditorPane TextInsert = new JEditorPane();
		TextInsert.setBackground(Color.WHITE);
		TextInsert.setBounds(26, 44, 526, 277);
		frame.getContentPane().add(TextInsert);

		JLabel feedback_Conversione = new JLabel("");
		feedback_Conversione.setBounds(318, 402, 234, 16);
		frame.getContentPane().add(feedback_Conversione);

		JLabel label_copyright = new JLabel("Created by Antonio Fuscaldo");
		label_copyright.setForeground(Color.GRAY);
		label_copyright.setBounds(198, 469, 181, 16);
		frame.getContentPane().add(label_copyright);


	btnConverti.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String StringaInserita = TextInsert.getText();
			String StringaConvertita = getSha256(StringaInserita);
			feedback_Conversione.setText("Conversione avvenuta con successo");

				ConvertString.setText(StringaConvertita);
		}
	});
	}


	private static String getSha256(String value) {
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(value.getBytes());
					return bytesToHex(md.digest());
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
			for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
				return result.toString();
	}

}
