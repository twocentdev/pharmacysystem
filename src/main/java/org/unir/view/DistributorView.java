package org.unir.view;

import org.unir.core.Order;
import org.unir.core.OrderCollection;

import javax.swing.*;
import java.awt.*;

public class DistributorView {

    private final String JFRAME_TITLE = "Distributor view";
    private final String JBUTTON_BACK = "Back";
    private final String JBUTTON_DELIVER = "Deliver";
    private final String JBUTTON_CANCEL = "Cancel";
    private final String JLABEL_ORDERS = "Pending orders";

    public static DistributorView instance;
    JFrame frame;
    JList <Order> listOrders;

    private void initView () {
        frame = new JFrame(JFRAME_TITLE);
        JPanel panelMain = new JPanel();
        JPanel panelForm = new JPanel();
        JPanel panelNav = new JPanel();
        JPanel panelOrders = new JPanel();
        JPanel panelActionButtons = new JPanel();
        JLabel labelOrders = new JLabel(JLABEL_ORDERS);
        listOrders = new JList<Order>();
//        this.loadData();
        JButton deliver = new JButton(JBUTTON_DELIVER);
        JButton cancel = new JButton(JBUTTON_CANCEL);
        JButton back = new JButton(JBUTTON_BACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(panelMain);

        panelMain.setLayout(new BorderLayout());
        panelMain.add(panelForm, BorderLayout.CENTER);
        panelMain.add(panelNav, BorderLayout.PAGE_END);

        panelForm.setLayout(new BorderLayout());
        panelForm.add(panelOrders, BorderLayout.CENTER);
        panelForm.add(panelActionButtons, BorderLayout.PAGE_END);

        panelOrders.setLayout(new BoxLayout(panelOrders, BoxLayout.PAGE_AXIS));
        panelOrders.add(labelOrders);
        panelOrders.add(listOrders);

        panelActionButtons.setLayout(new FlowLayout());
        panelActionButtons.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panelActionButtons.add(deliver);
        panelActionButtons.add(cancel);

        panelNav.setLayout(new FlowLayout());
        panelNav.add(back);

        listOrders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listOrders.setLayoutOrientation(JList.VERTICAL);
        listOrders.setVisibleRowCount(10);

        deliver.addActionListener( e -> {
            Order order = listOrders.getSelectedValue();
            OrderCollection.getInstance();
            OrderCollection.getCollection().remove(order);
            JDialog orderDialog = new JDialog();
            orderDialog.setLayout(new FlowLayout());
            orderDialog.setSize(500, 100);
            orderDialog.add(new JLabel(
                String.format(
                    "Order %s has been delivered.",
                    order
                )
            ));
            orderDialog.setVisible(true);
//            System.out.println("Deliver button has been clicked");
//            System.out.println(String.format(
//                "Order %s has been delivered.",
//                order
//            ));
            this.loadData();
            this.setVisible(true);
        });
        cancel.addActionListener( e -> {
            Order order = listOrders.getSelectedValue();
            OrderCollection.getInstance();
            OrderCollection.getCollection().remove(order);
            JDialog orderDialog = new JDialog();
            orderDialog.setLayout(new FlowLayout());
            orderDialog.setSize(500, 100);
            orderDialog.add(new JLabel(
                String.format(
                    "Order %s has been cancelled.",
                    order
                )
            ));
            orderDialog.setVisible(true);
//            System.out.println("Cancel button has been clicked.");
//            System.out.println(String.format(
//                "Order %s has been cancelled.",
//                order
//            ));
            this.loadData();
            this.setVisible(true);
        });
        back.addActionListener( e -> {
            MainView mainView = MainView.getInstance();
            mainView.setVisible(true);
            frame.setVisible(false);
        });

        this.loadData();
        frame.setVisible(true);
    }

    public static DistributorView getInstance() {
        if (instance == null) {
            instance = new DistributorView();
            instance.initView();
        }
        return instance;
    }

    public void setVisible (boolean visible) {
        this.loadData();
        this.frame.setVisible(visible);
    }

    private void loadData() {
        OrderCollection.getInstance();
        DefaultListModel<Order> model = new DefaultListModel<Order>();
        for (Order order: OrderCollection.getCollection()) {
            model.add(
                OrderCollection.getCollection().indexOf(order),
                order
            );
        }
        this.listOrders.setModel(model);
    }
}
