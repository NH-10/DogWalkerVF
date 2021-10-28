package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Dog;
import pe.edu.upc.spring.repository.IFeedbackRepository;
import pe.edu.upc.spring.service.IDogService;
import pe.edu.upc.spring.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {////

	@Autowired
	private IFeedbackRepository dFeedback;
	



}
