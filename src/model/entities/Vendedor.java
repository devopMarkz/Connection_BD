package model.entities;

import java.time.LocalDateTime;

public class Vendedor {

    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private Double baseSalary;
    private Department department;


    private Vendedor(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.baseSalary = builder.baseSalary;
        this.department = builder.department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", baseSalary=" + getBaseSalary() +
                ", department=" + getDepartment() +
                '}';
    }

    public static class Builder{
        private Long id;
        private String name;
        private LocalDateTime birthDate;
        private Double baseSalary;
        private Department department;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder birthDate(LocalDateTime birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder baseSalary(Double baseSalary) {
            this.baseSalary = baseSalary;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Vendedor build() {
            return new Vendedor(this);
        }

    }
}
