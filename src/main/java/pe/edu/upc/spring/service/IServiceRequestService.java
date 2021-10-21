package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.ServiceRequest;

public interface IServiceRequestService {
	public boolean save(ServiceRequest serviceRequest);
	public void delete(int idServiceRequest);
	public Optional<ServiceRequest> listId(int idServiceRequest);
	public List<ServiceRequest> listServiceRequest();
}
