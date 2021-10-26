package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Owner;


@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Integer>{
	
	@Query("from Owner o where o.firstNames like %:firstNames%" )
	List<Owner> findByName(@Param("firstNames")String firstNames);
	
	@Query("from Owner o where o.email like %:email% and o.password like %:password% ")
	List<Owner> findByEmailAndPassword(@Param("email")String email, @Param("password")String password);
	
}
