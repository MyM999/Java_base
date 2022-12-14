package step01;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/* web 브라우저
 * 	client 입력 없이 enter
 * 		"" 형식으로 서버에 전송하는 구조
 * 		개발하는 경우의 수 1 : 브라우저 처리 개발 언어에서 js로 입력여부 검증
 * 			"		   2 : 서버에서 우선 받고 서버 개발 언어인 자바에서 입력여부 검증
 * 					   3 : js 및 java or python 모른다
 * 							sql로 db에 insert시에 문제 발생
 * 			....  */
public class StreamAPI6 {

	public static void main(String[] args) {

		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		
		System.out.println("-- 1 --");
		long count = strList.stream().filter(x -> x.isEmpty()).count();
		System.out.printf("List %s has %d empty strings %n", strList, count);
		
		System.out.println("-- 2 --");
		long num = strList.stream().filter(x -> x.length() > 3).count();
		System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);
		
		System.out.println("-- 3 --");
		count = strList.stream().filter(x -> x.startsWith("a")).count();
		System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);
		
		System.out.println("-- 4 --");
		List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.printf("Original List : %s, List without Empty Strings : %s %n", strList, filtered);
		
		System.out.println("-- 5 --");
		filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
		
		System.out.println("-- 6 --");
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);
		
		System.out.println("-- 7 --");
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);
		
		List<Integer> data = numbers.stream().map(i -> i*i).collect(Collectors.toList());
		System.out.printf("--- distince() 없이 %s - %s %n", numbers, data);
		
		
		System.out.println("-- 8 --");
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(stats); 
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());

	}

}