package org.example;

import org.example.serialization.JsonSerializer;
import org.example.serialization.TxtSerializer;
import org.example.serialization.XmlSerializer;
import org.example.service.ComparableService;
import org.example.service.StreamAPIService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // lab1
        Soil universal = new Soil("Universal soil");
        Soil substrate = new Soil("Deoxygenated substrate");
        Soil microorg = new Soil("Soil with microorganisms");
        Soil peat = new Soil("Peat soil");

        Fertilizer stimul = new Fertilizer("Stimul", "");
        Fertilizer liquid = new Fertilizer("Liquid fertilizer", "");
        Fertilizer superphosphate = new Fertilizer("Superphosphate", "");
        Fertilizer organic = new Fertilizer("Organic fertilizer", "");

        Flower flower1 = new Flower.FlowerBuilder()
                .setName("Oleander")
                .addSuitableSoil(universal)
                .addSuitableSoil(substrate)
                .addSuitableFertilizer(organic)
                .setWaterEvery(Duration.ofDays(2))
                .setLastWater(LocalDateTime.now())
                .build();

        Flower flower2 = new Flower.FlowerBuilder()
                .setName("Chrysanthemums")
                .addSuitableSoil(universal)
                .addSuitableSoil(microorg)
                .addSuitableFertilizer(superphosphate)
                .addSuitableFertilizer(liquid)
                .setWaterEvery(Duration.ofDays(1))
                .setLastWater(LocalDateTime.now())
                .build();

        Flower flower3 = new Flower.FlowerBuilder()
                .setName("Lavater")
                .addSuitableSoil(peat)
                .addSuitableFertilizer(stimul)
                .setWaterEvery(Duration.ofHours(6))
                .setLastWater(LocalDateTime.now())
                .build();

        try {
            // lab4
            Flower flower4 = new Flower.FlowerBuilder()
                    .setName("Peonies")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(flower1);
        System.out.println(flower2);
        System.out.println(flower3);

        ArrayList<Flower> flowers = new ArrayList<>();
        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);

        System.out.println();


        // lab3
        StreamAPIService streamAPIService = new StreamAPIService();
        ComparableService comparableService = new ComparableService();

        System.out.println("\nExtracted soils: ");
        System.out.println(comparableService.extractSoils(flowers));
        System.out.println(streamAPIService.extractSoils(flowers));

        System.out.println("\nExtracted fertilizers: ");
        System.out.println(comparableService.extractFertilizers(flowers));
        System.out.println(streamAPIService.extractFertilizers(flowers));

        System.out.println("\nSorted by Flower::waterEvery");
        System.out.println(comparableService.sortByWaterEvery(flowers));
        System.out.println(streamAPIService.sortByWaterEvery(flowers));

        System.out.println("\nFlowers for which liquid fertilizer is suitable:");
        System.out.println(comparableService.filterFlowersByFertilizer(flowers, liquid));
        System.out.println(streamAPIService.filterFlowersByFertilizer(flowers, liquid));

        System.out.println("\nFlowers for which universal soil is suitable:");
        System.out.println(comparableService.filterFlowersBySoil(flowers, universal));
        System.out.println(streamAPIService.filterFlowersBySoil(flowers, universal));

        System.out.println("\n\n");


        // Lab 2
        String str;


        JsonSerializer<Flower> jsonSerializer = new JsonSerializer<>(Flower.class);
        System.out.println("JSON:");
        str = jsonSerializer.serialize(flower1);
        System.out.println(str);
        System.out.println(jsonSerializer.deserialize(str));


        XmlSerializer<Soil> xmlSerializer = new XmlSerializer<>(Soil.class);
        System.out.println("XML:");
        str = xmlSerializer.serialize(universal);
        System.out.println(str);
        System.out.println(xmlSerializer.deserialize(str));

        System.out.println("TXT:");
        TxtSerializer<Fertilizer> txtSerializer = new TxtSerializer<>();
        str = txtSerializer.serialize(liquid);
        System.out.println(str);
        System.out.println(txtSerializer.deserialize(str));
    }
}