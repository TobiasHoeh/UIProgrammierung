import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		final JTextField txtGeburtsname;
		final JLabel lblGeburtsname;
		
		final JFrame logonscreen = new JFrame("Logon");
		final Listenoperationen liste = new Listenoperationen();
		
		logonscreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		JPanel hauptpanel = new JPanel(new BorderLayout());
		JPanel oben = new JPanel(new FlowLayout(1));
		JLabel lblKonsole = new JLabel("");
		
		oben.add(lblKonsole, BorderLayout.EAST);
		
		JPanel mitte = new JPanel(new FlowLayout(1));
		JPanel verbindungen = new JPanel(new GridLayout(0,2));
		JPanel panel;
		

		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Anrede:"));
		verbindungen.add(panel);
		
		Object[] werte = {"Frau", "Mann"};
		final JComboBox cbGeschlecht = new JComboBox(werte);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(cbGeschlecht);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Name:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		final JTextField txtName = new JTextField(10);
		panel.add(txtName);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("Vorname:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		final JTextField txtVorname = new JTextField(10);
		panel.add(txtVorname);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		lblGeburtsname = new JLabel("Geburtsname:");
		panel.add(lblGeburtsname);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		txtGeburtsname = new JTextField(10);
		panel.add(txtGeburtsname);
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		panel.add(new JLabel("E-Mail:"));
		verbindungen.add(panel);
		
		panel = new JPanel(new FlowLayout(0));
		final JTextField txtEMail = new JTextField(10);
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
		
		final ButtonGroup group = new ButtonGroup();
		
		group.add(cbLedig);
		group.add(cbVerheiratet);
		group.add(cbVerwitwet);
		group.add(cbGeschieden);
		
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("ledig")) {
					txtGeburtsname.setText("");
					lblGeburtsname.setVisible(false);
					txtGeburtsname.setVisible(false);
					logonscreen.pack();
				} else {
					lblGeburtsname.setVisible(true);
					txtGeburtsname.setVisible(true);
					logonscreen.pack();
				}

			}
		};
		
		ActionListener actionButton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Hinzufügen")) {
					System.out.println(liste.hinzufuegen(cbGeschlecht.getSelectedItem().toString(), txtName.getText(), txtVorname.getText(), 
							txtGeburtsname.getText(), txtEMail.getText(), group.getSelection().toString()));
				} else if (command.equals("Anzeigen")) {
					liste.anzeigen(txtName.getText(), txtVorname.getText());
				} else if (command.equals("Suchen")) {
					if(liste.suchen(txtName.getText(), txtVorname.getText())) {
						System.out.println("Der Einwohner wurde gefunden.");
					}
				} else if (command.equals("Löschen")) {
					if(liste.loeschen(txtName.getText(), txtVorname.getText())) {
						System.out.println("Der Einwohner wurde gelöscht.");
					}
				} else if (command.equals("Liste anzeigen")) {
					liste.anzeigen(txtName.getText(), txtVorname.getText());
				} else  {
					System.out.println("AAAAAAAH!");
				}

			}
		};
		
		
		
		
		fStandPanel.add(cbLedig);
		fStandPanel.add(cbVerheiratet);
		fStandPanel.add(cbVerwitwet);
		fStandPanel.add(cbGeschieden);
		
		Border rahmen2 = BorderFactory.createTitledBorder("Dateien");
		fStandPanel.setBorder(rahmen2);
		
		cbLedig.addActionListener(action);
		cbVerheiratet.addActionListener(action);
		cbVerwitwet.addActionListener(action);
		cbGeschieden.addActionListener(action);
		
		mitte.add(fStandPanel);
		
		hauptpanel.add(mitte, BorderLayout.CENTER);
		
		//Buttons
		JPanel buttons = new JPanel(new FlowLayout(1));
		JButton btnHinzufuegen = new JButton("Hinzufügen"); 
		JButton btnAnzeigen = new JButton("Anzeigen");
		JButton btnSuchen = new JButton("Suchen");
		JButton btnLoeschen = new JButton("Löschen");
		JButton btnListeAnzeigen = new JButton("Liste anzeigen");
		
		buttons.add(btnHinzufuegen);
		buttons.add(btnAnzeigen);
		buttons.add(btnSuchen);
		buttons.add(btnLoeschen);
		buttons.add(btnListeAnzeigen);
		
		btnHinzufuegen.addActionListener(actionButton);
		btnAnzeigen.addActionListener(actionButton);
		btnSuchen.addActionListener(actionButton);
		btnLoeschen.addActionListener(actionButton);
		btnListeAnzeigen.addActionListener(actionButton);
		
		hauptpanel.add(oben,BorderLayout.NORTH);
		hauptpanel.add(buttons, BorderLayout.SOUTH);
	
		logonscreen.getContentPane().add(hauptpanel);
		
		logonscreen.pack();
		logonscreen.setVisible(true);
			
	}
}
