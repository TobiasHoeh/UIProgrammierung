import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class StammdatenErfassen {
	public static void main(String[] args) {

		fenster();
	}

	public static void fenster() {
		JFrame logonscreen = new JFrame("Logon");
		logonscreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		JPanel hauptpanel = new JPanel(new BorderLayout());
		JPanel oben = new JPanel(new FlowLayout(1));
		JLabel lblEingestellt = new JLabel("");
		
		oben.add(lblEingestellt, BorderLayout.EAST);
		
		JPanel mitte = new JPanel(new FlowLayout(1));
		JPanel verbindungen = new JPanel(new GridLayout(0,2));
		JPanel panel;
		

		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Anrede:"));
		verbindungen.add(panel);
		
		Object[] werte = {"Frau", "Mann"};
		JComboBox cbGeschlecht = new JComboBox(werte);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(cbGeschlecht);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Name:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		JTextField txtName = new JTextField(10);
		panel.add(txtName);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Vorname:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		JTextField txtVorname = new JTextField(10);
		panel.add(txtVorname);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Geburtsname:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		JTextField txtGeburtsname = new JTextField(10);
		panel.add(txtGeburtsname);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("E-Mail:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		JTextField txtEMail = new JTextField(10);
		panel.add(txtEMail);
		verbindungen.add(panel);
		
		// Rahmen
		Border rahmen1 = BorderFactory.createTitledBorder("Kontaktdaten");
		verbindungen.setBorder(rahmen1);

		mitte.add(verbindungen);
		
		JPanel fStandPanel = new JPanel(new GridLayout(0,1));
		
		JRadioButton cbLedig = new JRadioButton("ledig");
		JRadioButton cbVerheiratet = new JRadioButton("verheiratet");
		JRadioButton cbVerwitwet = new JRadioButton("verwitwet");
		JRadioButton cbGeschieden = new JRadioButton("geschieden");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(cbLedig);
		group.add(cbVerheiratet);
		group.add(cbVerwitwet);
		group.add(cbGeschieden);
		
		fStandPanel.add(cbLedig);
		fStandPanel.add(cbVerheiratet);
		fStandPanel.add(cbVerwitwet);
		fStandPanel.add(cbGeschieden);
		
		Border rahmen2 = BorderFactory.createTitledBorder("Dateien");
		fStandPanel.setBorder(rahmen2);
		
		mitte.add(fStandPanel);
		
		hauptpanel.add(mitte, BorderLayout.CENTER);
		
		//Buttons
		JPanel buttons = new JPanel(new FlowLayout(1));
		buttons.add(new JButton("Hinzufügen"));
		buttons.add(new JButton("Anzeigen"));
		buttons.add(new JButton("Suchen"));
		buttons.add(new JButton("Löschen"));
		buttons.add(new JButton("Liste anzeigen"));
		
		hauptpanel.add(oben,BorderLayout.NORTH);
		hauptpanel.add(buttons, BorderLayout.SOUTH);
	
		logonscreen.getContentPane().add(hauptpanel);
		
		logonscreen.pack();
		logonscreen.setVisible(true);
			
	}
}
