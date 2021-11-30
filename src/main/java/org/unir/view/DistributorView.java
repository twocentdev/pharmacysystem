package org.unir.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.unir.core.Order;
import org.unir.core.OrderCollection;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DistributorView extends JFrame {

    private final String JBUTTON_DELIVER = "Deliver";
    private final String JBUTTON_CANCEL = "Cancel";
    private final String JBUTTON_BACK = "Back";
    
	private static DistributorView instance;
	private JPanel contentPane;
    JList <Order> listOrders;

	public DistributorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelForm = new JPanel();
		contentPane.add(panelForm, BorderLayout.CENTER);
		panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
		
		JPanel panelList = new JPanel();
		panelForm.add(panelList);

        listOrders = new JList<Order>();
        panelList.add(listOrders);
		
		JPanel panelActionButtons = new JPanel();
        panelActionButtons.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panelForm.add(panelActionButtons);
		
		JButton deliver = new JButton(JBUTTON_DELIVER);
		deliver.addActionListener( e -> {
				System.out.println("Deliver button has been clicked.");
				Order order = listOrders.getSelectedValue();
				OrderCollection.getInstance();
				OrderCollection.getCollection().remove(order);
				System.out.println(String.format(
						"The order %s has been delivered.",
						order.toString()
				));
				loadData();
		});
		panelActionButtons.add(deliver);
		
		JButton cancel = new JButton(JBUTTON_CANCEL);
		cancel.addActionListener( e -> {
				System.out.println("Cancel button has been clicked.");
				Order order = listOrders.getSelectedValue();
				OrderCollection.getInstance();
				OrderCollection.getCollection().remove(order);
				System.out.println(String.format(
						"The order %s has been cancelled.",
						order.toString()
				));
				loadData();
		});
		panelActionButtons.add(cancel);
		
		JPanel panelNav = new JPanel();
		contentPane.add(panelNav, BorderLayout.SOUTH);
		
		JButton back = new JButton(JBUTTON_BACK);
		back.addActionListener ( e -> {
			System.out.println("Back button has been clicked.");
			setVisible(false);
			MainView view = MainView.getInstance();
			view.setVisible(true);
		});
		panelNav.add(back);
		this.loadData();
	}
	
	public static DistributorView getInstance () {
		if (instance == null) {
			instance = new DistributorView ();
		}
		return instance;
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
	
	@Override
	public void setVisible (boolean visible) {
		if (visible) {
			this.loadData();
		}
		super.setVisible(visible);
	}

}
