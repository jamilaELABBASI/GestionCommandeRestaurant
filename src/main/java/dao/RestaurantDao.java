package dao;


import java.util.List;

import entities.Restaurant;
import util.HibernateCrud;

public class RestaurantDao implements IRestaurantDao{
	Restaurant rest;
	private HibernateCrud<Restaurant,Long> CRUD=new HibernateCrud<Restaurant,Long>();

	public Restaurant addRest(Restaurant rest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.add(rest);
	}

	public Restaurant updateRest(Restaurant rest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.update(rest);
	}

	public Restaurant deleteRest(Restaurant rest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.delete(rest);
	}

	public Restaurant getRestaurantByid(Long idRest) throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getById(idRest, rest);
	}

	public List<Restaurant> Restaurants() throws Exception {
		// TODO Auto-generated method stub
		return CRUD.getAll("Restaurant");
	}

	

}
