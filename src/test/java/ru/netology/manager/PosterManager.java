package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class PosterManagerTest {
    @Mock
    FilmRepository repository;

    @InjectMocks
    PosterManager manager = new PosterManager(9);
    Film film1 = new Film(1, "Хищные птицы: Потрясающая история Харли Квинн", "Боевик/Супергеройский фильм", "Image1", 2020);
    Film film2 = new Film(2, "Чудо-женщина: 1984", "Боевик/Приключения", "Image2", 2020);
    Film film3 = new Film(3, "Соник в кино", "Семейный/Комедия", "Image3", 2020);
    Film film4 = new Film(4, "Мулан 2020", "Боевик/Приключения", "Image4", 2020);
    Film film5 = new Film(5, "Чёрная вдова", "Боевик/Приключения", "Image5", 2020);
    Film film6 = new Film(6, "Вперёд", "Семейный/Комедия", "Image6", 2020);
    Film film7 = new Film(7, "Спутник 2020", "Драма/Фэнтези", "Image7", 2020);
    Film film8 = new Film(8, "Зов предков", "Приключения/Драма", "Image8", 2020);
    Film film9 = new Film(9, "Лёд 2", "Романтика/Спорт", "Image9", 2020);
    Film film10 = new Film(10, "Бладшот", "Боевик/Приключения", "Image10", 2020);

    @Test
    void shouldAdd() {
        doReturn(new Film[]{film1}).when(repository).findAll();
        doNothing().when(repository).save(film1);

        Film[] expected = new Film[]{film1};
        manager.add(film1);
        assertArrayEquals(expected, manager.getFilms());
        verify(repository, times(1)).save(film1);

    }

    @Test
    void shouldReturnLessThenAddByDefault() {
        Film[] toBeReturned = {film2, film3, film4, film5,film6,film7};
        doReturn(toBeReturned).when(repository).findAll();

        Film[] expected = new Film[]{film7,film6,film5, film4, film3, film2};

        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }

    @Test
    void shouldGetFilms() {
        Film[] toBeReturned = {film1, film2};
        doReturn(toBeReturned).when(repository).findAll();

        Film[] expected = new Film[]{film2, film1};

     assertArrayEquals(expected, manager.getFilms());
    }

}
