package com.linux.test.enums.sort;

import static com.linux.test.enums.sort.Alphabet.*;
import java.util.ArrayList;
import static java.util.Collections.*;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author guru.a.kulkarni
 */
public class AphabetSortTest {
    
    @Test
    public void defaultEnumSortTest() {
        List<Alphabet> al = new ArrayList<>();
        al.add(Z);
        al.add(S);
        al.add(F);
        al.add(G);
        al.add(A);
        List<Alphabet> alo = unmodifiableList(al);
        sort(al);
        
        assertThat(al, is(notNullValue()));
        assertThat(al, hasItems(F,S,Z));
        System.out.println(al);
    }
    
    @Test
    public void defaultEnumNameSortTest() {
        List<Alphabet> al = new ArrayList<>();
        al.add(Z);
        al.add(S);
        al.add(F);
        al.add(G);
        al.add(A);
        List<Alphabet> alo = unmodifiableList(al);
        sort(al, (t, t1) -> {
            return t.name().compareTo(t1.name());
        });
        
        assertThat(al, is(notNullValue()));
        assertThat(al, hasItems(F,S,Z));
//        assertThat(al, )
        System.out.println(al);
    }
    
}
