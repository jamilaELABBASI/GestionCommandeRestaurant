package dao;

import java.util.List;

import entities.Restaurant;

public interface IRestaurantDao {
	Restaurant addRest(Restaurant rest) throws Exception;
	Restaurant updateRest(Restaurant rest) throws Exception;
	Restaurant deleteRest(Restaurant rest) throws Exception;
	Restaurant getRestaurantByid(Long idRest) throws Exception;
	List<Restaurant> Restaurants() throws Exception;

}
