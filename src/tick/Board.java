package MVC;

public class Board {

	View view;
	RuleEngine ruleEngine;
	Player players;

	int rows = 3;
	int cols = 3;
	int[][] board = new int[rows][cols];
	int playerTurn = 0;
	int numOfPlay = 0;
	boolean win;


	public Board() {

		ruleEngine = new RuleEngine(this);
		players = new Player(this);

	}

	public int getRows() {return rows;}
	public int getcols() {return cols;}
	public int getCordinate(int row, int col) {return board[row][col];}

	public void updateBoard(int row, int col, int player) {
		board[row][col] = player;

	}

	public int numOfPlayers() {

		return players.getPlayers();
	}
	
	public int playerTurn() {

		return playerTurn = playerTurn % numOfPlayers();
	}
	
	public void move(int rows, int cols) {

		if(ruleEngine.checkMove(rows, cols)) {
			playerTurn = playerTurn % numOfPlayers() + 1;
			updateBoard(rows,cols, (playerTurn));			

			if(ruleEngine.checkWin(playerTurn)) {
				win = true;
			}

		}
		
	}

	public void resetBoard() {
		for(int r = 0; r < getRows(); r++)
			for(int c = 0; c < getcols(); c++)
				board[r][c] = 0;

		win = false;
	}

	public boolean isFull(){

		boolean isFull = true;
		for(int r = 0; r < getRows(); r++)
			for(int c = 0; c < getcols(); c++) {
				if(board[r][c] == 0) {
					isFull = false;
				}
			}
		return isFull;
	}








}
