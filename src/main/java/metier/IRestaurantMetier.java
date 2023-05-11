package metier;

import java.util.List;

import entities.Restaurant;

public interface IRestaurantMetier {
	
	Restaurant addRestaurant(Restaurant Rest) throws Exception;
	Restaurant updateRestaurant(Restaurant Rest)throws Exception;
	Restaurant deleteRestaurant(Restaurant Rest)throws Exception;
	Restaurant getRestaurantById(Long idRest)throws Exception;
	List<Restaurant> Restaurants() throws Exception;

}
