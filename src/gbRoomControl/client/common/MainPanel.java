package gbRoomControl.client.common;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel NameLabel = new JLabel("ただのボタンパネル");
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 0;
		add(NameLabel, gbc_NameLabel);

		JButton btnOn = new JButton("ON");
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameLabel.setText("ON");
			}
		});
		GridBagConstraints gbc_btnOn = new GridBagConstraints();
		gbc_btnOn.insets = new Insets(0, 0, 5, 5);
		gbc_btnOn.gridx = 0;
		gbc_btnOn.gridy = 1;
		add(btnOn, gbc_btnOn);

		JButton btnOff = new JButton("OFF");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameLabel.setText("OFF");
			}
		});
		GridBagConstraints gbc_btnOff = new GridBagConstraints();
		gbc_btnOff.insets = new Insets(0, 0, 5, 5);
		gbc_btnOff.gridx = 1;
		gbc_btnOff.gridy = 1;
		add(btnOff, gbc_btnOff);

		JButton btnOn_1 = new JButton("ON");
		GridBagConstraints gbc_btnOn_1 = new GridBagConstraints();
		gbc_btnOn_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnOn_1.gridx = 0;
		gbc_btnOn_1.gridy = 2;
		add(btnOn_1, gbc_btnOn_1);

		JButton btnOff_1 = new JButton("OFF");
		GridBagConstraints gbc_btnOff_1 = new GridBagConstraints();
		gbc_btnOff_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnOff_1.gridx = 1;
		gbc_btnOff_1.gridy = 2;
		add(btnOff_1, gbc_btnOff_1);

	}

}
