package utils;

public class LimitedStringtDialog {

	private String title;
	
	private MaxLength maxlegth;
	
	public LimitedStringtDialog(String title, int max){
		assert title != null;
		this.maxlegth = new MaxLength(max);
		this.title = title + "";
	}
	
	
	public String read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = maxlegth.includes(value.length());
			if (!ok) {
				io.writeln("Debe ingresar: "+maxlegth+" Valores");
			}
		} while (!ok);
		return value;
	}

}
