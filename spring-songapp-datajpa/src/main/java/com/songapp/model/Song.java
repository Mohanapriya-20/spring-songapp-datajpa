package com.songapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.transaction.Transactional;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Song {
	@Id
	@GeneratedValue(generator = "song_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "song_gen", sequenceName = "song_seq", initialValue = 1, allocationSize = 1)
	private Integer songId;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "description_id")
	private Description description;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "song_singer", joinColumns = { @JoinColumn(name = "song_id") }, inverseJoinColumns = {
			@JoinColumn(name = "singer_id") })
	private Set<Singer> singerList;

	public Song(String name, Description description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Song(String name, Description description, Movie movie, Category category, Set<Singer> singerList) {
		super();
		this.name = name;
		this.description = description;
		this.movie = movie;
		this.category = category;
		this.singerList = singerList;
	}



}
