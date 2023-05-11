package metier;

import java.util.List;

import entities.Responsable;

public interface IResponsableMetier {
	
	Responsable addResponsable(Responsable resp) throws Exception;
	Responsable updateResponsable(Responsable resp) throws Exception;
	Responsable deleteResponsable(Responsable resp) throws Exception;
	Responsable getResponsableById(Long idResp) throws Exception;
	List<Responsable> getResponsables() throws Exception;

}
