//Minerva Chen
//University of Washington, Junior
//chenxminerva@gmail.com

//This program tests whether a number is prime and sums all prime numbers
//from one to 2 million
import java.util.*;
public class primes{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Step One: Test for prime numbers. Please type in a number to test: ");
		int num = console.nextInt();
		if(is_prime(num)){
			System.out.println("Yes. " + num + " is a prime number"); 
		} else {
			System.out.println("No. " + num + " is not a prime number");
		}
		System.out.println("Step Two: The sum of all numbers from 1 to 2 million is: "
		 + sumPrimeTo(2000000));
	}
	
	//returns true if number is prime
	public static boolean is_prime(int num){
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				return false;
			} 
		}
		return true;
	}
	
	//returns sum of all prime numbers up to x
	public static long sumPrimeTo(int x){
		long total = 0;
		for(int i = 2; i <= x; i++){
			if(is_prime(i)){
				total += i;
			}
		}
		return total;
	}
}