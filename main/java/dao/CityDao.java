package dao;

import java.util.List;

import model.City;

public interface CityDao {
	public void saveCity(City city);
    public List<City> showAllCity();
    
    public City getCityByName(String cityName);
}
