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

import com.songapp.model.Singer;
import com.songapp.service.ISingerService;

/**
 * @author MohanapriyaV
 *
 */
@RestController
@RequestMapping("/singer-api")
public class SingerController {
	@Autowired
	ISingerService singerService;

	@PostMapping("/singers")
	public ResponseEntity<Singer> addSong(@RequestBody Singer singer) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Singer Added");
		Singer singerNew = singerService.addSinger(singer);
		return ResponseEntity.ok().headers(headers).body(singerNew);

	}

	@PutMapping("/singers")
	public ResponseEntity<Void> updateSinger(@RequestBody Singer singer) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Singer Updated");
		singerService.updateSinger(singer);
		return ResponseEntity.ok().headers(headers).build();
	}

	@DeleteMapping("/singers/{singerId}")
	ResponseEntity<Void> deleteSinger(@PathVariable("singerId") int singerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Singer Deleted");
		singerService.deleteSinger(singerId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/singers")
	ResponseEntity<List<Singer>> getAllSingers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving All Singers");
		List<Singer> singerList = singerService.getAll();
		return ResponseEntity.ok().headers(headers).body(singerList);
	}

	@GetMapping("/singers/{singerId}")
	ResponseEntity<Singer> getById(@PathVariable("singerId") int singerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Singers By Id");
		Singer singerNew = singerService.getById(singerId);
		return ResponseEntity.ok().headers(headers).body(singerNew);
	}

	@GetMapping("/singers/songname/{name}")
	ResponseEntity<List<Singer>> getBySongName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Singers By Song Name");
		List<Singer> singerList = singerService.getBySongName(name);
		return ResponseEntity.ok().headers(headers).body(singerList);
	}

}
