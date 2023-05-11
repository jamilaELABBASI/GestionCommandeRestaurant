package metier;

import java.util.List;

import entities.Client;

public interface IClientMetier {
	
	Client AddClient(Client client)throws Exception;
	Client UpdateClient(Client client)throws Exception;
	Client DeleteClient(Client client)throws Exception;
	Client getClientById(Long idCli)throws Exception;
	List<Client> getClients() throws Exception;
}
