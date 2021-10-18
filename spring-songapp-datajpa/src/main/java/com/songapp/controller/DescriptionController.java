package com.songapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.songapp.model.Description;
import com.songapp.model.Song;
import com.songapp.service.IDescriptionService;
import com.songapp.service.ISongService;

/**
 * @author MohanapriyaV
 *
 */
@RestController
@RequestMapping("/description-api")
public class DescriptionController {

	@Autowired
	IDescriptionService descriptionService;

	@PostMapping("/description")
	public ResponseEntity<Description> addDescription(@RequestBody Description description) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Description Added");
		Description descriptionNew = descriptionService.addDescription(description);
		return ResponseEntity.ok().headers(headers).body(descriptionNew);
	}

	@PutMapping("/description")
	public ResponseEntity<Void> updateDescription(@RequestBody Description description) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Description Updated");
		descriptionService.updateDescription(description);
		return ResponseEntity.ok().headers(headers).build();

	}

	@DeleteMapping("/description/{descriptionId}")
	public ResponseEntity<Void> deleteDescription(@PathVariable("descriptionId") int descriptionId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Description Deleted");
		descriptionService.deleteDescription(descriptionId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/description")
	public ResponseEntity<List<Description>> getAllDescription() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving  All Descriptions");
		List<Description> descriptionList = descriptionService.getAllDescription();
		return ResponseEntity.ok().headers(headers).body(descriptionList);

	}

	@GetMapping("/description/songname/{name}")
	public ResponseEntity<Description> findBySongName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Description By Song Name");
		Description descriptionNew = descriptionService.getBySongName(name);
		return ResponseEntity.ok().headers(headers).body(descriptionNew);
	}
}
