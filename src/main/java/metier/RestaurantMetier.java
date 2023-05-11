package metier;

import java.util.List;

import dao.IRestaurantDao;
import dao.RestaurantDao;
import entities.Restaurant;

public class RestaurantMetier implements IRestaurantMetier {
	
	IRestaurantDao Resta= new RestaurantDao();

	public Restaurant addRestaurant(Restaurant Rest) throws Exception {
		// TODO Auto-generated method stub
		return Resta.addRest(Rest);
	}

	public Restaurant updateRestaurant(Restaurant Rest) throws Exception {
		// TODO Auto-generated method stub
		return Resta.updateRest(Rest);
	}

	public Restaurant deleteRestaurant(Restaurant Rest) throws Exception {
		// TODO Auto-generated method stub
		return Resta.deleteRest(Rest);
	}

	public Restaurant getRestaurantById(Long idRest) throws Exception {
		// TODO Auto-generated method stub
		return Resta.getRestaurantByid(idRest);
	}

	public List<Restaurant> Restaurants() throws Exception {
		// TODO Auto-generated method stub
		return Resta.Restaurants();
	}

	

}
