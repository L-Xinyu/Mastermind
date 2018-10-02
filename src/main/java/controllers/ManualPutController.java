package controllers;

import models.Game;
import models.Code;


public class ManualPutController extends PutController{

	public ManualPutController(Game game) {
		super(game);
	}

	@Override
	protected Code selectTarget(String title) {
		Code guess = new Code();
	    guess.read(title);
		
		return guess;
	}

}
