package dao;

import java.util.List;

import entities.LigneCom;

public interface ILigneComDao {

	
	LigneCom addLigneCom(LigneCom repas) throws Exception;
	LigneCom updateLigneCom(LigneCom repas)throws Exception;
	LigneCom deleteLigneCom(LigneCom repas)throws Exception;
	LigneCom getLigneComByid(Long idLigneCom) throws Exception;
	List<LigneCom> getLigneComs() throws Exception;

}
