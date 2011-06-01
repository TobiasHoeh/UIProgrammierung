import java.awt.FlowLayout;
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

		textlabel = new JLabel("Text eingeben:");
		textfield = new JTextField(20);



		Object[] werte = { "DVD", "VCD", "VHS", "SVCD", "sonstiges" };
		JComboBox medium = new JComboBox(werte);

		medium.addItemListener(zuhoerer);
		JPanel main = new JPanel(new FlowLayout());
		main.add(medium);
		main.add(textlabel);
		main.add(textfield);

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
