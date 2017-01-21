package com.linux.test.file.readers;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.Test;

/**
 *
 * @author comdotlinux
 */
public class FileReadertest {

    @Test
    public void readlinesTest() throws URISyntaxException {
        URI uri = new URI("file://testFile");
        LineFileReader.getinstance(Paths.get(uri)).getLines().forEach(System.out::print);

    }

}
