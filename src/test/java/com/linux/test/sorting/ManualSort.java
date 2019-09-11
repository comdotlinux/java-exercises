package com.linux.test.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author guru.a.kulkarni
 */
public class ManualSort {

    private static final Comparator<String> MANUAL_SORTER = new Comparator<String>() {
            @Override
            public int compare(String t, String t1) {
                System.out.println(".compare() t = " + t + "  :: t1 = " + t1);
                if(t.equalsIgnoreCase(t1)) {
                    return 0;
                } else if("D".equals(t) && ("A".equals(t1) || "P".equals(t1))){
                    return -1;
                } else if("A".equals(t) && "P".equals(t1)) {
                    return -1;
                } else if("A".equals(t) && "D".equals(t1)) {
                    return 1;
                } else if("P".equals(t)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            
        };
    
    @Test
    public void manualSort() {
        List<String> cities = Arrays.asList("P","A","D", "D", "P", "A");
        Collections.sort(cities, MANUAL_SORTER);
        
        
        assertThat(cities.get(0), is("D"));
        assertThat(cities.get(1), is("D"));
        
        assertThat(cities.get(2), is("A"));
        assertThat(cities.get(3), is("A"));
        
        assertThat(cities.get(4), is("P"));
        assertThat(cities.get(5), is("P"));
        
        System.out.println("com.linux.test.sorting.ManualSort.manualSort()" + cities);
        
    }
    
    @Test
    public void manualSortSecondCheck() {
        List<String> cities = Arrays.asList("A","A","D", "D", "P", "P");
        Collections.sort(cities, MANUAL_SORTER);
        
        
        assertThat(cities.get(0), is("D"));
        assertThat(cities.get(1), is("D"));
        
        assertThat(cities.get(2), is("A"));
        assertThat(cities.get(3), is("A"));
        
        assertThat(cities.get(4), is("P"));
        assertThat(cities.get(5), is("P"));
        
        System.out.println("com.linux.test.sorting.ManualSort.manualSort()" + cities);
        
    }
    
    @Test
    public void manualSortThirdCheck() {
        List<String> cities = Arrays.asList("P","D","D", "A", "A", "P");
        Collections.sort(cities, MANUAL_SORTER);
        
        
        assertThat(cities.get(0), is("D"));
        assertThat(cities.get(1), is("D"));
        
        assertThat(cities.get(2), is("A"));
        assertThat(cities.get(3), is("A"));
        
        assertThat(cities.get(4), is("P"));
        assertThat(cities.get(5), is("P"));
        
        System.out.println("com.linux.test.sorting.ManualSort.manualSort()" + cities);
        
    }
    
    @Test
    public void manualSortFourthCheck() {
        List<String> cities = Arrays.asList("A","D","A", "P", "D", "P");
        Collections.sort(cities, MANUAL_SORTER);
        
        
        assertThat(cities.get(0), is("D"));
        assertThat(cities.get(1), is("D"));
        
        assertThat(cities.get(2), is("A"));
        assertThat(cities.get(3), is("A"));
        
        assertThat(cities.get(4), is("P"));
        assertThat(cities.get(5), is("P"));
        
        System.out.println("com.linux.test.sorting.ManualSort.manualSort()" + cities);
        
    }
}
