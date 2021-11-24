package org.unir.view;

import javax.swing.*;
import java.awt.*;

public class DistributorView {

    private final String JFRAME_TITLE = "Distributor view";
    private final String JBUTTON_BACK = "Back";

    public void initView () {
        JFrame frame = new JFrame(JFRAME_TITLE);
        JPanel panel = new JPanel();
        JButton back = new JButton(JBUTTON_BACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(panel);

        panel.setLayout(new FlowLayout());
        panel.add(back);

        back.addActionListener( e -> {
            MainView mainView = new MainView();
            mainView.initView();
            frame.setVisible(false);
        });

        frame.setVisible(true);
    }
}
