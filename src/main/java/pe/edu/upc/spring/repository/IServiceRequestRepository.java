package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.spring.model.ServiceRequest;

@Repository
public interface IServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {

}
