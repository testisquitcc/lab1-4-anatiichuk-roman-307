package org.example;

import java.util.Objects;

public class Fertilizer {
    private String name;
    private String description;

    public Fertilizer() {}

    public Fertilizer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fertilizer that = (Fertilizer) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "Fertilizer{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
