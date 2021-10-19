package com.songapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Category {
	@Id
	@GeneratedValue(generator = "category_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "category_gen", sequenceName = "category_seq", initialValue = 1, allocationSize = 1)
	private Integer categoryId;
	private String categoryName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
	@JsonIgnore
	private Set<Song> songList; // OneToMany

	public Category(String categoryName, Set<Song> songList) {
		super();
		this.categoryName = categoryName;
		this.songList = songList;
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	

}
