package controllers;

import models.Code;
import models.Game;
import models.State;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	public abstract void control();
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	protected void createKey() {
		game.createKey();
	}

	protected void clear() {
		game.clear();
	}

	protected Game getGame(){
		return game;
	}
	protected boolean completeDead() {
		return game.completeDead();
	}

	protected void put(Code secretCode) {
		game.put(secretCode);
	}

	protected void comparator() {
		game.comparator();
	}
	
	protected boolean validate(Code code) {
		return game.validate(code);
	}

	protected int countAttemps() {
		return game.countAttemps();
	}
	protected int countDead() {
		return game.countDead();
	}

	
	
}
