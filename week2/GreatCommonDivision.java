package week2;

public class GreatCommonDivision {

	public static int gcd(int a, int b) {
		if(b==0) return a;
		int new_a = a%b;
		
		return gcd(b, new_a);
	}
	public static void main(String[] args) {
		System.out.println(gcd(357,234));

	}

}
