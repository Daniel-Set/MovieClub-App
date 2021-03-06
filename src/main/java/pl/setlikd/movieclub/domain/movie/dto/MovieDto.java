package pl.setlikd.movieclub.domain.movie.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieDto {
    private Long id;
    private String title;
    private String originalTitle;
    private String shortDescription;
    private String description;
    private String youtubeTrailerId;
    private Integer releaseYear;
    private String genre;
    private boolean promoted;
    private String poster;
    private double avgRating;
    private int ratingCount;

    public MovieDto(Long id,
                    String title,
                    String originalTitle,
                    String shortDescription,
                    String description,
                    String youtubeTrailerId,
                    Integer releaseYear,
                    String genre,
                    boolean promoted,
                    String poster,
                    Double avgRating,
                    int ratingCount) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.shortDescription = shortDescription;
        this.description = description;
        this.youtubeTrailerId = youtubeTrailerId;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.promoted = promoted;
        this.poster = poster;
        this.avgRating = avgRating;
        this.ratingCount = ratingCount;
    }

}
