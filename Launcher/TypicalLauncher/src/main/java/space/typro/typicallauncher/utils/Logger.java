package space.typro.typicallauncher.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String loggerName;


    public Logger(String name){
        loggerName = name;
    }


    public void logInfo(String message) {
        String timestamp = ZonedDateTime.now(ZoneId.of("Europe/Moscow")).format(formatter);
        String formattedMessage = String.format("[%s] [INFO] in [%s]: %s", timestamp, loggerName, message);
        System.out.println(formattedMessage);
    }

    public void logWarning(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [WARNING] in [%s]: %s", timestamp, loggerName, message);
        System.out.println(formattedMessage);
    }

    public void logError(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [ERROR] in [%s]: %s", timestamp, loggerName, message);
        System.err.println(formattedMessage);
    }


    public static void initLogger() throws IOException {
        // запись в файл и вывод в консоль
        PrintStream out = new PrintStream(Files.newOutputStream(getLogFile().toPath())); //TODO: Фикси нуллпоинтер

        PrintStream dual = new DualStream(System.out, out);
        System.setOut(dual);

        dual = new DualStream(System.err, out);
        System.setErr(dual);
    }

    private static File getLogFile() { //TODO: Реализовать функционал
        return null;
    }



    static class DualStream extends PrintStream{
        final PrintStream out;

        public DualStream(PrintStream out1, PrintStream out2) {
            super(out1);
            this.out = out2;
        }

        public void write(byte[] buf, int off, int len) {
            try {
                super.write(buf, off, len);
                out.write(buf, off, len);
            } catch (Exception ignored) {}
        }

        public void flush() {
            super.flush();
            out.flush();
        }
    }
}
