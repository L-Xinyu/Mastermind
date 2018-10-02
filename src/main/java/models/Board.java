package models;

import utils.IO;
import java.util.ArrayList;
import java.util.List;

public class Board {

	
	private Code key;
	
	private List<Code> guess;
	
	public Board() {
		this.guess= new ArrayList();
	}
	
	public void createKey() {
		this.key = new Code();
		this.key.newCodeSecret();
	
		new IO().writeln("Secreto : " + this.key.getvalue());
	}
	
	public void put(Code guess) {
		assert guess != null;
		this.guess.add(guess);
	}
	public int countDead() {
		int count = 0;
		for (int i = 0; i < Code.DIMENSION; i++) {
			if (this.key.split()[i].equals(this.guess.get(this.guess.size() - 1).split()[i])) {
				count++;
			}
		}

		return count;
	}

	public int countInjured() {
		int coutWounded = 0;
		for (String letterUnique : key.listUnique()) {
			double appearanceKey = key.filterLetter(letterUnique);
			double appearanceGuess = this.guess.get(this.guess.size() - 1).filterLetter(letterUnique);
			coutWounded += Math.min(appearanceKey, appearanceGuess);
		}
		return (int) coutWounded - this.countDead();
	}

	
	public void comparator(){
		new IO().writeln("Muertos: " + this.countDead() + " Heridos: " + this.countInjured() + "");
	}

	public boolean completDead() {
		if (this.countDead()== Code.DIMENSION) {
			return true;
		}
		return false;

	}

	public void clear() {
		this.guess.clear();
	}
	
	public int countAttemps() {
		return guess.size();
	}
	public boolean validate(Code code){
		String[] value=code.split();
		for (int i = 0; i < value.length; i++) {
			if (this.isColor(value[i])!=true){
					return false;						
				}
			}
		return true;
	}

	public boolean isColor(String value){
		assert value!=null;
		for ( Color color : Color.values()){
			  if (color.toString().equals(value)) {
				  return true;
			}
		}
			  return false;
	}
	
	
}
