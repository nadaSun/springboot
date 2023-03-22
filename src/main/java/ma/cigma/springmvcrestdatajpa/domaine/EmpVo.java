package ma.cigma.springmvcrestdatajpa.domaine;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cigma.springmvcrestdatajpa.domaine.EmpVo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo {
	
	@NotNull
	private Long id;
	private String name;
	@Min(value = 15000)
	private Double salary;
	private String fonction;
	public EmpVo(String name, Double salary, String fonction) {
		super();
		this.name = name;
		this.salary = salary;
		this.fonction = fonction;
	}

	
	
	

}
