package com.cities.cities.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.cities.cities.domain.cities.Cities;
import com.cities.cities.domain.cities.ICitiesService;


@Controller
@RequestMapping("api")
public class ControladorCities {
	
	private static final String HTTP_LOCALHOST_4200 = "http://localhost:4200";

	@Autowired
	private ICitiesService citiesService;

	@CrossOrigin(origins=HTTP_LOCALHOST_4200)
	@GetMapping("cities/{id}")
	public ResponseEntity<Cities> getCityById(@PathVariable("id") Integer id) {
		Cities city = citiesService.getCityById(id);
		return new ResponseEntity<Cities>(city, HttpStatus.OK);
	}

	@CrossOrigin(origins=HTTP_LOCALHOST_4200)
	@GetMapping("cities")
	public ResponseEntity<List<Cities>> getAllCities() {
		List<Cities> list = citiesService.getAllCities();
		return new ResponseEntity<List<Cities>>(list, HttpStatus.OK);
	}

	@CrossOrigin(origins=HTTP_LOCALHOST_4200)
	@PostMapping("cities")
	public ResponseEntity<Void> addCity(@RequestBody Cities city, UriComponentsBuilder builder) {
                boolean flag = citiesService.addCity(city);
                if (flag == false) {
        	        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/cities/{id}").buildAndExpand(city.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@CrossOrigin(origins=HTTP_LOCALHOST_4200)
	@PutMapping("cities")
	public ResponseEntity<Cities> updateCity(@RequestBody Cities city) {
		citiesService.updateCity(city);
		return new ResponseEntity<Cities>(city, HttpStatus.OK);
	}

	@CrossOrigin(origins=HTTP_LOCALHOST_4200)
	@DeleteMapping("cities/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable("id") Integer id) {
		citiesService.deleteCity(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
