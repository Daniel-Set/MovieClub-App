package pl.setlikd.movieclub.domain.movie;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.setlikd.movieclub.domain.genre.Genre;
import pl.setlikd.movieclub.domain.genre.GenreRepository;
import pl.setlikd.movieclub.domain.movie.dto.MovieDto;
import pl.setlikd.movieclub.domain.movie.dto.MovieSaveDto;
import pl.setlikd.movieclub.storage.FileStorageService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final FileStorageService fileStorageService;
    private final GenreRepository genreRepository;


    public MovieService(MovieRepository movieRepository, FileStorageService fileStorageService, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.fileStorageService = fileStorageService;
        this.genreRepository = genreRepository;
    }

    public List<MovieDto> findAllPromotedMovies() {
        return movieRepository.findAllByPromotedIsTrue().stream()
                .map(MovieDtoMapper::map)
                .toList();
    }

    public Optional<MovieDto> findMovieById(long id) {
        return movieRepository.findById(id).map(MovieDtoMapper::map);
    }

    public List<MovieDto> findMoviesByGenreName(String genre) {
        return movieRepository.findAllByGenre_NameIgnoreCase(genre).stream()
                .map(MovieDtoMapper::map)
                .toList();
    }

    @Transactional
    public void addMovie(MovieSaveDto movieToSave) {
        Movie movie = new Movie();
        movie.setTitle(movieToSave.getTitle());
        movie.setOriginalTitle(movieToSave.getOriginalTitle());
        movie.setPromoted(movieToSave.isPromoted());
        movie.setReleaseYear(movieToSave.getReleaseYear());
        movie.setShortDescription(movieToSave.getShortDescription());
        movie.setDescription(movieToSave.getDescription());
        movie.setYoutubeTrailerId(movieToSave.getYoutubeTrailerId());
        Genre genre = genreRepository.findByNameIgnoreCase(movieToSave.getGenre()).orElseThrow();
        movie.setGenre(genre);
        if (movieToSave.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(movieToSave.getPoster());
            movie.setPoster(savedFileName);
        }
        movieRepository.save(movie);
    }


}
