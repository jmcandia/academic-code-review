package edu.fixture.patitas.model;

public final class Pet {
    private String name;
    private int age;
    private double weight;

    public Pet() {}
    public Pet(String name, int age, double weight) {
        setName(name); setAge(age); setWeight(weight);
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        this.name = name.trim();
    }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive");
        this.weight = weight;
    }
}
