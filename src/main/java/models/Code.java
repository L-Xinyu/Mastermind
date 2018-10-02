package models;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import utils.LimitedStringtDialog;

public class Code {
	
	public static final int DIMENSION = 4;
	private String value;
	
	 public String getvalue(){
		 return value;
	 }
	 
	 public void read(String title) {
			assert title != null;
			this.value = new LimitedStringtDialog(title,Code.DIMENSION).read();
		}
	 	 
	 public void newCodeSecret() {
		 	String key="";
			Random random = new Random();
			for(int i=0 ; i < DIMENSION ; i++){
				key+=Color.values()[random.nextInt(Color.values().length)];
				
			}
			this.value=key;
		}
	 
	 public String[] split() {
			String[] value = this.value.split("");
			return value;
		}
	 public HashSet<String> listUnique() {
			HashSet<String> guess = new HashSet<String>();
			guess.addAll(Arrays.asList(this.split()));
			return guess;
		}
	
	 public double filterLetter(String guess) {
			assert guess != null;
			return this.value.chars().filter(val -> val == guess.charAt(0)).count();
		}
	 
}
