package ma.cigma.springmvcrestdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigma.springmvcrestdatajpa.dao.EmpRepository;
import ma.cigma.springmvcrestdatajpa.domaine.EmpConverter;
import ma.cigma.springmvcrestdatajpa.domaine.EmpVo;
import ma.cigma.springmvcrestdatajpa.service.model.Emp;

@Service
public abstract class ServiceImpl2 implements IService2, CommandLineRunner {
	@Autowired
	private EmpRepository empRepository;

	@Override
	public List<EmpVo> getEmployees() {
		List<Emp> list = empRepository.findAll();
		return EmpConverter.toListVo(list);
	}

	@Transactional
	@Override
	public void save(EmpVo vo) {
		empRepository.save(EmpConverter.toBo(vo));
	}

	@Override
	public EmpVo getEmpById(Long id) {
		boolean trouve = empRepository.existsById(id);
		if (!trouve)
			return null;
		return EmpConverter.toVo(empRepository.findById(id).orElse(null));
	}

	@Override
	public void delete(Long id) {
		empRepository.deleteById(id);

	}

	@Override
	public List<EmpVo> findBySalary(Double salary) {
		List<Emp> list = empRepository.findBySalary(salary);
		return EmpConverter.toListVo(list);
	}

	@Override
	public List<EmpVo> findByFonction(String fonction) {
		List<Emp> list = empRepository.findByFonction(fonction);
		return EmpConverter.toListVo(list);
	}

	@Override
	public List<EmpVo> findBySalaryAndFonction(Double salary, String fonction) {
		List<Emp> list = empRepository.findBySalaryAndFonction(salary, fonction);
		return EmpConverter.toListVo(list);
	}

	/*
	 * @Override public EmpVo getEmpHavaingMaxSalary() { return
	 * EmpConverter.toVo(empRepository.getEmpHavaingMaxSalary()); }
	 */

	@Override
	public List<EmpVo> findAll(int pageId, int size) {
		Page<Emp> result = empRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return EmpConverter.toListVo(result.getContent());
	}

	@Override
	public List<EmpVo> sortBy(String... fieldNames) {
		return EmpConverter.toListVo(empRepository.findAll(Sort.by(fieldNames)));
	}

	@Transactional
	@Override
	public void deleteAll() {
		empRepository.deleteAll();
	}

}
