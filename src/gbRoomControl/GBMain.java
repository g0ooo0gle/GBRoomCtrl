package gbRoomControl;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import common.MainPanel;

public class GBMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GBMain frame = new GBMain();
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
	public GBMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		MainPanel mainPanel = new  MainPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) mainPanel.getLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setViewportView(mainPanel);
		contentPane.add(scrollPane);
	}

}
