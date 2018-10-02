package controllers;

import models.Game;
import models.Code;
import utils.IO;

public class RandomPutController extends PutController {

	public RandomPutController(Game game) {
		super(game);
	}

	@Override
	protected Code selectTarget(String title) {
		Code guess = new Code();
		guess.newCodeSecret();
		new IO().writeln(" " + title + " " + guess.getvalue());
		return guess;
	}

}
