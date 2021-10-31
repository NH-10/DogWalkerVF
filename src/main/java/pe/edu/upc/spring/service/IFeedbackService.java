package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Dog;
import pe.edu.upc.spring.model.Feedback;
import pe.edu.upc.spring.model.Walker;


public interface IFeedbackService {
	public boolean save(Feedback feedback);
	public List<Feedback> list();
	public List<Feedback> FeedbackByIdWalker(String idWalker);
}

