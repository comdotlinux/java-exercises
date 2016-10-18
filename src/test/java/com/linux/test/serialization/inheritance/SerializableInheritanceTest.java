package com.linux.test.serialization.inheritance;

import com.linux.test.serialization.inheritance.SerializableEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class SerializableInheritanceTest {

    @Before
    public void setUp() {
    }

    /**
     * Test of getObjectFromSerializableEntity method, of class SerializableEntity.
     */
    @Test
    public void testSerializableEntity() throws IOException, ClassNotFoundException {
        System.out.println("testSerializableEntity");
        //Arrange
        SerializableEntity underTest = new SerializableEntity();
        underTest.setObjectFromNonSerializableClass("abc");
        underTest.setPrimitiveFromSerializableEntity(123);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        
        //Act
        oos.writeObject(underTest);
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        Object actual = new ObjectInputStream(byteArrayInputStream).readObject();
        //Assert
        assertThat(oos, is(notNullValue()));
        assertThat(actual, instanceOf(SerializableEntity.class));
        assertThat(((SerializableEntity)actual).getObjectFromNonSerializableClass(),is(equalTo(underTest.getObjectFromSerializableEntity())));
    }

    /**
     * Test of setObjectFromSerializableEntity method, of class SerializableEntity.
     */
    @Ignore
    @Test
    public void testSetObjectFromSerializableEntity() {
        System.out.println("setObjectFromSerializableEntity");
        String objectFromSerializableEntity = "";
        SerializableEntity instance = new SerializableEntity();
        instance.setObjectFromSerializableEntity(objectFromSerializableEntity);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimitiveFromSerializableEntity method, of class SerializableEntity.
     */
    @Test
    public void testGetPrimitiveFromSerializableEntity() {
        System.out.println("getPrimitiveFromSerializableEntity");
        SerializableEntity instance = new SerializableEntity();
        int expResult = 0;
        int result = instance.getPrimitiveFromSerializableEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrimitiveFromSerializableEntity method, of class SerializableEntity.
     */
    @Test
    public void testSetPrimitiveFromSerializableEntity() {
        System.out.println("setPrimitiveFromSerializableEntity");
        int primitiveFromSerializableEntity = 0;
        SerializableEntity instance = new SerializableEntity();
        instance.setPrimitiveFromSerializableEntity(primitiveFromSerializableEntity);
    }

}