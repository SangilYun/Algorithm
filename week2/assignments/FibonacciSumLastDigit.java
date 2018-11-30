//package week2.assignments;
import java.util.*;

public class FibonacciSumLastDigit {
    
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
    
    public static long FibonacciSumLastDigit(HashMap<Integer, Long> pattern, long n){
    	int length = pattern.size();
    	int patternSum=0;
    	int remainderSum=0;
    	long quotient = n/length;
    	long remainder = n%length;
    	
    	for(int i=0; i<pattern.size();i++) {
    		patternSum+=pattern.get(i);
    		if(i==remainder) {
    			remainderSum=patternSum;
    		}
    	}
    	
    	long sum = ((patternSum%10) * (quotient%10) + remainderSum)%10;
    	
    	
    	return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        long s = getFibonacciSumNaive(n);
        HashMap<Integer, Long> pattern =fibPattern(n, 10);
//        System.out.println(pattern +"\nsize : " + pattern.size());
        long s=FibonacciSumLastDigit(pattern , n);
        System.out.println(s);
        scanner.close();
    }
}

