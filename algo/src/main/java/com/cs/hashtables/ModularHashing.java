package com.cs.hashtables;

import edu.princeton.cs.algs4.In;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ModularHashing {
	static final int MODULO_100 = 100;
	static final int MODULO_PRIME = 97;
	public static void main (String[] args) {
		/**
		 * Read keys from a file and find their hash based on
		 * a) Prime
		 * b) Non-prime
		 */
		ModularHashing instance = new ModularHashing();
		instance.readInput();
	}
	
	private void readInput(){
		In fileInput = new In(Objects.requireNonNull(getClass().getClassLoader().getResource("keys.txt")));
		String [] numbers = fileInput.readAllStrings();
//		System.out.println(Arrays.toString(numbers));
		List<CustomPrint> list = new ArrayList<>();
		
		CustomPrint row;
		for(String s : numbers){
			int number = Integer.parseInt(s);
			int hashM100 = computeHash(number, MODULO_100);
			int hashMPrime = computeHash(number, MODULO_PRIME);
			row = new CustomPrint(number, hashM100, hashMPrime);
			list.add(row);
		}
		System.out.println("Key     hash(M=100)     hash(M=97)");
		printList(list);
	}
	
	private void printList(List<CustomPrint> result){
		result
		.forEach(x-> System.out.format("%-7s %-15s %s%n",x.getKey(), x.getHashM100(),
		x.getHashMPrime()));
	}
	private int computeHash(int number, int modulo){
		return number % modulo;
	}
	
	@Data
	static class CustomPrint{
		int key;
		int hashM100;
		int hashMPrime;
		
		CustomPrint(int key, int aHashM100, int aHashMPrime){
			this.key = key;
			this.hashM100 = aHashM100;
			this.hashMPrime = aHashMPrime;
		}
	}
}
