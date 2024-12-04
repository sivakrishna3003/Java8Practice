package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.Interf;

@RestController
public class TestJava8 {
	
	@GetMapping("/")
	public String shiva(){

		/*
		 * Default and static method example
		 */
		Interf f = () -> System.out.println("Implemented m1()");
		f.m1();
		f.m2(0);
		System.out.println(f.toString());
		Interf.m3();
		
		/*
		 * Predicate function with lamda expression
		 * Predicate always return boolean value and Predicate takes single input and biPredicate takes double inputs
		 */
		Predicate<Integer> p=i->i%2==0;
		System.out.println(p.test(10));
	
		
		int[] x= {0,5,1,11,15,43,20};
//		Predicate<Integer> p1=i->i%2==0;
		IntPredicate p1=i->i%2==0; // above line and this one is same purpose only but here we are using only int values not Integer that's why taken IntPredicate because of this autoboxing and autounboxing time will save.
		for (int x1 : x) {
			if (p1.test(x1))
				System.out.println("x1: " + x1);

		}
		
		
		/*
		 * If we want to return any value boolean,int and string ...etc then we will use function 
		 *
		 */
		Function<Integer,Integer> fun=i->i*1;
		System.out.println(fun.apply(4));
		
		
		UnaryOperator<Integer> un=i->i*i; //If input and output is same type then we can to UnaryOperator
		System.out.println(un.apply(4));
		
		IntUnaryOperator iu=i->i*i;
		System.out.println(iu.applyAsInt(4));
		
		
		
		/*
		 * Streams concept	
		 */
		System.out.println("======start streams======");
		ArrayList<Integer> ar=new ArrayList<>();
		ar.add(50);
		ar.add(25);
		ar.add(30);
		ar.add(2);
		ar.add(100);
		System.out.println(ar);
		List<Integer> l=ar.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("FilterStream: "+l);
		
		List<Integer> collect = ar.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println("MapStream: "+collect);
		
		long count = ar.stream().count();
		System.out.println("CountStream: "+count);
		
		
		List<Integer> sorted = ar.stream().sorted().collect(Collectors.toList());
		System.out.println("DefaultSortedStream: "+sorted);
		
		List<Integer> collect2 = ar.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println("AscendingSortedStream: "+collect2);
		
//		List<Integer> collect3 = ar.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList());
		List<Integer> collect3 = ar.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
		
		System.out.println("DecendingSortedStream: "+collect3);
		
		Integer oi=ar.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Max in decending: "+oi);
		
		Integer integer = ar.stream().max((i1, i2) -> i2.compareTo(i1)).get();
		System.out.println("Max in acending order: " + integer);

		ar.stream().forEach(i -> {
			System.out.println(i + " Square root of input value is:" + (i * i));
		});

		Integer[] intArray= {10,20,30,40,50};
		Stream.of(intArray).forEach(System.out::println);
		
		System.out.println("======end streams======");
		
		
		
		/*
		 * Date and time concepts
		 */
		System.out.println("========Start date and time=====");
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println("Current date and time: "+ldt);
		System.out.println("Plus days: "+ldt.plusDays(10));
		System.out.println("Plus months: "+ldt.plusMonths(2));
		
		System.out.println("========End date and time=====");
		
		
		
		return "Welcome to java 8 features";
	}
	
	
	private boolean add(int a,int b){
		return true;
	}
}
