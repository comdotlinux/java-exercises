package com.linux.test.serialization.inheritance;

import java.io.Serializable;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class SerializableEntity extends NonSerializableEntity implements Serializable {
    
    private static final long serialVersionUID = 14566725234512345l;
    
    private String objectFromSerializableEntity;
    
    private int primitiveFromSerializableEntity;

    public String getObjectFromSerializableEntity() {
        return objectFromSerializableEntity;
    }

    public void setObjectFromSerializableEntity(String objectFromSerializableEntity) {
        this.objectFromSerializableEntity = objectFromSerializableEntity;
    }

    public int getPrimitiveFromSerializableEntity() {
        return primitiveFromSerializableEntity;
    }

    public void setPrimitiveFromSerializableEntity(int primitiveFromSerializableEntity) {
        this.primitiveFromSerializableEntity = primitiveFromSerializableEntity;
    }
    
    
}
