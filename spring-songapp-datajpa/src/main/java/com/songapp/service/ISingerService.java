package com.songapp.service;

import java.util.List;

import com.songapp.exceptions.IdNotFoundException;
import com.songapp.exceptions.SingerNotFoundException;
import com.songapp.model.Singer;

/**
 * @author MohanapriyaV
 *
 */
public interface ISingerService {
	Singer addSinger(Singer singer);

	void updateSinger(Singer singer);

	void deleteSinger(int singerId);

	List<Singer> getAll();

	Singer getById(int singerId) throws IdNotFoundException;

	List<Singer> getBySongName(String name) throws SingerNotFoundException;
}
