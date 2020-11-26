package com.assecor.assessment.test.model;

public enum Color {
    nocolor(0),
    blau(1),
    gruen(2),
    violett(3),
    rot(4),
    gelb(5),
    tuerkis(6),
    weiß(7);

    public final int value;

    private Color(int value) {
        this.value = value;
    }

    public static Color findByValue(int id) {
        for (Color v : values()) {
            if (v.value == id) {
                return v;
            }
        }
        return nocolor;
    }
    public static Color findByLabel(String label) {
        for (Color v : values()) {
            if (v.name().equals(label)) {
                return v;
            }
        }
        return nocolor;
    }
}
