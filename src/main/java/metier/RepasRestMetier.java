package metier;

import java.util.List;

import dao.IRepasRestDao;
import dao.RepasRestDao;
import entities.RepasRest;

public class RepasRestMetier implements IRepasRestMetier{
	
	private IRepasRestDao RepasRest=new RepasRestDao();

	public RepasRest addRepasRest(entities.RepasRest repas_rest) throws Exception {
		// TODO Auto-generated method stub
		return RepasRest.addRepasRest(repas_rest);
	}

	public RepasRest updateRepasRest(entities.RepasRest repas_rest) throws Exception {
		// TODO Auto-generated method stub
		return RepasRest.deleteRepasRest(repas_rest);
	}

	public RepasRest deleteRepasRestById(entities.RepasRest repas_rest) throws Exception {
		// TODO Auto-generated method stub
		return RepasRest.deleteRepasRest(repas_rest);
	}

	public List<entities.RepasRest> getRepasRests() throws Exception {
		// TODO Auto-generated method stub
		return RepasRest.RepasRestaurants();
	}

	

	

}
