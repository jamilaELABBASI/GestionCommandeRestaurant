package dao;

import java.util.List;

import entities.Repas;
import util.HibernateCrud;

public class RepasDao implements IRepasDao {

	
	private Repas repas;
	private HibernateCrud<Repas,Long> CRUD =new HibernateCrud<Repas,Long>();

	public Repas addRepas(Repas repas) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(repas);
	}

	public Repas updateRepas(Repas repas) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(repas);
	}

	public Repas deleteRepas(Repas repas) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(repas);
	}

	public Repas getRepasById(Long idRepas) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idRepas, repas);
	}

	public List<Repas> getRepass() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("Repas");
	}

	
	
}
