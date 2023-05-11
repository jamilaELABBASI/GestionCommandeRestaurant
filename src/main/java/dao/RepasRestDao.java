package dao;

import java.util.List;

import entities.RepasRest;
import util.HibernateCrud;

public class RepasRestDao implements IRepasRestDao {

	private RepasRest repas_rest;
	private HibernateCrud<RepasRest,Long> CRUD =new HibernateCrud<RepasRest,Long>();

	public RepasRest addRepasRest(RepasRest repas_rest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(repas_rest);		
	}

	public RepasRest updateRepasRest(RepasRest repas_rest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(repas_rest);
	}

	public RepasRest deleteRepasRest(RepasRest repas_rest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(repas_rest);
	}

	public RepasRest getRepasRestById(Long idRepasRest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idRepasRest, repas_rest);
	}

	public List<RepasRest> RepasRestaurants() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("repas_rest");
	}

	
}
