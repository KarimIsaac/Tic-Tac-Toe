package MVC;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class View {

	//private Controller controller;	
	Controller controller;
	JButton buttons[][];
	JLabel myLabel;
	char[] letters = {' ', 'x' , 'o', 'z', 'w'};

	public View(Controller controller, int rows, int cols) {
		
		this.controller = controller;
		buttons = new JButton[rows][cols];
		
		JFrame frame = new JFrame("TerribleTicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel myButtonPanel = new JPanel();

		myButtonPanel.setLayout(new GridLayout(rows,cols));

		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				final int _r = r;
				final int _c = c;
				JButton button = buttons[_r][_c] = new JButton();
				button.setPreferredSize(new Dimension(50, 50));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						controller.unitClicked(_r, _c);
					}
				});
				myButtonPanel.add(button);
			}
		}
		JPanel myTextPanel = new JPanel();
		myTextPanel.setLayout(new GridLayout(rows,cols));
		myTextPanel.setPreferredSize(new Dimension(150,50));
		myLabel = new JLabel("player 1's turn", SwingConstants.CENTER);
		myTextPanel.add(myLabel);

		JPanel myMainPanel = new JPanel();
		myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
		myMainPanel.add(myButtonPanel);
		myMainPanel.add(myTextPanel);

		frame.getContentPane().add(myMainPanel);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	void setButtonText(int r, int c, int player) {
		String text = Character.toString(letters[player]);
        this.buttons[r][c].setText(text);
    }

    void setLableText(String text) {
        myLabel.setText(text);
    }



}
