package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.Walker;

public interface IWalkerService {
	public boolean save(Walker walker);
	public List<Walker> list();

}
