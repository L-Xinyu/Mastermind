package controllers;

import models.Game;
import models.State;
import models.Code;
import utils.IO;

public abstract class PutController extends OperationController {
	public static final int LIMITEDATTEMPS = 10;
	private Code guess;

	public PutController(Game game) {
		super(game);
		assert game != null;
	}


	public void control() {
		assert this.getState() == State.IN_GAME;
		Error error;
		
		do
		{
			guess = this.selectTarget("Intento ? [Cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul,\r\n"
					+ "B-blanco, N-negro] ");
			error=this.errorValidate(guess);
			 if (error != null){
					new IO().writeln(""+error);
				}
		} while (error != null);
		this.put(guess);
		if (this.completeDead()) {
			this.setState(State.FINAL);
			new IO().writeln(this.countDead()+" Congratulations~~ ");
		} else {
			this.comparator();
			if (this.countAttemps() == PutController.LIMITEDATTEMPS) {
				new IO().writeln("Ha Perdio :( usted realizado: "+LIMITEDATTEMPS+ " intentos");
				new IO().readString("Enter para continuar!");
				this.setState(State.FINAL);
			}
		}
	}

	public Error errorValidate(Code guess) {
		if (!this.validate(guess)) {
			return Error.NOT_VALIDATE;
		}
		return null;
	}
	
	protected abstract Code selectTarget(String title);
		
	
}
