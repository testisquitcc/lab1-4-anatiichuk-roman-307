package org.example.service;

import org.example.Fertilizer;
import org.example.Flower;
import org.example.Soil;

import java.util.List;

public interface Service {
    List<Soil> extractSoils(List<Flower> flowers);
    List<Fertilizer> extractFertilizers(List<Flower> flowers);
    List<Flower> sortByWaterEvery(List<Flower> flowers);
    List<Flower> filterFlowersBySoil(List<Flower> flowers, Soil soil);
    List<Flower> filterFlowersByFertilizer(List<Flower> flowers, Fertilizer fertilizer);

}
