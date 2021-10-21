package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Race;

public interface IRaceService {
	public boolean grabar(Race race);
	public void eliminar(int idRace);
	public Optional<Race> listarId(int idRace);
	public List<Race> listar();
	public List<Race> buscarNombre(String nameRace);	
}
