package controllers;

import models.Game;
import models.State;
import utils.LimitedIntDialog;

public class StartController extends OperationController {

	private PutController putController;

	protected StartController(Game game) {
		super(game);
	}

	public void control() {
		assert this.getState() == State.INITIAL;
		int mode = new LimitedIntDialog("Select one:1.Partida  \n 2. Demo \n choose?: ", 1,2).read();
		if (mode == 1) {
			putController = new ManualPutController(this.getGame());
		} else {
			putController = new RandomPutController(this.getGame());
		}
		this.createKey();
		this.setState(State.IN_GAME);
	}

	public PutController getPutController() {
		return putController;
	}

}

