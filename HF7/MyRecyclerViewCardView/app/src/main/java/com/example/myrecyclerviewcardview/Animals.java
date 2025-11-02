package com.example.myrecyclerviewcardview;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private String name;
    private int image;
    private String description;

    public Animals(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Animals> getAnimals() {
        List<Animals> animals = new ArrayList<>();
        animals.add(new Animals("Cat", R.drawable.cat, "Cica"));
        animals.add(new Animals("Pig", R.drawable.disznyo, "Malac"));
        animals.add(new Animals("Dog", R.drawable.dog, "Kutya"));
        animals.add(new Animals("Giraffe", R.drawable.giraffe, "Zsiráf"));
        animals.add(new Animals("Horse", R.drawable.horse, "Ló"));
        animals.add(new Animals("Lion", R.drawable.lion, "Oroszlán"));
        animals.add(new Animals("Octopus 1", R.drawable.octopus, "Polip 1"));
        animals.add(new Animals("Octopus 2", R.drawable.octopus2, "Polip 2"));
        animals.add(new Animals("Octopus 3", R.drawable.octopus3, "Polip 3"));
        animals.add(new Animals("Rabbit", R.drawable.rabbit, "Nyuszi"));
        animals.add(new Animals("Sheep", R.drawable.sheep, "Birka"));
        return animals;
    }
}
