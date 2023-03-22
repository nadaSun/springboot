package ma.cigma.springmvcrestdatajpa.service;

import java.util.List;

import ma.cigma.springmvcrestdatajpa.domaine.EmpVo;

public interface IService2 {

	List<EmpVo> getEmployees();

	void save(EmpVo emp);

	EmpVo getEmpById(Long id);

	void delete(Long id);

	List<EmpVo> findBySalary(Double salary);
	
	List<EmpVo> findEmployeesByName(String name);

	List<EmpVo> findByFonction(String designation);

	List<EmpVo> findBySalaryAndFonction(Double salary, String fonction);

	EmpVo getEmpHavaingMaxSalary();

	// Pour la pagination
	List<EmpVo> findAll(int pageId, int size);

	// pour le tri
	List<EmpVo> sortBy(String... fieldName);

	// pour le tri
//	List<EmpVo> sortBy2(String fieldName1, String fieldName2);

	void deleteAll();
}
