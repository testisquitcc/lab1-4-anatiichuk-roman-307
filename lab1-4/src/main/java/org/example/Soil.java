package org.example;

import java.util.Objects;

public class Soil {
    private String name;

    public Soil() {}

    public Soil(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soil soil = (Soil) o;
        return Objects.equals(name, soil.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Soil{" +
                "name='" + name + '\'' +
                '}';
    }
}
