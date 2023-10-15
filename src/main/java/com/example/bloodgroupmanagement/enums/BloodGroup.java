package com.example.bloodgroupmanagement.enums;

import java.util.ArrayList;
import java.util.List;

public enum BloodGroup {
    A_POSITIVE("A Positive"),
    A_NEGATIVE("A Negative"),
    B_POSITIVE("B Positive"),
    B_NEGATIVE("B Negative"),
    AB_POSITIVE("AB Positive"),
    AB_NEGATIVE("AB Negative"),
    O_POSITIVE("O Positive"),
    O_NEGATIVE("O Negative");

    private final String value;

    BloodGroup(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getAllValues() {
        List<String> valuesList = new ArrayList<>();
        for (BloodGroup bloodGroup : values()) {
            valuesList.add(bloodGroup.getValue());
        }
        return valuesList;
    }
}
