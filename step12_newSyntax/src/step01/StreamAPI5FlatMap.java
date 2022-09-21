package step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamAPI5FlatMap {
//	@Test
	public void step02() {
			
			List cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");
			
			System.out.println("list: " + cards); 
			
			Map cards2Length = (Map) cards.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1)); 
			
			
			List cards2 = Arrays.asList("Visa", "MasterCard", "American Express");
			Map cards2Length2 = (Map) (cards.stream().collect(Collectors.toMap(Function.identity(), String::length)));
			
			System.out.println("map: " + cards2Length);

			
			List cards3 = Arrays.asList("Visa", "MasterCard", "American Express");
			System.out.println(cards3.stream().collect(Collectors.toMap(Function.identity(), (keyName)-> keyName))); //{American Express=American Express, Visa=Visa, MasterCard=MasterCard}
			
			
			cards3 = Arrays.asList("Visa", "MasterCard", "American Express");
			System.out.println(cards3.stream().collect(Collectors.toMap(Function.identity(), String::length, (elementName, length) -> length))); //{American Express=16, Visa=4, MasterCard=10}
	}
	
	
	
	@Test
	public void step01() {
		List<String> teamKorea = Arrays.asList("손홍민", "홍명보", "안정환");
		List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
		List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
		List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
		List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
		List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
		List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
		List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

		//List 타입 내부에 String객체들을 보유한 List가 element로 저장 가능
		List<List<String>> playersInWorldCup2022 = new ArrayList<>();
		
		playersInWorldCup2022.add(teamKorea);
		playersInWorldCup2022.add(teamAustralia);
		playersInWorldCup2022.add(teamEngland);
		playersInWorldCup2022.add(teamNewZeland);
		playersInWorldCup2022.add(teamSouthAfrica);
		playersInWorldCup2022.add(teamWestIndies);
		playersInWorldCup2022.add(teamSriLanka);
		playersInWorldCup2022.add(teamPakistan);
		
		System.out.println(playersInWorldCup2022);
		
		//step01 
//		for(List<String> v : playersInWorldCup2022) {
//			System.out.println(v);  //[손홍민, 홍명보, 안정환] ["Warner", "Watson", "Smith"] ...
//			for(String name : v) {
//				System.out.println(name);
//			}
//		}
		
		/* flatMap()
		 * 	- Stream을 새로운 Stream 객체로 변환 
		 *  
		 *  - playersInWorldCup2022.stream()
		 *  	- Stream<List<String>> java.util.Collection.stream()
		 *  
		 *  - playersInWorldCup2022.stream().flatMap(l -> l.stream())
		 *  	-  Stream<String> java.util.stream.Stream.flatMap()
		 *  
		 *  -  playersInWorldCup2022.stream().flatMap(l -> l.stream()).collect()
		 *  	-  List<String> java.util.stream.Stream.collect()

		 *  
		 *  [[손홍민, 홍명보, 안정환], [Warner, Watson, Smith], [Alex, Bell, Broad], [Kane, Nathan, Vettori], ..
		 *  
		 */
		
		//step02
		System.out.println(playersInWorldCup2022.stream().flatMap(l -> l.stream()).collect(Collectors.toList()));
		
		List<String> l2 = playersInWorldCup2022.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(l2);
		
		System.out.println(playersInWorldCup2022.stream());//java.util.stream.ReferencePipeline$Head@13acb0d1
		System.out.println(playersInWorldCup2022.stream().flatMap(l -> l.stream()));//java.util.stream.ReferencePipeline$7@37e547da
	}
}
