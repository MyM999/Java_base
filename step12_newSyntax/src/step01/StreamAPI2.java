package step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.domain.Employee;

public class StreamAPI2 {

	//dto 사용
	@Test
	public void step02() {
		List<Employee> peoples = new ArrayList<>();
		
		peoples.add(new Employee(101, "Victor", 23));
		peoples.add(new Employee(102, "Rick", 21));
		peoples.add(new Employee(103, "Sam", 25));
		peoples.add(new Employee(104, "John", 27));
		peoples.add(new Employee(105, "Grover", 23));
		peoples.add(new Employee(106, "Adam", 22));
		peoples.add(new Employee(107, "Samy", 224));  // age가 이상치
		peoples.add(new Employee(108, "Duke", 29));
		
		
		
//		System.out.println("1. :: ");
//		peoples.forEach(System.out::println);
//		
//		System.out.println("2. lambda식 사용으로 출력 ");
//		peoples.forEach(v -> System.out.println(v));
//		peoples.forEach(v -> System.out.println(v + " --- "));
		
		
//		System.out.println("3. 나이의 평균(average)");
//		System.out.println(peoples.stream().mapToInt(e -> e.getAge()).average().getAsDouble()); //49.25
//		
//		// :: or lambda 식 둘다 사용 
//		System.out.println("4. 직원들의 나이값만 출력");
//		peoples.stream().map(Employee::getAge).forEach(System.out::println);
//		peoples.stream().map(Employee::getAge).forEach(age -> System.out.print(age + "\t"));
		
		System.out.println("5. age가 이상치인 데이터 제외한 평균 나이");
		System.out.println(peoples.stream().mapToInt(e -> e.getAge()).filter(age -> age < 200).average().getAsDouble());
	}
	
	
	//기초
	public void step01() {
		//1~5 까지의 int값을 기반으로 List에는 객체만 저장
		//int -> Integer 객체로 변환된 List
		List<Integer> intDatas = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(intDatas);
	
		// % 2 == 0
		System.out.println("1. 짝수만 받아서 합");
		
		//java.util.stream.ReferencePipeline$2@12f40c25
		System.out.println(intDatas.stream().filter(v -> v % 2 == 0));//java.util.stream.ReferencePipeline$2@12f40c25
		
		//java.util.stream.ReferencePipeline$4@6842775d
		System.out.println(intDatas.stream().filter(v -> v % 2 == 0).mapToInt(i -> i));//java.util.stream.ReferencePipeline$4@6842775d
		System.out.println(intDatas.stream().filter(v -> v % 2 == 0).mapToInt(i -> i).sum());//6

		//? 홀수값만으로 합 구하기 
		System.out.println(intDatas.stream().filter(v -> v % 2 != 0).mapToInt(i -> i).sum()); //9
				
		//? 홀수 개수 구하기
		System.out.println(intDatas.stream().filter(v -> v % 2 != 0).mapToInt(i -> i).count()); //3
		
		//? 홀수중 최대값(max) 
		System.out.println(intDatas.stream().filter(v -> v % 2 != 0).mapToInt(i -> i).max()); //OptionalInt[5]
		System.out.println(intDatas.stream().filter(v -> v % 2 != 0).mapToInt(i -> i).max().getAsInt()); //5
		
		//? 2만 빼고 출력 System.out::println
		intDatas.stream().filter(v -> v != 2).forEach(System.out::print); //1345
	}

}
