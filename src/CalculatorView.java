import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CalculatorView extends JFrame implements ActionListener{
	JTextArea area;
	JTextField input;
	Calculator calc;
	public static void main(String[] args){
		new CalculatorView();

	}
	public CalculatorView(){
		super("Calculator");
		setSize(new Dimension(400,400));
		setLayout(new BorderLayout());
		initializeComponents();
		setVisible(true);

	}
	public void initializeComponents(){
		calc = new Calculator();
		area = new JTextArea(20,15);
		input = new JTextField(15);
		area.setEditable(false);
		area.setLineWrap(true);
		input.addActionListener(this);
		JScrollPane pane = new JScrollPane(area);
		add(pane, BorderLayout.NORTH);
		add(input, BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == input){
			area.setText(area.getText() + "\n" + input.getText() + "\n" + calc.calculate(input.getText()));
			input.setText("");

		}

	}
}
