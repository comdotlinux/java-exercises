package com.linux.test.serialization.inheritance;

/**
 * This class is not {@linkplain Serializable}
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class NonSerializableEntity {
    private String objectFromNonSerializableClass;
    
    private int primitiveFromNonSerializableClass;

    public String getObjectFromNonSerializableClass() {
        return objectFromNonSerializableClass;
    }

    public void setObjectFromNonSerializableClass(String objectFromNonSerializableClass) {
        this.objectFromNonSerializableClass = objectFromNonSerializableClass;
    }

    public int getPrimitiveFromNonSerializableClass() {
        return primitiveFromNonSerializableClass;
    }

    public void setPrimitiveFromNonSerializableClass(int primitiveFromNonSerializableClass) {
        this.primitiveFromNonSerializableClass = primitiveFromNonSerializableClass;
    }
    
    
}
