package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();
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
    void shoulSave() {
        Film[] expected = new Film[]{film1};
        repository.save(film1);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldReturn() {
        Film[] expected = new Film[]{film1, film2, film3, film4, film5};
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        repository.save(film1);
        repository.save(film2);
        String expected = "Хищные птицы: Потрясающая история Харли Квинн";
        assertEquals(expected, repository.findById(1).getName());
    }

    @Test
    void shouldRemoveById() {
        repository.save(film1);
        repository.removeById(1);
        assertNull(repository.findById(1));
    }

    @Test
    void shouldRemoveAll() {
        repository.save(film1);
        repository.save(film2);
        repository.removeAll();
        assertNull(repository.findById(1));
        assertNull(repository.findById(2));
    }

    @Test
    void shouldReturnEmptyArray() {
        assertArrayEquals(new Film[0], repository.findAll());
    }

}

