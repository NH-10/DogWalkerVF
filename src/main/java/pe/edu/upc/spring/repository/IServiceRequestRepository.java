package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.ServiceRequest;

@Repository
public interface IServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {
	
	@Query("from ServiceRequest s where CAST(s.owner.idOwner AS string) like %:idOwner%")
	List<ServiceRequest> listServiceRequestByOwner(@Param("idOwner")String idOwner);
	
	@Query("from ServiceRequest s where CAST(s.walker.idWalker AS string) like %:idWalker%")
	List<ServiceRequest> listServiceRequestByWalker(@Param("idWalker")String idWalker);

}
