package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Owner;


public interface IOwnerService {
	public boolean save(Owner owner);
	public void delete(int idOwner);
	public List<Owner> list();
	public Optional<Owner> listById(int idOwner);
	public List<Owner> findByName(String firstNames);
	public List<Owner> findByEmailAndPassword(String email, String password);

}

