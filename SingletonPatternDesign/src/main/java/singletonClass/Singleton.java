package singletonClass;

public class Singleton {

	// -> In OOP, a singleton class can have only one object (instance of the class) at
	// a time.
	// -> How to design singleton class:
	//   1) make constructor as private
	//   2) write a static method (getInstance) that has a return type of the object of this
	//      singleton class (Lazy Initialization)
	//   3) Lazy Initialization

	private static Singleton singleton_instance = null;

	public String str;

	private Singleton() {
		str = "***** I am using the singleton class pattern *****";
	}

	// ----- Lazy Initialization -----
	public static Singleton getInstance() {
		if (singleton_instance == null)
			singleton_instance = new Singleton();
		return singleton_instance;
	}

	public static void main(String[] args) {
		// - 3 references I have created and 3 times I'm calling the 'getInstance'
		// method
		// - Instantiating Singleton class with variables x, y, and z
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();

		// 'x.str' will return a String
		// 'x.str' will be converted to Upper Case
		// 'x.str' is again stored in 'x.str'
		x.str = (x.str).toUpperCase();

		// -> All 3 references (x,y,z) have the same return statement because all 3 are
		// pointing to the same object.
		// -> If I make any changes to 'x' then both 'y' and 'z' will be affected because
		// they are pointing to the same object.
		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);

		(z.str) = (z.str).toLowerCase();

		// -> If I make changes to 'z' then both 'y' and 'z' will be affected because
		// they are pointed to the same object AND this is known as 'Single Pattern'.
		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);
	}

}
