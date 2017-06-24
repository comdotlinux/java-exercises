/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linux.test.merge.list;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author comdotlinux
 */
public class MergeInputsTest {
    
    
    /**
     * Test of merge method, of class MergeInputs.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        
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
    }
    
}
