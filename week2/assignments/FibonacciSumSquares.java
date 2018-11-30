//package week2.assignments;

import java.util.*;

public class FibonacciSumSquares {
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
    
    public static long patternSum(HashMap<Integer, Long> pattern) {
    	long patternSum=0;
    	for(long each : pattern.keySet()) {
    		patternSum+=each;
    	}
    	return patternSum;
    }
    
    //We can make this program faster by get rid of duplicate calculations.
    //when calculate up to n which is larger number, we can save sum up to m-1 in the way.
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
    
    public static long FibonacciPartialSum(long m, long n) {
    	HashMap<Integer, Long> pattern= fibPattern(n, 10);
    	long mSum = FibonacciSumLastDigit(pattern, m-1);
    	long nSum = FibonacciSumLastDigit(pattern, n);
    	
    	if(nSum<mSum) nSum+=10; //when n=0 and m=8 it should be 10-8 not |0-8|
//    	System.out.println("nSum : "+ nSum +", mSum : "+ mSum);
    	long partialSum = nSum-mSum;
    	
    	return partialSum;
    }
    
    public static long FibonacciSumSquares(long n) {
    	long fb_n = FibonacciPartialSum(n,n);
    	long fb_n_1 = FibonacciPartialSum(n+1,n+1);
//    	System.out.println("fib_n : " + fb_n + ", fib_n-1 : " + fb_n_1);
    	return (fb_n_1* fb_n)%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        long s = getFibonacciSumSquaresNaive(n);
        long s = FibonacciSumSquares(n);
        System.out.println(s);
        scanner.close();
    }
}

