import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class Logon {

	
	public static void main(String[] args) {
		
		fenster();
	}

	
	public static void fenster(){
	
		JFrame logonscreen = new JFrame("Logon");
		logonscreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		JPanel hauptpanel = new JPanel(new BorderLayout());
		
		JPanel oben = new JPanel(new FlowLayout(1));
		Border rahmen3 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		oben.setBorder(rahmen3);
		
		//Verbindungen
		JPanel verbindungen = new JPanel(new GridLayout(0,2));
		
		JPanel panel;
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("User:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JTextField(10));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Passwort:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JTextField(10));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Art:"));
		verbindungen.add(panel);
		
		Object[] werte = {"FTP", "Telnet", "HTTP", "SMTP"};
		JComboBox medium = new JComboBox(werte);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(medium);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Host:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JTextField(10));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Port:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JTextField(10));
		verbindungen.add(panel);
		
		// Rahmen
		Border rahmen1 = BorderFactory.createTitledBorder("Verbindungen");
		verbindungen.setBorder(rahmen1);

		oben.add(verbindungen);
		
		//Dateien
		JPanel dateien = new JPanel(new GridLayout(0,2));
		
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Quelle:"));
		dateien.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JTextField(10));
		dateien.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Ziel:"));
		dateien.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JTextField(10));
		dateien.add(panel);
		
		Border rahmen2 = BorderFactory.createTitledBorder("Dateien");
		dateien.setBorder(rahmen2);
		
		oben.add(dateien);
		
		hauptpanel.add(oben, BorderLayout.NORTH);
		
		
		//Buttons
		JPanel buttons = new JPanel(new FlowLayout(1));
		buttons.add(new JButton("OK"));
		buttons.add(new JButton("Cancel"));
		
		hauptpanel.add(buttons, BorderLayout.SOUTH);
		
		
		logonscreen.getContentPane().add(hauptpanel);
		
		logonscreen.pack();
		logonscreen.setVisible(true);
		
	}
	
}
