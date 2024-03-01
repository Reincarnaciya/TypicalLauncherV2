package space.typro.typicallauncher.utils;

import lombok.CustomLog;

@CustomLog
public class RamConverter {

    /**
     * Конвертирует гигабайты в мегабайты
     * @param bytes гигабайты
     * @return мегабайты
     */
    public static float toMegabytes(float bytes) {
        return bytes * 1024;
    }

    /**
     * Преобразует мегабайты в Гигабайты
     * @param bytes Мегабайты
     * @return гигабайты
     */
    public static float toGigabytes(int bytes) {
        return (float) bytes / 1024;
    }

}
