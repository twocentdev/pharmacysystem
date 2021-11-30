package org.unir.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {

	private final String VIEW_TITLE = "Main view";
	private final String JBUTTON_PHARMACY = "Pharmacy";
	private final String JBUTTON_DISTRIBUTOR = "Distributor";
	
	private static MainView instance;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton pharmacyButton = new JButton(JBUTTON_PHARMACY);
		pharmacyButton.addActionListener(e -> {
			goToPharmacyView();
		});
		contentPane.add(pharmacyButton);
		
		JButton distributorButton = new JButton(JBUTTON_DISTRIBUTOR);
		distributorButton.addActionListener(e -> {
			goToDistributorView();
		});
		contentPane.add(distributorButton);
	}
	
	public void goToPharmacyView() {
		System.out.println("Pharmacy button has been clicked.");
		setVisible(false);
		PharmacyView pharmacyView = PharmacyView.getInstance();
		pharmacyView.setVisible(true);
	}
	
	
	public void goToDistributorView() {
		System.out.println("Distributor button has been clicked.");
		setVisible(false);
		DistributorView distributorView = DistributorView.getInstance();
		distributorView.setVisible(true);
	}

	public static MainView getInstance () {
		if (instance == null) {
			instance = new MainView();
		}
		return instance;
	}
}
