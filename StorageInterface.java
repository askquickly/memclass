package com.askquickly;
import anywheresoftware.b4a.BA.Hide;
public interface StorageInterface
{
    public boolean containsKey(String key);

    public void clearAll();

    public void clear(String key);

    public void putByte(String key, byte value);

    public void putInt(String key, int value);

    public void putLong(String key, long value);

    public void putBoolean(String key, boolean value);

    public void putFloat(String key, float value);

    public void putDouble(String key, double value);

    public void putstrings(String key, String value);

    public Object get(String key);

    public byte getByte(String key);

    public int getInt(String key);

    public long getLong(String key);

    public boolean getBoolean(String key);

    public float getFloat(String key);

    public double getDouble(String key);

    public String getString(String key);

    public long getLastModified();
}
