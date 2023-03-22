package ma.cigma.springmvcrestdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.cigma.springmvcrestdatajpa.service.model.Emp;

/**
 * 
 * Ici, l'interface EmpRepository hérite de l'interface JpaRepository de Spring
 * DATA. Il faut juste préciser la classe "Modele" et le type de la classe qui
 * représente la clé primaire.
 * 
 * Spring Data prendra en charge l'implémentation des 04 méthode ci-dessous à
 * condition de réspecter la nomenclature supportée par Spring Data.
 * 
 * @Query offre la possinbilité d'exécuter des requêtes plus complexes.
 *
 */

public interface EmpRepository extends JpaRepository<Emp, Long> {
	List<Emp> findBySalary(Double salary);

	List<Emp> findByFonction(String designation);

	List<Emp> findBySalaryAndFonction(Double salary, String fonction);


}
