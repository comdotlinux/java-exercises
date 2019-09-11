package com.linux.test.file.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    
    private LineFileReader() {
        this(null);
    }
    
    public static LineFileReader getInstance(Path path) {
        return new LineFileReader(path);
    }
    
    public static LineFileReader getInstance() {
        return new LineFileReader();
    }
    
    public Stream<String> getLines() {
        try {
            return Files.lines(path);
        } catch (IOException ex) {
            Logger.getLogger(LineFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Stream.empty();
    }
    
    public List<String> getLines(String filePath) {
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> fileLines = new ArrayList<>();
            
            String readLine;
            do {
                readLine = br.readLine();
                if (null != readLine) {
                    fileLines.add(readLine);
                }
            } while (readLine != null);
            
            return fileLines;
        } catch (IOException ex) {
            Logger.getLogger(LineFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Collections.emptyList();
    }
    
}
