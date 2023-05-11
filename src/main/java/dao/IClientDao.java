package dao;

import java.util.List;

import entities.Client;

public interface IClientDao {

	Client addClient(Client client) throws Exception;
	Client updateClient(Client client)throws Exception;
	Client deleteClient(Client client)throws Exception;
	Client getClientById(Long idCli)throws Exception;
	List<Client> getClients() throws Exception;
}