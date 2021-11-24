package org.unir.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    private final String JFRAME_TITLE = "Main view";
    private final String JBUTTON_PHARMACY = "Pharmacy";
    private final String JBUTTON_DISTRIBUTOR = "Distributor";

    public void initView () {
        JFrame frame = new JFrame(JFRAME_TITLE);
        JPanel panel = new JPanel();
        JButton pharmacyButton = new JButton(JBUTTON_PHARMACY);
        JButton distributorButton = new JButton(JBUTTON_DISTRIBUTOR);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(panel);

        panel.setLayout( new FlowLayout() );
        panel.add(pharmacyButton);
        panel.add(distributorButton);

        pharmacyButton.addActionListener(e -> {
            PharmacyView pharmacyView = new PharmacyView();
            pharmacyView.initView();
            frame.setVisible(false);
        });
        distributorButton.addActionListener(e -> {
            DistributorView distributorView = new DistributorView();
            distributorView.initView();
            frame.setVisible(false);
        });

        frame.setVisible(true);
    }
}
