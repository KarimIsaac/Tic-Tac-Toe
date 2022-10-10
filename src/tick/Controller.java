package MVC;

public class Controller {

	View view;
	Board board;
	RuleEngine ruleEngine;


	public Controller() {

		board = new Board();
		view = new View(this, board.getRows(), board.getcols());
	}

	public void unitClicked(int row, int col) {

		if(board.isFull() || board.win) {
			reset();
			board.resetBoard();
		}
		
		board.move(row, col);
		view.setButtonText(row, col, board.getCordinate(row, col));
		view.setLableText("player " + (board.playerTurn()+1) + "'s turn");
		
		if(board.win == true){
			view.setLableText("Winner");
		}

	}

	public void reset() {

		for(int r = 0; r < board.getRows(); r++)
			for(int c = 0; c < board.getcols(); c++) {
				view.setButtonText(r, c, 0);
			}
	}

}


