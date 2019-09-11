package com.linux.test.merge.list;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author comdotlinux
 */
public class MergeInputsTest {
    
    
    /**
     * Test of merge method, of class MergeInputs.
     */
    @Test
    public void testMerge() throws IOException {
        System.out.println("testMerge");
        
        Path base = Paths.get("src/test/resources/com/linux/test/merge/list");
        Path lhs = Paths.get(base.toString(), "lhs.csv");
        System.out.println("com.linux.test.merge.list.MergeInputsTest.testMerge() :: lhs : " + lhs.toAbsolutePath().toString());
        Path rhs = Paths.get(base.toString(),"rhs.csv");
        System.out.println("com.linux.test.merge.list.MergeInputsTest.testMerge() :: lhs : " + rhs.toAbsolutePath().toString());
        Path mergedFile = Paths.get(base.toString(), "merged.csv");
        System.out.println("com.linux.test.merge.list.MergeInputsTest.testMerge() :: merged file : " + mergedFile.toAbsolutePath().toString());
        
        MergeInputs instance = new MergeInputs(lhs, rhs, mergedFile);
        instance.merge();
        assertThat(Files.exists(mergedFile), is(true));
        List<String> readAllLines = Files.readAllLines(mergedFile);
        List<String> lhsLines = Files.readAllLines(lhs);
        List<String> rhsLines = Files.readAllLines(rhs);
        assertThat(readAllLines.size(), is(lhsLines.size() + rhsLines.size()));
    }
    
    /**
     * Test of merge method, of class MergeInputs.
     */
    @Test
    public void testMergeLhsShort() throws IOException {
        System.out.println("testMergeLhsShort");
        
        Path base = Paths.get("src/test/resources/com/linux/test/merge/list");
        Path lhs = Paths.get(base.toString(), "lhsShort.csv");
        System.out.println("com.linux.test.merge.list.MergeInputsTest.testMerge() :: lhs : " + lhs.toAbsolutePath().toString());
        Path rhs = Paths.get(base.toString(),"rhs.csv");
        System.out.println("com.linux.test.merge.list.MergeInputsTest.testMerge() :: lhs : " + rhs.toAbsolutePath().toString());
        Path mergedFile = Paths.get(base.toString(), "mergedShort.csv");
        System.out.println("com.linux.test.merge.list.MergeInputsTest.testMerge() :: merged file : " + mergedFile.toAbsolutePath().toString());
        
        MergeInputs instance = new MergeInputs(lhs, rhs, mergedFile);
        instance.merge();
        assertThat(Files.exists(mergedFile), is(true));
        
        int mergedLinesCount = Files.readAllLines(mergedFile).size();
        int lhsLinesSize = Files.readAllLines(lhs).size();
        int rhsLinesSize = Files.readAllLines(rhs).size();
        assertThat(mergedLinesCount, is(lhsLinesSize + rhsLinesSize));
    }
    
}
