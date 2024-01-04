package org.example.service;

import org.example.Fertilizer;
import org.example.Flower;
import org.example.Soil;

import java.util.*;

public class StreamAPIService implements Service{
    @Override
    public List<Soil> extractSoils(List<Flower> flowers) {
        return flowers.stream().collect(HashSet<Soil>::new,
                (soils, flower) -> soils.addAll(flower.getSuitableSoils()), HashSet::addAll)
                .stream().toList();
    }

    @Override
    public List<Fertilizer> extractFertilizers(List<Flower> flowers) {
        return flowers.stream().collect(HashSet<Fertilizer>::new,
                                        (soils, flower) -> soils.addAll(flower.getSuitableFertilizers()), HashSet::addAll)
                .stream().toList();
    }

    @Override
    public List<Flower> sortByWaterEvery(List<Flower> flowers) {
        return flowers.stream().sorted(Comparator.comparing(Flower::getWaterEvery)).toList();
    }

    @Override
    public List<Flower> filterFlowersBySoil(List<Flower> flowers, Soil soil) {
        return flowers.stream().filter((flower -> flower.getSuitableSoils().contains(soil))).toList();
    }

    @Override
    public List<Flower> filterFlowersByFertilizer(List<Flower> flowers, Fertilizer fertilizer) {
        return flowers.stream().filter((flower -> flower.getSuitableFertilizers().contains(fertilizer))).toList();
    }
}
