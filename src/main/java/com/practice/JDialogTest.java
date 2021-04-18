package com.practice;

import java.awt.Container;
import java.math.BigDecimal;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JDialogTest extends JDialog {
	
	Object[][] data = {{"1SB234", new BigDecimal(546456.6), BigDecimal.ZERO},
			{"2SB234", new BigDecimal(82337.2743), BigDecimal.ZERO},
			{"3SB334", new BigDecimal(332796.1637), BigDecimal.ZERO}};
	String[] columnNames = {"Deal Id", "Quantity", "Utilization"};
	
 	
	public JDialogTest() {
		JTable table = new JTable(data, columnNames);
		JScrollPane scroller = new JScrollPane(table);
		Container container = getContentPane();
		table.setShowGrid(true);
		container.setLayout(null);
		container.add(scroller);
		scroller.setBounds(5, 5, 600, 500);
		setSize(800, 700);
		setVisible(true);
		setTitle("Table Dialog");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		JDialogTest test = new JDialogTest();
	}

}
