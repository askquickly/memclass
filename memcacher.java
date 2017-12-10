package com.askquickly;
// stored in memory, very fast, available only while app is running
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;

@Author("memCache")
@Version(0.01f)
@ShortName("memcacher")
public class memcacher implements StorageInterface {
@Hide
volatile protected Map<String, Object> map;
@Hide
    volatile protected long lastModified;

    public memcacher()
    {
        map = getMap();
       lastModified = 0;
    }
@Hide
    protected Map<String, Object> getMap()
    {
        return new HashMap<String, Object>();
    }

    synchronized public boolean containsKey(String key)
    {
        return (map.containsKey(key));
    }

    synchronized public void clearAll()
    {
        map = null;
        map = getMap();
        updateLastModified();
    }

    synchronized public void clear(String key)
    {
        map.remove(key);
    }

    synchronized public Object get(String key)
    {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return null;
        }
    }

    synchronized public boolean getBoolean(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (Boolean)value;
            } catch (Exception e) {}
        }

        return false;
    }

    synchronized public byte getByte(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (Byte)value;
            } catch (Exception e) {}
        }

        return 0;
    }

    synchronized public double getDouble(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (Double)value;
            } catch (Exception e) {}
        }

        return 0;
    }

    synchronized public float getFloat(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (Float)value;
            } catch (Exception e) {}
        }

        return 0;
    }

    synchronized public int getInt(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (Integer)value;
            } catch (Exception e) {}
        }

        return 0;
    }

    synchronized public long getLong(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (Long)value;
            } catch (Exception e) {}
        }

        return 0;
    }

    synchronized public String getString(String key)
    {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            try {
                return (String)value;
            } catch (Exception e) {}
        }

        return null;
    }

    synchronized public void putByte(String key, byte value)
    {
        map.put(key, value);
        updateLastModified();
    }
    synchronized public void putInt(String key, int value)
    {
        map.put(key, value);
        updateLastModified();
    }

    synchronized public void putLong(String key, long value)
    {
        map.put(key, value);
        updateLastModified();
    }

    synchronized public void putBoolean(String key, boolean value)
    {
        map.put(key, value);
        updateLastModified();
    }

    synchronized public void putFloat(String key, float value)
    {
        map.put(key, value);
        updateLastModified();
    }

    synchronized public void putDouble(String key, double value)
    {
        map.put(key, value);
        updateLastModified();
    }
    synchronized public void putstrings(String key, String value)
    {
        map.put(key, value);
        updateLastModified();
    }

    protected void updateLastModified()
    {
        lastModified = Calendar.getInstance().getTimeInMillis();
    }
    synchronized public long getLastModified()
    {
        return lastModified;
    }
}
