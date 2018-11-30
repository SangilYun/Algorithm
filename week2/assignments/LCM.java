//package week2.assignments;

import java.util.*;

public class LCM {
//  private static long lcm_naive(int a, int b) {
//    for (long l = 1; l <= (long) a * b; ++l)
//      if (l % a == 0 && l % b == 0)
//        return l;
//
//    return (long) a * b;
//  }
//  
  private static long GCD(long a, long b) {
	  if(b ==0) {
		  return a;
	  }
	  long new_a = a%b;
	  return GCD(b, new_a);
  }
  
  private static long LCM(int a, int b) {
	  long GCD = GCD(a,b);
	  return (a/GCD)*b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(LCM(a, b));
    scanner.close();
  }
}
