package org.project.restapi.searchutility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bu/search")
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/name/{name}")
	public List<Object> getRecordByName(@PathVariable String name) {
		return searchService.getRecordByName(name);
	}
	
	@GetMapping("/id/{id}")
	public List<Object> getRecordById(@PathVariable String id) {
		return searchService.getRecordById(id);
	}
	

}
