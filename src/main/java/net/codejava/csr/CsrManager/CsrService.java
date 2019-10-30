package net.codejava.csr.CsrManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CsrService {

	@Autowired
	private CsrRepository repo;
	
	public List<Csr> listAll(){
		
		return repo.findAll();
	}
	
	public void save(Csr csr) {
		repo.save(csr);
	}
	
	public Csr get(Long id) {
		return repo.findById(id).get();
		}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
