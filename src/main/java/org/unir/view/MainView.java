package org.unir.view;

import javax.swing.*;
import java.awt.*;

public class MainView {

    private final String JFRAME_TITLE = "Main view";
    private final String JBUTTON_PHARMACY = "Pharmacy";
    private final String JBUTTON_DISTRIBUTOR = "Distributor";

    public static MainView instance;
    JFrame frame;

    private void initView () {
        frame = new JFrame(JFRAME_TITLE);
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
            PharmacyView pharmacyView = PharmacyView.getInstance();
            pharmacyView.setVisible(true);
            frame.setVisible(false);
        });
        distributorButton.addActionListener(e -> {
            DistributorView distributorView = DistributorView.getInstance();
            distributorView.setVisible(true);
            frame.setVisible(false);
        });

        frame.setVisible(true);
    }

    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
            instance.initView();
        }
        return instance;
    }

    public void setVisible (boolean visible) {
        this.frame.setVisible(visible);
    }
}
