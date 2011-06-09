import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ItemListenerTest {

	JLabel textlabel;
	JTextField textfield;

	public ItemListenerTest() {
		JFrame fenster = new JFrame("Listener Test");
		fenster.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ItemListener zuhoerer = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				JComboBox box = (JComboBox) e.getSource();

				if (box.getSelectedItem().equals("sonstiges")) {
					textlabel.setVisible(true);
					textfield.setVisible(true);
				} else {
					textlabel.setVisible(false);
					textfield.setVisible(false);
				}

			}
		};

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("OK")) {
					textfield.setText("OK gedrückt!");
				} else {
					System.exit(0);
				}

			}
		};

		textlabel = new JLabel("Text eingeben:");
		textfield = new JTextField(20);

		Object[] werte = { "DVD", "VCD", "VHS", "SVCD", "sonstiges" };
		JComboBox medium = new JComboBox(werte);

		medium.addItemListener(zuhoerer);

		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");

		ok.addActionListener(action);
		cancel.addActionListener(action);

		JPanel main = new JPanel(new FlowLayout());
		main.add(medium);
		main.add(textlabel);
		main.add(textfield);
		main.add(ok);
		main.add(cancel);

		fenster.getContentPane().add(main);
		fenster.pack();
		fenster.setVisible(true);

		textlabel.setVisible(false);
		textfield.setVisible(false);
	}

	public static void main(String[] args) {
		ItemListenerTest fenster = new ItemListenerTest();
	}
}
