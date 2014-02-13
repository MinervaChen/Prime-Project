//Minerva Chen
//University of Washington, Junior
//chenxminerva@gmail.com

//This program tests whether a number is prime and sums all prime numbers
//from one to 2 million with one un-optimized version and one optimized version

import java.util.*;
public class primes{
	public static final int MAX = 2000000;
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Please type in a number to test: ");
		int num = console.nextInt();
		System.out.println();
		
		long startTime = System.nanoTime();
		report(true, num);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Optimized Operations took " + (double) duration/1000000000 + 
		" seconds to execute");
		System.out.println();
		long startTime2 = System.nanoTime();
		report(false, num);
		long endTime2 = System.nanoTime();
		long duration2 = endTime2 - startTime2;
		System.out.println("Un-optimized Operations took about " + duration2/1000000000 + 
		" seconds to execute");
	}
	
	//reports whether or not the number is prime
	//reports sum of primes from 1 to MAX
	public static void report(boolean optimize, int num){
		if(optimize){
			boolean tracker[] = primes_optimized(); 
			System.out.println("Step One Optimized: Is " + num + " a prime number? " + tracker[num]);
			System.out.println("Step Two Optimized: The sum of all prime numbers from 1 to " + MAX + " is "
			+ sum_prime_optimized(tracker));

		} else {
			System.out.println("Step One Un-optimized: Is " + num + " a prime number? " + is_prime_unopt(num));
			System.out.println("Step Two Un-optimized: The sum of all numbers from 1 to " + MAX + " is "  
		 	+ sum_prime_unoptimized());
		}	
	}
		
	//returns collection of which numbers from 1 to MAX are prime
	//implements algorithm: Sieve of Eratosthenes
	//does not check numbers that are a multiple of an existing
	//number
	public static boolean[] primes_optimized(){
		boolean tracker[] = new boolean[MAX + 1];
		Arrays.fill(tracker, true);
		for(int i = 2; i <= Math.sqrt(MAX); i++){
			if(tracker[i]){ //all multiples of primes declared false
				for(int j = 2; j * i <= MAX; j++){
					tracker[j * i] = false;
				}
			}
		}
		return tracker;
	}
	
	//returns true if number is prime
	//implements algorithm: check every number
	//to see if it is prime
	public static boolean is_prime_unopt(int num){
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				return false;
			} 
		}
		return true;
	}

	//returns sum of all prime numbers up to MAX
	public static long sum_prime_unoptimized(){
		long sum = 0;
		for(int i = 2; i <= MAX; i++){
			if(is_prime_unopt(i)){
				sum += i;
			}
		}
		return sum;
	}
	
	//returns sum of all prime numbers up to MAX
	public static long sum_prime_optimized(boolean[] tracker){
		long sum = 0;
			for(int i = 2; i < tracker.length; i++){
				if(tracker[i]){
					sum += i;
				}
			}
		return sum;
	}
}