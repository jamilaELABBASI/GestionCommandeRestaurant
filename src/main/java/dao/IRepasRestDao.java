package dao;

import java.util.List;

import entities.RepasRest;

public interface IRepasRestDao {
	
	RepasRest addRepasRest(RepasRest repas_rest) throws Exception;
	RepasRest updateRepasRest(RepasRest repas_rest) throws Exception;
	RepasRest deleteRepasRest(RepasRest repas_rest) throws Exception;
	RepasRest getRepasRestById(Long idRepasRest) throws Exception;
	List<RepasRest> RepasRestaurants() throws Exception;
	
}
