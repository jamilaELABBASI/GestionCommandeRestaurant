package dao;

import java.util.List;

import entities.Responsable;
import util.HibernateCrud;

public class ResponsableDao  implements IResponsableDao{

	private Responsable responsable;
	private HibernateCrud<Responsable,Long> CRUD =new HibernateCrud<Responsable,Long>();

	public Responsable addResp(Responsable Resp) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(Resp);
	}

	public Responsable updateResp(Responsable Resp) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(Resp);
	}

	public Responsable deleteResp(Responsable Resp) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(Resp);
	}

	public Responsable getResponsableById(Long idResp) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idResp, responsable);
	}

	public List<Responsable> Responsables() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("Responsable");
	}
	
	
}
