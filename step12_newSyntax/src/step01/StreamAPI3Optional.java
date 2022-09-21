package step01;

import java.util.Optional;

import org.junit.Test;

public class StreamAPI3Optional {
	//? orElseThrow test 예제 직접 구상해 보기
	/* 컴파일 예외 발생 가능성이 있다면 try~catch 필수
	 * 런타임 예외 발생 	"	 "  		"  옵션(값만 수정)	
	 * 
	 */
	@Test
	public void step05() {
		String v = "encore";
		Optional<String> opt = Optional.ofNullable(v);
		
		System.out.println(opt.orElseThrow(IllegalArgumentException::new));
		System.out.println(opt.orElseThrow(RuntimeException::new));
		
		// 문법 오류 왜? Exception은 try~catch 필수
		//System.out.println(opt.orElseThrow(Exception::new)); 
	}
	
	

//	@Test
	public void step04() {
//		String v = null;
		String v = "encore";
		Optional<String> opt = Optional.ofNullable(v);
		
		System.out.println(opt.isPresent()); //false    / true
		
		//String java.util.Optional.orElse(String other)
		System.out.println(opt.orElse("null인 경우만 반환")); //null인 경우만 반환   / encore
	}
	
	
	//Optional API 활용
//	@Test
	public void step03() {
//		String v = null;
		String v = "playdata";
		Optional<String> opt = Optional.ofNullable(v);//null or String 이 parameter
		System.out.println(opt); // Optional.empty
		
		//데이터 여부 확인
		System.out.println(opt.isPresent()); //v=null인 경우 false / v = "playdata"인 경우  true
		opt.ifPresent(v2 -> {  //null 보유하고 있을 경우 false 따라서 {} 실행 생략, NullPointerException 발생 가능성 zero
			System.out.println(1);
			System.out.println(v2.length());
			System.out.println(2);
		});
	}
	
	
	
	//@Test
	public void step02() {
		String v = "encore";
		System.out.println(v.length());  //6
	}
	
	//  null 문제 확인 
//	@Test
	public void step01() {
		String v = null;
		System.out.println(v.length());  //실행 예외 발생 
	}
}
