package ru.netology.hw11poster.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerLimit5Test {
    MovieManager manager = new MovieManager();

    MovieItem Film1 = new MovieItem();
    MovieItem Film2 = new MovieItem();
    MovieItem Film3 = new MovieItem();
    MovieItem Film4 = new MovieItem();
    MovieItem Film5 = new MovieItem();
    MovieItem Film6 = new MovieItem();
    MovieItem Film7 = new MovieItem();

    @Test
    public void shouldAddMovie() {

        manager.addMovie(Film1);
        manager.addMovie(Film2);
        manager.addMovie(Film3);

        MovieItem[] expected = { Film1, Film2, Film3 };
        MovieItem[] actual = manager.FindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastBelowLimit() {

        manager.addMovie(Film1);
        manager.addMovie(Film2);

        MovieItem[] expected = { Film2, Film1 };
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAboveLimit() {

        manager.addMovie(Film1);
        manager.addMovie(Film2);
        manager.addMovie(Film3);
        manager.addMovie(Film4);
        manager.addMovie(Film5);
        manager.addMovie(Film6);
        manager.addMovie(Film7);

        MovieItem[] expected = { Film7, Film6, Film5, Film4, Film3};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForLowerLimitValue0() {

        MovieItem[] expected = {};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForLowerLimitValue1() {

        manager.addMovie(Film1);

        MovieItem[] expected = {Film1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForUpperLimitValue4() {

        manager.addMovie(Film1);
        manager.addMovie(Film2);
        manager.addMovie(Film3);
        manager.addMovie(Film4);

        MovieItem[] expected = { Film4, Film3, Film2, Film1 };
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesEqualsLimit5() {

        manager.addMovie(Film1);
        manager.addMovie(Film2);
        manager.addMovie(Film3);
        manager.addMovie(Film4);
        manager.addMovie(Film5);

        MovieItem[] expected = { Film5, Film4, Film3, Film2, Film1 };
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForUpperLimitValue6() {

        manager.addMovie(Film1);
        manager.addMovie(Film2);
        manager.addMovie(Film3);
        manager.addMovie(Film4);
        manager.addMovie(Film5);
        manager.addMovie(Film6);

        MovieItem[] expected = { Film6, Film5, Film4, Film3, Film2 };
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
