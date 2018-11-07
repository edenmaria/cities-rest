package com.cities.cities.domain.cities;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import com.concretepage.entity.Article;
import com.cities.cities.domain.cities.CitiesDao;


@Service
public class CitiesService implements ICitiesService {
	@Autowired
	private CitiesDao citiesDao;
	@Override
	public Cities getCityById(long id) {
		Cities obj = citiesDao.findById(id).get(0);
		return obj;
	}	
	@Override
	public List<Cities> getAllCities(){
		List<Cities> list = new ArrayList<>();
		citiesDao.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addCity(Cities city){
	        List<Cities> list = citiesDao.findByName(city.getName()); 	
                if (list.size() > 0) {
    	           return false;
                } else {
    	        citiesDao.save(city);
    	        return true;
       }
	}
	@Override
	public void updateCity(Cities city) {
		citiesDao.save(city);
	}
	@Override
	public void deleteCity(int id) {
		citiesDao.delete(getCityById(id));
	}
} 