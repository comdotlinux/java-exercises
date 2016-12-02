package com.linux.test.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author guru.a.kulkarni
 */
public class ManualSort {

    private List<String> cities;
    
    @Before
    public void init() {
        this.cities = Arrays.asList("P","A","D", "D", "P", "A");
    }
    
    
    @Test
    public void manualSort() {
        
        Collections.sort(cities, new Comparator<String>() {
            @Override
            public int compare(String t, String t1) {
                System.out.println(".compare() t = " + t + "  :: t1 = " + t1);
                if(t.equalsIgnoreCase(t1)) {
                    return 0;
                } else if("D".equals(t) && ("A".equals(t1) || "P".equals(t1))){
                    return -1;
                } else if("A".equals(t) && "P".equals(t1)) {
                    return -1;
                } else if("P".equals(t)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            
        });
        
        System.out.println("com.linux.test.sorting.ManualSort.manualSort()" + cities);
        
    }
    
}
