package com.songapp.service;

import java.util.List;

import com.songapp.exceptions.SongNotFoundException;
import com.songapp.model.Description;

/**
 * @author MohanapriyaV
 *
 */
public interface IDescriptionService {
	Description addDescription(Description description);

	void updateDescription(Description description);

	void deleteDescription(int descriptionId);

	List<Description> getAllDescription();

	Description getBySongName(String name) throws SongNotFoundException;

}
