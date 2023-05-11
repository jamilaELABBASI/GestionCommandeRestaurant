package dao;

import java.util.List;

import entities.Commande;
import util.HibernateCrud;

public class CommandeDao implements ICommandeDao {
	
	private Commande commande;
	private HibernateCrud<Commande,Long> CRUD=new HibernateCrud<Commande,Long>();

	public Commande addCommande(Commande commande) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(commande);
	}

	public Commande updateCommande(Commande commande) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(commande);
	}

	public Commande deleteCommande(Commande commande) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(commande);
	}

	public Commande getCommandeByIdCom(Long idCom) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idCom, commande);
	}

	public List<Commande> getCommandes() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("Commande");
	}
	

	@Override
	public Commande getObjet(Long idCom) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
