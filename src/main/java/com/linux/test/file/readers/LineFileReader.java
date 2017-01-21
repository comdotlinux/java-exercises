package com.linux.test.file.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author comdotlinux
 */
public class LineFileReader {

    private final Path path;

    private LineFileReader(Path path) {
        this.path = path;
    }
    
    public static LineFileReader getinstance(Path path) {
        return new LineFileReader(path);
    }
    
    public Stream<String> getLines() {
        try {
            return Files.lines(path);
        } catch (IOException ex) {
            Logger.getLogger(LineFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Stream.empty();
    }
    
}
