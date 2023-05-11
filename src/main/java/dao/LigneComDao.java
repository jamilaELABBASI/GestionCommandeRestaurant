package dao;

import java.util.List;

import entities.LigneCom;
import entities.Repas;
import util.HibernateCrud;

public class LigneComDao implements ILigneComDao{
	
	private LigneCom ligneCom;
	private HibernateCrud<LigneCom,Long> CRUD =new HibernateCrud<LigneCom,Long>();


	public LigneCom addLigneCom(LigneCom lignecom) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(lignecom);
	}

	public LigneCom updateLigneCom(LigneCom lignecom) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(lignecom);
	}

	public LigneCom deleteLigneCom(LigneCom lignecom) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(lignecom);
	}

	public LigneCom getLigneComByid(Long idLigneCom) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idLigneCom,ligneCom);
	}

	public List<LigneCom> getLigneComs() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("ligneCom");
	}

}
