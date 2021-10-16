package com.songapp.service;

import com.songapp.exceptions.SongNotFoundException;
import com.songapp.model.Description;

/**
 * @author MohanapriyaV
 *
 */
public interface IDescriptionService {
	void addDescription(Description description);

	void updateDescription(Description description);

	void deleteDescription(int descriptionId);

	Description getBySongName(String name) throws SongNotFoundException;

}
