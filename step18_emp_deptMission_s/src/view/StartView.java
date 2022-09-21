package view;

import java.util.List;

import model.EmpDeptDAO;
import model.domain.Dept;
import model.domain.Emp;

public class StartView {

	public static void main(String[] args) {
		
		EmpDeptDAO dao = EmpDeptDAO.getInstance();
		
		try {
//			System.out.println("*** 1. 모든 직원 검색 ***");
//			List<Emp> emps = dao.findElementAll();
//			EndView.printEmpAll(emps);
//			
//			/* 인사과 직원이 새로운 직원을 브라우저 웹 통해서 등록
//			 * 부서 번호는 이미 존재한다는 가정하에 먼저 검색  
//			 */
//			System.out.println("*** 2. 존재하는 부서에 새로운 직원 등록 ***");
//			Dept searchDept = dao.findDept(40L);
//			Emp employee = Emp.builder().empno(1201L).ename("Gopal").sal(40000L).deptno(searchDept).build();
//			dao.createEmployee(employee);

			
			System.out.println("*** 3. 직원 검색 ***");
//			Emp emp = dao.findEmployee(1201L);
			Emp emp = dao.findEmployee(7902L);   //EntityManager 생성 후 실행 후 삭제(영속성 컨텍스트 소멸)
//			System.out.println(emp.getDeptno()); 실행 오류
			System.out.println(emp.getEname());
			System.out.println(emp.getDeptno().getDname());
			
//			EndView.printEmp(emp);  //emp.toString()
			
			/* 이미 검색된 데이터와 동일한 값으로 수정시에는 update sql문장 실행할 필요 없음 
			 */
//			System.out.println("*** 4. 존재하는 직원의 급여 수정 후 검색 ***");
//			dao.updateEmployee(1201L, 50000L);
//			emp = dao.findEmployee(1201L);
//			EndView.printEmp(emp);
//			
//			
//			System.out.println("*** 5. 존재하는 직원의 삭제 후 검색***");
//			dao.deleteElement(1201L);
//			emp = dao.findEmployee(1201L);
//			EndView.printEmp(emp);
			
			
//			System.out.println("*** 6. 모든 직원 검색 ***");
//			EndView.printEmpAll(dao.findElementAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
