package MVC;

public class Player {

	
	Board board;
	int numOfPlayer = 2;

	public Player(Board board) {
		
		this.board = board;
	}


	public int getPlayers() {

		return numOfPlayer;	
	}

}
