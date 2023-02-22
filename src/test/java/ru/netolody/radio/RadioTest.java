package ru.netolody.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/currentStation.csv")

    public void limitValuesCurrentStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/switchingStation.csv")

    public void switchingStationUp(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.next();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/switchingStationDown.csv")

    public void switchingStationDown(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.prev();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/limitValuesCurrentVolume.csv")

    public void limitValuesCurrentVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/increaseVolume.csv")

    public void increaseVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.increaseVolume();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/decreaseVolume.csv")

    public void decreaseVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
