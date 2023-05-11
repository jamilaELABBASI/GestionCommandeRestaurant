package dao;

import java.util.List;

import entities.Repas;

public interface IRepasDao {
	
	Repas addRepas(Repas repas) throws Exception;
	Repas updateRepas(Repas repas)throws Exception;
	Repas deleteRepas(Repas repas)throws Exception;
	Repas getRepasById(Long idRepas) throws Exception;
	List<Repas> getRepass() throws Exception;
}

