package highscores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial") 										//serial?

public class HighScoreDialog extends JDialog {
	
	public HighScoreDialog() {
		
		setTitle("Test Application");
		setPreferredSize(new Dimension(200, 400));
		setLocationRelativeTo(null);
		
		Container cp = getContentPane();
		final HighScoreTableModel tableModel = new HighScoreTableModel("String", "Integer");
		JTable table = new JTable(tableModel);
		cp.add(table.getTableHeader(), BorderLayout.NORTH);
		cp.add(table, BorderLayout.CENTER);
		
		final JTextField nameField = new JTextField("A string");
		final JTextField scoreField = new JTextField("0");
		
		JButton button = new JButton("OK");
		button.setVisible(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.addRow(nameField.getText(), Integer.valueOf(scoreField.getText()));
			}
		});
		
		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.add(nameField);
		panel.add(scoreField);
		panel.add(button);
		cp.add(panel, BorderLayout.SOUTH);
		pack();
	}
	
}