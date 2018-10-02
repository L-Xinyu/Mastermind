package models;

public class Game {

	private State state;
	private Board board;
	
	public Game() {
		state = State.INITIAL;
		board = new Board();
		
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public void clear() {
		board.clear();
	}
	
	public void createKey() {
		board.createKey();
	}
	public boolean validate(Code secretCode) {
		return board.validate(secretCode);
	}

	public boolean completeDead() {
		return board.completDead();
	}
	
	public void put(Code secretCode) {
		board.put(secretCode);
	}
	
	public void comparator() {
		board.comparator();
	}
	public int countAttemps() {
		return board.countAttemps();
	}
	public int countDead() {
		return board.countDead();
	}
	
}
	