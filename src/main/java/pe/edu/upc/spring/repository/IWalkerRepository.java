package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Walker;


@Repository
public interface IWalkerRepository extends JpaRepository<Walker, Integer>{
	
	@Query("from Walker w where w.email like %:email% and w.password like %:password% ")
	List<Walker> findByEmailAndPassword(@Param("email")String email, @Param("password")String password);
	
	
	@Query("from Walker w where w.district.name like %:nameDistrict%")
	List<Walker> listByDistrict(@Param("nameDistrict") String nameDistrict);

}
