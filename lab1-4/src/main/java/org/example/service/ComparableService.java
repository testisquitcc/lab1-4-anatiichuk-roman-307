package org.example.service;

import org.example.Fertilizer;
import org.example.Flower;
import org.example.Soil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableService implements Service{
    @Override
    public List<Soil> extractSoils(List<Flower> flowers) {
        List<Soil> soils = new ArrayList<>();
        for (var flower: flowers) {
            for (var soil: flower.getSuitableSoils()) {
                if (!soils.contains(soil)) {
                    soils.add(soil);
                }
            }
        }

        return soils;
    }

    @Override
    public List<Fertilizer> extractFertilizers(List<Flower> flowers) {
        List<Fertilizer> fertilizers = new ArrayList<>();
        for (var flower: flowers) {
            for (var fertilizer: flower.getSuitableFertilizers()) {
                if (!fertilizers.contains(fertilizer)) {
                    fertilizers.add(fertilizer);
                }
            }
        }

        return fertilizers;
    }

    @Override
    public List<Flower> sortByWaterEvery(List<Flower> flowers) {
        flowers.sort(Comparator.comparing(Flower::getWaterEvery));
        return flowers;
    }

    @Override
    public List<Flower> filterFlowersBySoil(List<Flower> flowers, Soil soil) {
        List<Flower> filtered = new ArrayList<>();
        for (var flower: flowers) {
            if (flower.getSuitableSoils().contains(soil)) {
                filtered.add(flower);
            }
        }

        return filtered;
    }

    @Override
    public List<Flower> filterFlowersByFertilizer(List<Flower> flowers, Fertilizer fertilizer) {
        List<Flower> filtered = new ArrayList<>();
        for (var flower: flowers) {
            if (flower.getSuitableFertilizers().contains(fertilizer)) {
                filtered.add(flower);
            }
        }

        return filtered;
    }
}
