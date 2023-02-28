package ru.netolody.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioManTest {

    @ParameterizedTest
    @CsvSource({
            "50, 30, 30",
            "8, 7, 7",
            "153, 1, 1",
            "0, 0 ,0"
    })
    public void CurrentStation (int quantityStations, int currentStation, int expected) {
        Radio radio = new Radio(quantityStations);

        radio.setCurrentStation(currentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "1, 1",
            "9, 9",
            "10, 0",
            "0, 0"
    })
    public void withoutIndicationStation (int currentStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentStation(currentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "15, 14, 0",
            "7, 5, 6",
            "14, 0, 1",
    })
    public void switchingStationUp (int quantityStations, int currentStation, int expected) {
        Radio radio = new Radio(quantityStations);
        radio.setCurrentStation(currentStation);

        radio.next();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 2",
            "8, 9",
            "9, 0"
    })
    public void switchingStationUpWithoutIndication (int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.next();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "20, 19, 18",
            "13, 12, 11",
            "5, 1, 0",
            "84, 0, 83"
    })
    public void switchingStationDown (int quantityStations, int currentStation, int expected) {
        Radio radio = new Radio(quantityStations);
        radio.setCurrentStation(currentStation);

        radio.prev();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 9",
            "1, 0",
            "9, 8"
    })
    public void switchingStationDownWithoutIndication (int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.prev();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }
}
