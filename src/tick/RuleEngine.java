package MVC;

public class RuleEngine {

	View view;
	Controller controller;
	Board board;

	public RuleEngine(Board board) {
		this.board = board;
	}


	public boolean checkWin(int player) {

		int row = board.getRows();
		int col = board.getcols();
		boolean win;

		//check rows
		for(int r = 0; r < row; r++) {
			win=true;
			for(int c = 0; c < col; c++) {
				if(board.getCordinate(r, c) != player) {
					win = false;
				}
			}
			if(win == true) return win;

		}
		
		//check cols
		for(int c = 0; c < col; c++) {
			win = true;
			for(int r = 0; r < row; r++) {
				if(board.getCordinate(r, c) != player) {
					win = false;
				}
			}
			if(win == true) return win;

		}

		//check right diagonals 
		win=true;
		for(int r = 0; r < row; r++) {
			if(board.getCordinate(r, r) != player) {
				win = false;
			}
		}
		if(win == true) return win;

		
		//check left diagonals
		win=true;
		for(int r = 0; r < row; r++) {
			if(board.getCordinate(r, row-r-1) != player) {
				win = false;
			}
		}
		if(win == true) return win;

		return false;

	}

	public boolean checkMove(int rows, int cols) {

		if(board.getCordinate(rows, cols) == 0) {
			return true;
		}
		else return false;		
	}
}
