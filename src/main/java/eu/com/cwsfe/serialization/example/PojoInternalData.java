package eu.com.cwsfe.serialization.example;

import java.io.Serializable;

public class PojoInternalData implements Serializable {

    private boolean someBoolean;

    /**
     * Empty constructor for serialization
     */
    public PojoInternalData() {
    }

    public PojoInternalData(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }
}
