package pl.setlikd.movieclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.setlikd.movieclub.domain.movie.MovieService;
import pl.setlikd.movieclub.domain.movie.dto.MovieDto;

import java.util.List;

@Controller
public class HomeController {
    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<MovieDto> promotedMovies = movieService.findAllPromotedMovies();
        model.addAttribute("heading", "Promoted Videos");
        model.addAttribute("description", "Videos recommended by our team");
        model.addAttribute("movies", promotedMovies);
        return "movie-listing";
    }
}