package metier;

import entities.Commande;
import java.util.List;

import dao.CommandeDao;
import dao.ICommandeDao;
import entities.Commande;

public class CommandeMetier implements ICommandeMetier{

	private ICommandeDao ComDao = new CommandeDao();

	public Commande addCommande(Commande commande) throws Exception {
				return ComDao.addCommande(commande);
	}

	public Commande updateCommande(Commande commande) throws Exception {
			return ComDao.updateCommande(commande);
	}

	public Commande deleteCommande(Commande commande) throws Exception {
        
		return ComDao.deleteCommande(commande);
	}

	public Commande getCommandeByIdCom(Long idCom) throws Exception {
		// TODO Auto-generated method stub
		return ComDao.getCommandeByIdCom(idCom);
	}

	public List<Commande> getCommandes() throws Exception {
		// TODO Auto-generated method stub
		return ComDao.getCommandes();
	}

	@Override
	public Commande getObjet(Long idCom) throws Exception {
		// TODO Auto-generated method stub
		return ComDao.getObjet(idCom);
	}


	

}
