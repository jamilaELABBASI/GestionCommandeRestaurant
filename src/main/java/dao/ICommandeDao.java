package dao;

import java.util.List;

import entities.Commande;

public interface ICommandeDao {
	
	Commande addCommande(Commande commande) throws Exception;
	Commande updateCommande(Commande commande) throws Exception;
	Commande deleteCommande(Commande commande) throws Exception;
	Commande getCommandeByIdCom(Long idCom) throws Exception;
	List<Commande> getCommandes() throws Exception;
	Commande getObjet(Long idCom) throws Exception;

}
