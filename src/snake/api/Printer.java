package snake.api;

public class Printer {
	
	private int num;
	
	public Printer() {
		num = 0;
	}
	public void print(String str) {
		num += str.length();
		System.out.println(str);
	}
	
	public void print(int n) {
		String str = String.valueOf(n);
		num += str.length();
		System.out.println(str);
	}
	
	public void clear() {
		for(int i = 0; i < num; i++) {
			System.out.println("\b");
		}
		num = 0;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
