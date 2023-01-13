package com.example.travelapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TravelController {
	
	@Autowired
	private TravelRepository travelrepository;
	
	@GetMapping("/travel")
	public List<Travel> allTravel(){
		return travelrepository.findAll();
	}
	
	@GetMapping("/getTravel")
	public List<Travel> getTravel(@RequestParam String id){
		return travelrepository.findById(id);
	}
	
	@GetMapping("/addTravel")
	@ResponseBody
	public String addTravel() {
		
		String id = "tp005";
		String name = "Jammu & Kashmir";
		String description = "Border";
		
		Travel cout = new Travel(id,name,description);
		travelrepository.save(cout);
		System.out.println("----------All Data saved into Database--------------");
		return "[{status:inserted}]";
	}
	
	@GetMapping("/updateTravel")
	public String updateTravel(@RequestParam String id) {
		String name = "Jammu & Kashmir";
		String description = "My Own Wish Updated";
		
		Travel cout = new Travel(id,name,description);
		travelrepository.save(cout);
		return "[{status:updated}]";
	}
	
	@GetMapping("/deleteTravel")
	public String deleteById(@RequestParam String id) {
		System.out.println("id"+id);
		try {
       travelrepository.deleteById(id);
		}catch(Exception ex) {
			System.out.println(ex);
		}
       return "[{status:deleted}]";
	}

}
