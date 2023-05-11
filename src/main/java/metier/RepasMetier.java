package metier;

import java.util.List;

import dao.IRepasDao;
import dao.RepasDao;
import entities.Repas;

public class RepasMetier implements IRepasMetier{

	private IRepasDao RpsDao= new RepasDao();

	public Repas addRepas(Repas repas) throws Exception {			 
		
			 return RpsDao.addRepas(repas);
			 	}

	public Repas updateRepas(Repas repas) throws Exception {
		// TODO Auto-generated method stub
		return RpsDao.updateRepas(repas);
	}

	public Repas deleteRepas(Repas repas) throws Exception {
		// TODO Auto-generated method stub
		return RpsDao.deleteRepas(repas);
	}

	public Repas getRepasById(Long idRepas) throws Exception {
		// TODO Auto-generated method stub
		return RpsDao.getRepasById(idRepas);
	}

	public List<Repas> getRepass() throws Exception {
		// TODO Auto-generated method stub
		return RpsDao.getRepass();
	}

	
	

	
	

}
