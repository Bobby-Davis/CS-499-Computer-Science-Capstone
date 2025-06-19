package com.animals.rescue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "animals")
public class Animal {
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    @Size(max = 30, message = "Name must be less than 30 characters")
    private String name;

    @NotBlank(message = "Animal type is required")
    private String type;                //dog or monkey

    @NotBlank(message = "Animal breed or species is required")
    @Size(max = 50, message = "Breed or species must be less than 50 characters")
    private String breedOrSpecies;

    @NotBlank(message = "Gender is required")    
    private String gender;

    @Min(value = 0, message = "Age must be non-negative")
    private int age;

    @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
    private Float weight;

    @NotBlank(message = "Acquisition date is required")
    private String acquisitionDate;

    @NotBlank(message = "Training status is required")
    private String trainingStatus;

    private boolean reserved;

    @NotBlank(message = "In-service location is required")
    private String inServiceLocation;

    private String image;

    // Monkey-specific fields


    @DecimalMin(value = "0.0", inclusive = false, message = "Height must be positive")
    private Float height;

    @DecimalMin(value = "0.0", inclusive = false, message = "Tail length must be positive")
    private Float tailLength;

    @DecimalMin(value = "0.0", inclusive = false, message = "Body length must be positive")
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
