package pl.setlikd.movieclub.domain.movie;

import lombok.Getter;
import lombok.Setter;
import pl.setlikd.movieclub.domain.genre.Genre;
import pl.setlikd.movieclub.domain.rating.Rating;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String originalTitle;
    private String shortDescription;
    private String description;
    private String youtubeTrailerId;
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
    @OneToMany(mappedBy = "movie")
    private Set<Rating> ratings = new HashSet<>();
    private boolean promoted;
    private String poster;

}
