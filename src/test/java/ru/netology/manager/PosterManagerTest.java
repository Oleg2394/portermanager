package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.PosterManager;
import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    PosterManager manager = new PosterManager(5);
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
        Film[] expected = new Film[]{film10};
        manager.add(film10);
        assertArrayEquals(expected, manager.getFilms());

    }

    @Test
    void shouldReturnLessThenAddByDefault() {
        Film[] expected = new Film[]{film6,film5, film4, film3, film2};
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);

        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldGetFilms() {
        Film[] expected = new Film[]{film2, film1};
        manager.add(film1);
        manager.add(film2);

        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldReturnEmptyArray() {
        assertArrayEquals(new Film[0], manager.getFilms());
    }

}