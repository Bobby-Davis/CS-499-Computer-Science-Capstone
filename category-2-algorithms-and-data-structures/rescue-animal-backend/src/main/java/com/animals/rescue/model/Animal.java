package com.animals.rescue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animals")
public class Animal {
    @Id
    private String id;

    private String name;
    private String type;                //dog or monkey
    private String breedOrSpecies;
    private String gender;
    private int age;
    private Float weight;
    private String acquisitionDate;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceLocation;
    private String image;

    // Monkey-specific fields
    private Float height;
    private Float tailLength;
    private Float bodyLength;

    // Constuctors
    public Animal() {}

    public Animal(String name, String type, String breedOrSpecies, String gender, int age, Float weight,
                  String acquisitionDate, String trainingStatus, boolean reserved, String inServiceLocation, 
                  String image, Float height, Float tailLength, Float bodyLength) {
        this.name = name;
        this.breedOrSpecies = breedOrSpecies;
        this.age = age;
        this.trainingStatus = trainingStatus;
        this.image = image;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreedOrSpecies() {
        return breedOrSpecies;
    }

    public void setBreedOrSpecies(String breedOrSpecies) {
        this.breedOrSpecies = breedOrSpecies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getInServiceLocation() {
        return inServiceLocation;
    }

    public void setInServiceLocation(String inServiceLocation) {
        this.inServiceLocation = inServiceLocation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    /*********************************
        Monkey
    **********************************/
    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getTailLength() {
        return tailLength;
    }

    public void setTailLength(Float tailLength) {
        this.tailLength = tailLength;
    }

    public Float getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(Float bodyLength) {
        this.bodyLength = bodyLength;
    }
}
