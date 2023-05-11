package dao;

import java.util.List;

import entities.Responsable;

public interface IResponsableDao {
	
	Responsable addResp(Responsable Resp) throws Exception;
	Responsable updateResp(Responsable Resp) throws Exception;
	Responsable deleteResp(Responsable Resp) throws Exception;
	Responsable getResponsableById(Long idResp) throws Exception;
	List<Responsable> Responsables() throws Exception;
}
