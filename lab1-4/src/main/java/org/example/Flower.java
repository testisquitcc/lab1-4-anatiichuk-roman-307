package org.example;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class Flower {
    @NotNull(message="should not be null")
    private String name;
    @NotNull(message="should not be null")
    @Size(min=1, message="size should be greater than or equal to {min}")
    private ArrayList<Soil> suitableSoils;
    @NotNull(message="should not be null")
    @Size(min=1, message="size should be greater than or equal to {min}")
    private ArrayList<Fertilizer> suitableFertilizers;
    @NotNull(message="should not be null")
    private Duration waterEvery;
    @NotNull(message="should not be null")
    private LocalDateTime lastWater;

    public Flower(String name, ArrayList<Soil> suitableSoils, ArrayList<Fertilizer> suitableFertilizers,
                  Duration waterEvery, LocalDateTime lastWater) {
        this.name = name;
        this.suitableSoils = suitableSoils;
        this.suitableFertilizers = suitableFertilizers;
        this.waterEvery = waterEvery;
        this.lastWater = lastWater;
    }

    // for json/xml deserialization
    public Flower() {}

    public static class FlowerBuilder {
        private String name;
        private final ArrayList<Soil> suitableSoils = new ArrayList<>();
        private final ArrayList<Fertilizer> suitableFertilizers = new ArrayList<>();
        private Duration waterEvery;
        private LocalDateTime lastWater;

        /**
         * Build the flower.
         * @return built flower
         */
        public Flower build() {
            var flower =  new Flower(this.name, this.suitableSoils, this.suitableFertilizers, this.waterEvery, this.lastWater);


            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Flower>> constraintViolations = validator.validate(flower);

            if (constraintViolations.isEmpty()) return flower;

            StringBuilder exception = new StringBuilder();
            for (var constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString();
                exception.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("; ");
            }

            throw new IllegalArgumentException(exception.toString());

        }

        /**
         * Set the name of the flower
         * @param name the name to be set
         * @return FlowerBuilder
         */
        public FlowerBuilder setName(String name) {
            this.name = name;
            return this;
        }


        /**
         * Add a soil to the suitable soil list
         * @param soil soil to be added to the list
         * @return FlowerBuilder
         */
        public FlowerBuilder addSuitableSoil(Soil soil) {
            suitableSoils.add(soil);
            return this;
        }

        /**
         * Add a fertilizer ro the suitable fertilizer list
         * @param fertilizer fertilizer to ve added to the list
         * @return FlowerBuilder
         */
        public FlowerBuilder addSuitableFertilizer(Fertilizer fertilizer) {
            this.suitableFertilizers.add(fertilizer);
            return this;
        }

        /**
         * Set the period the flower needs to be watered
         * @param waterEvery the period
         * @return FlowerBuilder
         */
        public FlowerBuilder setWaterEvery(Duration waterEvery) {
            this.waterEvery = waterEvery;
            return this;
        }

        /**
         * Set when the flower has been watered the last time
         * @param lastWater time
         * @return FlowerBuilder
         */
        public FlowerBuilder setLastWater(LocalDateTime lastWater) {
            this.lastWater = lastWater;
            return this;
        }

    }

    public String getName() {
        return name;
    }

    public ArrayList<Soil> getSuitableSoils() {
        return suitableSoils;
    }

    public ArrayList<Fertilizer> getSuitableFertilizers() {
        return suitableFertilizers;
    }

    public Duration getWaterEvery() {
        return waterEvery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuitableSoils(ArrayList<Soil> suitableSoils) {
        this.suitableSoils = suitableSoils;
    }

    public void setSuitableFertilizers(ArrayList<Fertilizer> suitableFertilizers) {
        this.suitableFertilizers = suitableFertilizers;
    }

    public void setWaterEvery(Duration waterEvery) {
        this.waterEvery = waterEvery;
    }

    public LocalDateTime getLastWater() {
        return lastWater;
    }

    public void setLastWater(LocalDateTime lastWater) {
        this.lastWater = lastWater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(name, flower.name) && Objects.equals(suitableSoils, flower.suitableSoils) && Objects.equals(suitableFertilizers, flower.suitableFertilizers) && Objects.equals(waterEvery, flower.waterEvery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, suitableSoils, suitableFertilizers, waterEvery);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", suitableSoils=" + suitableSoils +
                ", suitableFertilizers=" + suitableFertilizers +
                ", waterEvery=" + waterEvery +
                '}';
    }
}
