package space.typro.typicallauncher.utils;

import lombok.CustomLog;

@CustomLog
public class RamConverter {

    /**
     * Конвертирует гигабайты в мегабайты.
     *
     * @param gigabytes Количество гигабайт.
     * @return Количество мегабайт.
     */
    public static float toMegabytes(float gigabytes) {
        if (gigabytes < 0) {
            throw new IllegalArgumentException("Gigabytes cannot be negative");
        }
        return gigabytes * 1024;
    }

    /**
     * Преобразует мегабайты в гигабайты.
     *
     * @param megabytes Количество мегабайт.
     * @return Количество гигабайт.
     */
    public static float toGigabytes(int megabytes) {
        if (megabytes < 0) {
            throw new IllegalArgumentException("Megabytes cannot be negative");
        }
        return (float) megabytes / 1024;
    }
}