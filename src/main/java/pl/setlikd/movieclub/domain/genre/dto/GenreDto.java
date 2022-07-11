package pl.setlikd.movieclub.domain.genre.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto {
    private Long id;
    private String name;
    private String description;

    public GenreDto() {
    }

    public GenreDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
