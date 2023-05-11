package metier;

import java.util.List;

import dao.IResponsableDao;
import dao.ResponsableDao;
import entities.Responsable;

public class ResponsableMetier implements IResponsableMetier{
	
	IResponsableDao Resp = new ResponsableDao();

	public Responsable addResponsable(Responsable resp) throws Exception {
		// TODO Auto-generated method stub
		return Resp.addResp(resp);
	}

	public Responsable updateResponsable(Responsable resp) throws Exception {
		// TODO Auto-generated method stub
		return Resp.updateResp(resp);
	}

	public Responsable deleteResponsable(Responsable resp) throws Exception {
		// TODO Auto-generated method stub
		return Resp.deleteResp(resp);
	}

	public Responsable getResponsableById(Long idResp) throws Exception {
		// TODO Auto-generated method stub
		return Resp.getResponsableById(idResp);
	}

	public List<Responsable> getResponsables() throws Exception {
		// TODO Auto-generated method stub
		return Resp.Responsables();
	}

	
}
