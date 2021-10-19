package com.songapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author MohanapriyaV
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Description {
	@Id
	@GeneratedValue(generator = "description_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "description_gen", sequenceName = "description_seq", initialValue = 1, allocationSize = 1)
	private Integer descriptionId;
	private String lyrics;
	private String lyricist;
	private String language;
	private int views;
	@OneToOne(mappedBy = "description")
	@JsonIgnore
	private Song song;

	public Description(String lyrics, String lyricist, String language, int views) {
		super();
		this.lyrics = lyrics;
		this.lyricist = lyricist;
		this.language = language;
		this.views = views;

	}



}
