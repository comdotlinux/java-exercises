package com.linux.test.file.readers;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

/**
 * Unit tests to learn / remember reading files.
 * 
 * @author comdotlinux
 */
public class FileReadertest {
    
    private static final String INPUT_FILE_RELATIVE_PATH = "src/test/resources/com/linux/file/readers/testFile";

    @Test
    public void readlinesTest() throws URISyntaxException {
        Path path = Paths.get(new File(INPUT_FILE_RELATIVE_PATH).toURI());
        Stream<String> stream = LineFileReader.getInstance(path).getLines();
        List<String> lines = stream.peek(System.out::println).collect(Collectors.toList());
        
        assertThat(lines.size(), is(5));

    }
    
    @Test
    public void readFileUsingbufferedReader() {
        List<String> lines = LineFileReader.getInstance().getLines(INPUT_FILE_RELATIVE_PATH);
        
        lines.stream().forEach(System.out::println);
        assertThat(lines.size(), is(5));
    }
    

}
