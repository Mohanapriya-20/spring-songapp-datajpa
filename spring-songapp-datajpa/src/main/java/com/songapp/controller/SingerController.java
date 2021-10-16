package com.songapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Singer addSong(@RequestBody Singer singer) {
		return singerService.addSinger(singer);
	}

	@PutMapping("/singers")
	public void updateSinger(@RequestBody Singer singer) {
		singerService.updateSinger(singer);
	}

	@DeleteMapping("/singers/{singerId}")
	void deleteSinger(@PathVariable("singerId") int singerId) {
		singerService.deleteSinger(singerId);
	}

	@GetMapping("/singers")
	List<Singer> getAllSingers() {
		return singerService.getAll();
	}

	@GetMapping("/singers/{singerId}")
	Singer getById(@PathVariable("singerId") int singerId) {
		return singerService.getById(singerId);
	}

	@GetMapping("/singers/songname/{name}")
	List<Singer> getBySongName(@PathVariable("name") String name) {
		return singerService.getBySongName(name);
	}

}
