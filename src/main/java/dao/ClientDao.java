package dao;

import java.util.List;


import entities.Client;
import util.HibernateCrud;

public class ClientDao implements IClientDao{
	
    private Client client;
    
	 HibernateCrud<Client,Long> CRUD = new HibernateCrud<Client,Long>();

	public Client addClient(Client client) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(client);
	}

	public Client updateClient(Client client) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(client);
	}

	public Client deleteClient(Client client) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(client);
	}

	public Client getClientById(Long idCli) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idCli,client );
	}

	public List<Client> getClients() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("Client");
	}


	

}
