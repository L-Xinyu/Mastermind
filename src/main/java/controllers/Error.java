package controllers;

public enum Error {
	
	NOT_VALIDATE("Error!");
	
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}

}
