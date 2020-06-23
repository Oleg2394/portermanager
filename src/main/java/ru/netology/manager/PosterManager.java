package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;


@AllArgsConstructor
public class PosterManager {

    private FilmRepository repository = new FilmRepository();
    private int itemsToReturn = 10;

    public PosterManager(FilmRepository repository) {
        this.repository = repository;
    }

    public PosterManager(int itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getFilms() {
        Film[] filmsFromRepo = repository.findAll();
        int arrayLength = itemsToReturn;
        if (filmsFromRepo.length <= arrayLength) {
            arrayLength = filmsFromRepo.length;
        }

        Film[] result = new Film[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = filmsFromRepo.length - i - 1;
            result[i] = filmsFromRepo[index];
        }

        return result;
    }
}
