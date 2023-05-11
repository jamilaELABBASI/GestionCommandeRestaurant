package metier;

import java.util.List;


import dao.ClientDao;
import dao.IClientDao;
import entities.Client;
import lombok.*;

public class ClientMetier implements IClientMetier{

	 IClientDao CLDao = new ClientDao();

	public Client AddClient(Client client) throws Exception {
		
        //if(client.getNomCli().isEmpty()||client.getPrenomCli().isEmpty()||client.getEmailCli().isEmpty()||client.getTelCli().isEmpty())
		 //throw new Exception("You must fill all the fields");
		
       	 return CLDao.addClient(client);
	}

	public Client UpdateClient(Client client) throws Exception{
		if(client.getNomCli().isEmpty()||client.getPrenomCli().isEmpty()||client.getEmailCli().isEmpty()||client.getTelCli().isEmpty())
			 throw new Exception("You must fill all the fields");
		return CLDao.updateClient(client);
	}
	
	
	public Client DeleteClient(Client client) throws Exception {
		
			return CLDao.deleteClient(client);
	}
	
	
	public Client getClientById(Long idCli) throws Exception {
        
		return CLDao.getClientById(idCli);
	}
	
	
	
	public List<Client> getClients() throws Exception {
		// TODO Auto-generated method stub
		return CLDao.getClients();
	}
	
	

	

}
