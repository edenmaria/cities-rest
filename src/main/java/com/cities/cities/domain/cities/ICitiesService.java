package com.cities.cities.domain.cities;
import java.util.List;
// import com.concretepage.entity.Article;

public interface ICitiesService {
     List<Cities> getAllCities();
     Cities getCityById(long id);
     boolean addCity(Cities city);
     void updateCity(Cities city);
     void deleteCity(int id);
}
