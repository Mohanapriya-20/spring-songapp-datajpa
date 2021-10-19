package com.songapp.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Entity
@ToString
public class Singer {
	@Id
	@GeneratedValue(generator = "singer_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "singer_gen", sequenceName = "singer_seq", initialValue = 1, allocationSize = 1)
	private Integer singerId;
	private String name;

	@ManyToMany(mappedBy = "singerList")
	@JsonIgnore
	private Set<Song> songList; // ManyToMany

	public Singer(String name) {
		super();
		this.name = name;

	}

	

}
