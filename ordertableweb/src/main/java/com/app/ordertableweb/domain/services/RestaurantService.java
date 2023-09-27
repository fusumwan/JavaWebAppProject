package com.app.ordertableweb.domain.services;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import com.app.ordertableweb.domain.models.*;
import com.app.ordertableweb.domain.utils.web.WebRequestUtil;
public interface RestaurantService {
	public List<Restaurant> getRestaurants();
	public Restaurant saveRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(String restaurant_id);
	public void deleteRestaurant(String restaurant_id);
	public List<Restaurant> findByRestaurantId(String restaurant_id);
	public List<Restaurant> findByName(String name);
	public List<Restaurant> findByImage(String image);
	public List<Restaurant> findByLocation(String location);
	public List<Restaurant> findByContactNumber(Integer contact_number);
	public List<Restaurant> findByLongitude(String longitude);
	public List<Restaurant> findByLatitude(String latitude);
	public List<Restaurant> findByDescription(String description);
	public List<Restaurant> filterRestaurant(WebRequestUtil.FilterRequestData requestData);
	public List<Restaurant> getByRestaurant();
}
