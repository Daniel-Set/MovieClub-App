package pl.setlikd.movieclub.domain.movie;

import pl.setlikd.movieclub.domain.movie.dto.MovieDto;
import pl.setlikd.movieclub.domain.rating.Rating;

class MovieDtoMapper {
    static MovieDto map(Movie movie) {
        double avgRating = movie.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(val -> val)
                .average().orElse(0);
        int ratingCount = movie.getRatings().size();
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getShortDescription(),
                movie.getDescription(),
                movie.getYoutubeTrailerId(),
                movie.getReleaseYear(),
                movie.getGenre().getName(),
                movie.isPromoted(),
                movie.getPoster(),
                avgRating,
                ratingCount);
    }
}
