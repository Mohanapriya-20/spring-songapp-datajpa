package com.songapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songapp.exceptions.SongNotFoundException;
import com.songapp.model.Description;
import com.songapp.repository.IDescriptionRepository;

/**
 * @author MohanapriyaV
 *
 */
@Service
public class DescriptionServiceImpl implements IDescriptionService {

	IDescriptionRepository descriptionRepository;

	@Autowired
	public void setDescriptionRepository(IDescriptionRepository descriptionRepository) {
		this.descriptionRepository = descriptionRepository;
	}

	@Override
	public void addDescription(Description description) {
		descriptionRepository.save(description);
	}

	@Override
	public void updateDescription(Description description) {
		descriptionRepository.save(description);

	}

	@Override
	public void deleteDescription(int descriptionId) {
		descriptionRepository.deleteById(descriptionId);
	}

	@Override
	public Description getBySongName(String name) throws SongNotFoundException {
		Description description = descriptionRepository.findBySongName(name);
		if (description == null)
			throw new SongNotFoundException("Please Enter Valid Song Name!!");
		return description;
	}

}
