//package week2.assignments;

import java.util.HashMap;
import java.util.Scanner;

public class FibonacciHuge {

 public static HashMap<Integer, Long> fibPattern(long n, long m) {
    	HashMap<Integer, Long> fibMap=new HashMap<>();
    	HashMap<Integer, Long> pattern=new HashMap<>();
    	fibMap.put(0, 0L);
    	fibMap.put(1, 1L);
    	pattern.putAll(fibMap);

    	int i=2;
    	while(true) {
    		fibMap.put(i, (fibMap.get(i-2)%m + fibMap.get(i-1)%m) %m);
    		if (fibMap.get(i)==0 && pattern.get(pattern.size()-1)==1){
    			break;
    		}else {
    			pattern.put(i, fibMap.get(i));
    		}
    		i++;
    	}
    	return pattern;
    }
    
    public static long FibonacciHuge(long n, long m) {
    	HashMap<Integer, Long> pattern = fibPattern(n, m);
    	long remainder = n % pattern.size();
    	long retNum = pattern.get((int)remainder); 
    	return retNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
//        HashMap<Integer, Long> al = fibPattern(n, m);
//        System.out.println(al+"\nsize : " +al.size());
        System.out.println(FibonacciHuge(n,m));
        scanner.close();
    }
}

