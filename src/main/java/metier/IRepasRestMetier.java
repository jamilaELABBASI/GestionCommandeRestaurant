package metier;

import java.util.List;

import entities.RepasRest;

public interface IRepasRestMetier  {
	
	RepasRest addRepasRest(RepasRest repas_rest) throws Exception;
	RepasRest updateRepasRest(RepasRest repas_rest) throws Exception;
	RepasRest deleteRepasRestById(RepasRest repas_rest)throws Exception;
	List<RepasRest> getRepasRests() throws Exception;

}
