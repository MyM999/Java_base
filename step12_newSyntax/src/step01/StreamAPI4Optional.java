//StreamAPI3Optional.java의 소스에서 Optional 생성 방식만 변경 test

package step01;

import java.util.Optional;

import org.junit.Test;

public class StreamAPI4Optional {
	//? orElseThrow test 예제 직접 구상해 보기
	/* 컴파일 예외 발생 가능성이 있다면 try~catch 필수
	 * 런타임 예외 발생 	"	 "  		"  옵션(값만 수정)	
	 */
//	@Test
	public void step05() {
		String v = "encore";
		Optional<String> opt = Optional.ofNullable(v);
		
		System.out.println(opt.orElseThrow(IllegalArgumentException::new));
		System.out.println(opt.orElseThrow(RuntimeException::new));
		
		// 문법 오류 왜? Exception은 try~catch 필수
		//System.out.println(opt.orElseThrow(Exception::new)); 
	}
	
	

	@Test
	public void step04() {
		String v = null;
//		String v = "encore";
		
		Optional<String> opt = Optional.of(v);  // 실행 오류
		
		System.out.println(opt.isPresent()); //false    / true
		
		//String java.util.Optional.orElse(String other)
		System.out.println(opt.orElse("null인 경우만 반환")); //null인 경우만 반환   / encore
	}
	
	
	//Optional API 활용
//	@Test
	public void step03() {
		String v = null;
//		String v = "playdata";
		
		//of() : null로 객체 생성 불가  실행 오류
		Optional<String> opt = Optional.of(v);  //실행 오류
		System.out.println(opt); 
		
		//데이터 여부 확인
		System.out.println(opt.isPresent());
		opt.ifPresent(v2 -> {  
			System.out.println(1);
			System.out.println(v2.length());
			System.out.println(2);
		});
	}
	
	
	
//	@Test
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
