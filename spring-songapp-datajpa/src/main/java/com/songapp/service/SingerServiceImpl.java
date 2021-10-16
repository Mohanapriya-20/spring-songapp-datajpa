package com.songapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.songapp.exceptions.IdNotFoundException;
import com.songapp.exceptions.SingerNotFoundException;
import com.songapp.model.Singer;
import com.songapp.repository.ISingerRepository;

/**
 * @author MohanapriyaV
 *
 */
@Service
public class SingerServiceImpl implements ISingerService {
	@Autowired
	ISingerRepository singerRepository;

	@Override
	public Singer addSinger(Singer singer) {
		return singerRepository.save(singer);
	}

	@Override
	public void updateSinger(Singer singer) {

		singerRepository.save(singer);
	}

	@Override
	public void deleteSinger(int singerId) {
		singerRepository.deleteById(singerId);

	}

	@Override
	public List<Singer> getAll() {

		return singerRepository.findAll();
	}

	@Override
	public Singer getById(int singerId) throws IdNotFoundException {
		Singer singer = singerRepository.findById(singerId).get();
		if (singer == null)
			throw new IdNotFoundException("Please Enter Valid Id");
		return singer;
	}

	@Override
	public List<Singer> getBySongName(String name) throws SingerNotFoundException {
		List<Singer> singerList = singerRepository.findBySongName(name);
		if (singerList.isEmpty())
			throw new SingerNotFoundException("Please Enter Valid Song Name");
		return singerList;
	}

}
