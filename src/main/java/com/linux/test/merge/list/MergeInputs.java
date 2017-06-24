package com.linux.test.merge.list;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author comdotlinux
 */
public class MergeInputs {

    private final Path lhs;
    private final Path rhs;
    private final Path mergedFile;

    public MergeInputs(Path lhs, Path rhs, Path mergedFile) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.mergedFile = mergedFile;
    }
    
    public void merge() {
        List<String> left  = readFile(lhs);
        List<String> right = readFile(rhs);
        
        System.out.println("com.linux.test.merge.list.MergeInputs.merge() lhs : " + left);
        System.out.println("com.linux.test.merge.list.MergeInputs.merge() rhs : " + right);
        
        int leftSize = left.size();
        int rightSize = right.size();
        int size =  leftSize > rightSize? leftSize : right.size();
        
        List<String> merged = IntStream.range(0, size)
                .mapToObj(i -> ((i % 2 == 0) && i < leftSize) ? left.get(i) : i < rightSize ? right.get(i) : "" )
                .peek(System.out::println)
                .collect(Collectors.toList());
        
        System.out.println("com.linux.test.merge.list.MergeInputs.merge() merged : " + merged);
        try {
            Files.write(mergedFile, merged, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(MergeInputs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<String> readFile(Path input) {
        List<String> lines = Collections.emptyList();
        try {
            lines = readAllLines(input, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(MergeInputs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }

    
    
}
