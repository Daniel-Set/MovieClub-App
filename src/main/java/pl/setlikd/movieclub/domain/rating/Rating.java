package pl.setlikd.movieclub.domain.rating;

import lombok.Getter;
import lombok.Setter;
import pl.setlikd.movieclub.domain.movie.Movie;
import pl.setlikd.movieclub.domain.user.User;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "movie_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Integer rating;

    public Rating() {
    }

    public Rating(User user, Movie movie, Integer rating) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
    }


}
