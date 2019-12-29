package eu.com.cwsfe.serialization.example;

import java.io.Serializable;

public class PojoData implements Serializable {

    private String code;
    private byte[] someData;
    private int intValue;
    private float floatValue;
    private double doubleValue;
    private PojoInternalData pojoInternalData;
    private byte[] hugeValue;

    /**
     * Empty constructor for serialization
     */
    public PojoData() {
    }

    public PojoData(String code, byte[] someData, int intValue, float floatValue, double doubleValue, PojoInternalData pojoInternalData, byte[] hugeValue) {
        this.code = code;
        this.someData = someData;
        this.intValue = intValue;
        this.floatValue = floatValue;
        this.doubleValue = doubleValue;
        this.pojoInternalData = pojoInternalData;
        this.hugeValue = hugeValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getSomeData() {
        return someData;
    }

    public void setSomeData(byte[] someData) {
        this.someData = someData;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public PojoInternalData getPojoInternalData() {
        return pojoInternalData;
    }

    public void setPojoInternalData(PojoInternalData pojoInternalData) {
        this.pojoInternalData = pojoInternalData;
    }

    public byte[] getHugeValue() {
        return hugeValue;
    }

    public void setHugeValue(byte[] hugeValue) {
        this.hugeValue = hugeValue;
    }
}
