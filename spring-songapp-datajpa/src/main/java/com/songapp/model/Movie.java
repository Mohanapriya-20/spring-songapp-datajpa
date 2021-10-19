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
@Entity
@ToString
public class Movie {
	@Id
	@GeneratedValue(generator = "movie_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_gen", sequenceName = "movie_seq", initialValue = 1, allocationSize = 1)
	private Integer movieId;
	private String movieName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "movie")
	@JsonIgnore
	private Set<Song> songList; // OneToMany

	public Movie(String movieName, Set<Song> songList) {
		super();
		this.movieName = movieName;
		this.songList = songList;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + "]";
	}

	public Movie(String movieName) {
		super();
		this.movieName = movieName;
	}

}
