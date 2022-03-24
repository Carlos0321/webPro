package singleton2;
// 싱글톤은 private먼저 만들어야 new를 못하게 만들어야 한다. 
public class SingletonClass {
	private int i=10;
	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
//		if(INSTANCE == null) {
//			INSTANCE = new SingletonClass();
//		}
		return INSTANCE;
	}
	private SingletonClass() {}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
