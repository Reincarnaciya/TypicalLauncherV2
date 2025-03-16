package space.typro.typicallauncher.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static space.typro.typicallauncher.managers.DirManager.logDir;

public class Logger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String loggerName;

    public Logger(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Logger name cannot be null");
        }
        this.loggerName = name;
    }

    public static Logger getLogger(String loggerName) {
        return new Logger(loggerName);
    }

    public void info(Object message) {
        log("INFO", message);
    }

    public void info(Object message, Exception e) {
        log("INFO", message, e);
    }

    public void warn(Object message) {
        log("WARNING", message);
    }

    public void warn(Object message, Exception e) {
        log("WARNING", message, e);
    }

    public void error(Object message) {
        log("ERROR", message);
    }

    public void error(Object message, Exception e) {
        log("ERROR", message, e);
    }

    private void log(String level, Object message) {
        String timestamp = ZonedDateTime.now(ZoneId.of("Europe/Moscow")).format(formatter);
        String formattedMessage = String.format("[%s] [%s] in [%s]: %s", timestamp, level, loggerName, message);
        System.out.println(formattedMessage);
    }

    private void log(String level, Object message, Exception e) {
        log(level, message);
        e.printStackTrace();
    }

    public static void initLogger() throws IOException {
        PrintStream out = new PrintStream(Files.newOutputStream(getLogFile().toPath()));
        PrintStream dual = new DualStream(System.out, out);
        System.setOut(dual);
        System.setErr(new DualStream(System.err, out));
    }

    private static File getLogFile() throws IOException {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        String logfile = now.format(formatter)
                .replace(":", "-")
                .replace("]", "")
                .replace("[", "")
                .replace(".", "")
                .replace("/", "-")
                + ".log";

        File log = new File(logDir + File.separator + "log_" + logfile);
        if (!log.exists()) {
            log.createNewFile();
        }

        return log;
    }

    static class DualStream extends PrintStream {
        private final PrintStream out;

        public DualStream(PrintStream out1, PrintStream out2) {
            super(out1);
            this.out = out2;
        }

        @Override
        public void write(byte[] buf, int off, int len) {
            try {
                super.write(buf, off, len);
                out.write(buf, off, len);
            } catch (Exception e) {
                System.err.println("Error in DualStream: " + e.getMessage());
            }
        }

        @Override
        public void flush() {
            super.flush();
            out.flush();
        }
    }
}