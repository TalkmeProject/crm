package com.hlebik.crm.enumerated;

import java.lang.reflect.Method;

public enum  Status {
    ACTIVE("ACTIVE"), DISABLE("DISABLE");

    private String description;

      Status(String description) {
        this.description = description;
    }

    public String getValue() {
        return name();
    }

    public String getStatus() {
        return description;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static <T extends Enum<T>> Enum<T>[] getValues(Class<T> klass) {
        try {
            Method m = klass.getMethod("values", null);
            Object obj = m.invoke(null, null);
            return (Enum<T>[])obj;
        } catch(Exception ex) {
            //shouldn't happen...
            return null;
        }
    }
}
