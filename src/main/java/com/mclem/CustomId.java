package com.mclem;

import java.io.Serializable;

public class CustomId implements Serializable {

    private final String value;

    public CustomId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
