package org.unir.view;

import org.unir.core.*;
import org.unir.util.Util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class PharmacyView {

    private final String JFRAME_TITLE = "Pharmacy view";
    private final String JBUTTON_SUBMIT = "Submit";
    private final String JBUTTON_CLEAR = "Clear";
    private final String JBUTTON_BACK = "Back";
    private final String JLABEL_FIELD_NAME = "Name: ";
    private final String JLABEL_FIELD_TYPE = "Type: ";
    private final String JLABEL_FIELD_AMOUNT = "Amount: ";
    private final String JLABEL_FIELD_DISTRIBUTOR = "Distributor: ";
    private final String JLABEL_FIELD_DIRECTIONS = "Directions: ";
    private final String JLABEL_DIR_1 = "Calle de la Rosa 28";
    private final String JLABEL_DIR_2 = "Calle Alcazabilla 3";
    private final int JTEXTFIELD_WIDTH = 15;

    public static PharmacyView instance;
    JFrame frame;

    private void initView () {
        frame = new JFrame(JFRAME_TITLE);
        JPanel panelMain = new JPanel();
        JPanel panelForm = new JPanel();
        JPanel panelNav = new JPanel();
        JPanel panelFieldName = new JPanel();
        JPanel panelFieldType = new JPanel();
        JPanel panelFieldAmount = new JPanel();
        JPanel panelFieldDistributor = new JPanel();
        JPanel panelFieldDirections = new JPanel();
        JPanel panelActionButtons = new JPanel();
        JLabel labelFieldName = new JLabel(JLABEL_FIELD_NAME);
        JLabel labelFieldType = new JLabel(JLABEL_FIELD_TYPE);
        JLabel labelFieldAmount = new JLabel(JLABEL_FIELD_AMOUNT);
        JLabel labelFieldDistributor = new JLabel(JLABEL_FIELD_DISTRIBUTOR);
        JLabel labelFieldDirections = new JLabel(JLABEL_FIELD_DIRECTIONS);
        JTextField textFieldName = new JTextField(JTEXTFIELD_WIDTH);
        JComboBox fieldType = new JComboBox();
        JTextField textFieldAmount = new JTextField(JTEXTFIELD_WIDTH);
        ButtonGroup fieldDistributor = new ButtonGroup();
        JCheckBox direction1 = new JCheckBox(JLABEL_DIR_1);
        JCheckBox direction2 = new JCheckBox(JLABEL_DIR_2);
        JButton submit = new JButton(JBUTTON_SUBMIT);
        JButton clear = new JButton(JBUTTON_CLEAR);
        JButton back = new JButton(JBUTTON_BACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().add(panelMain);

        panelMain.setLayout(new BorderLayout());
        panelMain.add(panelForm, BorderLayout.CENTER);
        panelMain.add(panelNav, BorderLayout.PAGE_END);

        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
        panelForm.add(panelFieldName);
        panelForm.add(panelFieldType);
        panelForm.add(panelFieldAmount);
        panelForm.add(panelFieldDistributor);
        panelForm.add(panelFieldDirections);
        panelForm.add(panelActionButtons);

        panelFieldName.setLayout(new FlowLayout());
        panelFieldName.add(labelFieldName);
        panelFieldName.add(textFieldName);

        panelFieldType.setLayout(new FlowLayout());
        panelFieldType.add(labelFieldType);
        panelFieldType.add(fieldType);
        for (MedicineEnum medicine: MedicineEnum.values()) {
            fieldType.addItem(medicine.getMedicineName());
        }

        panelFieldAmount.setLayout(new FlowLayout());
        panelFieldAmount.add(labelFieldAmount);
        panelFieldAmount.add(textFieldAmount);

        panelFieldDistributor.setLayout(new FlowLayout());
        panelFieldDistributor.add(labelFieldDistributor);
        for (DistributorEnum distributor: DistributorEnum.values()) {
            JRadioButton radioButton = new JRadioButton(distributor.getDistributorName());
            radioButton.setActionCommand(distributor.getDistributorName());
            fieldDistributor.add(radioButton);
            panelFieldDistributor.add(radioButton);
        }

        panelFieldDirections.setLayout(new FlowLayout());
        panelFieldDirections.add(labelFieldDirections);
        panelFieldDirections.add(direction1);
        panelFieldDirections.add(direction2);

        direction1.setActionCommand(JLABEL_DIR_1);
        direction2.setActionCommand(JLABEL_DIR_2);

        panelActionButtons.setLayout(new FlowLayout());
        panelActionButtons.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panelActionButtons.add(submit);
        panelActionButtons.add(clear);

        panelNav.setLayout(new FlowLayout());
        panelNav.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panelNav.add(back);

        submit.addActionListener( e -> {
            List<String> directions = new ArrayList<String> ();
            if (direction1.isSelected()) {
                directions.add(direction1.getText());
            }
            if (direction2.isSelected()) {
                directions.add(direction2.getText());
            }
            OrderFactory factory = OrderFactory.getInstance();
            try {
                Order order = factory.create(
                    (textFieldName.getText() == null) ? null : textFieldName.getText(),
                    (fieldType.getSelectedItem() == null)? null : fieldType.getSelectedItem().toString(),
                    Util.parseInt(textFieldAmount.getText()),
                    (fieldDistributor.getSelection() == null)? null : fieldDistributor.getSelection().getActionCommand(),
                    directions
                );
                System.out.println(order);
                JDialog orderDialog = new JDialog();
                orderDialog.setLayout(new FlowLayout());
                orderDialog.setSize(500, 100);
                orderDialog.add(new JLabel(order.toString()));
                orderDialog.setVisible(true);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                JDialog alertDialog = new JDialog();
                alertDialog.setLayout(new FlowLayout());
                alertDialog.setSize(500, 100);
                alertDialog.add(new JLabel( ex.getMessage()));
                alertDialog.setVisible(true);
            } finally {
                clear.doClick();
            }
        });
        clear.addActionListener( e -> {
            textFieldName.setText(null);
            fieldType.setSelectedIndex(0);
            textFieldAmount.setText(null);
            fieldDistributor.clearSelection();
            direction1.setSelected(false);
            direction2.setSelected(false);
        });
        back.addActionListener( e -> {
            MainView mainView = MainView.getInstance();
            mainView.setVisible(true);
            frame.setVisible(false);
        });

        frame.setVisible(true);
    }

    public static PharmacyView getInstance() {
        if (instance == null) {
            instance = new PharmacyView();
            instance.initView();
        }
        return instance;
    }

    public void setVisible (boolean visible) {
        this.frame.setVisible(visible);
    }
}
