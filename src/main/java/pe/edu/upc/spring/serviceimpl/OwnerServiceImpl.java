package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.repository.IOwnerRepository;
import pe.edu.upc.spring.service.IOwnerService;

@Service
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	private IOwnerRepository dOwner;
	
	@Override
	@Transactional
	public boolean save(Owner owner) {
		Owner objOwner= dOwner.save(owner);
		if (objOwner == null)
			return false;
		else
			return true;
	}


	@Override
	@Transactional
	public void delete(int idOwner) {
		dOwner.deleteById(idOwner);
		
	}


	@Override
	@Transactional(readOnly=true)
	public List<Owner> list() {
		return dOwner.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Owner> listById(int idOwner)  {
		return dOwner.findById(idOwner);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Owner> findByName(String firstNames) {
		return dOwner.findByName(firstNames);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Owner> findByEmailAndPassword(String email, String password) {
		System.out.print("Email : "+email);
		System.out.print("password : "+password);

		return dOwner.findByEmailAndPassword(email, password);
	}

}
