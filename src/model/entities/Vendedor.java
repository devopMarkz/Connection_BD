package model.entities;

import java.time.LocalDateTime;

/**
 * Classe que representa um vendedor com informações de identificação, nome, data de nascimento,
 * salário base e departamento.
 */
public class Vendedor {

    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private Double baseSalary;
    private Department department;

    /**
     * Construtor privado que cria uma instância de Vendedor a partir de um objeto Builder.
     *
     * @param builder Objeto Builder usado para construir a instância de Vendedor.
     */
    private Vendedor(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.baseSalary = builder.baseSalary;
        this.department = builder.department;
    }

    /**
     * Retorna o ID do vendedor.
     *
     * @return o ID do vendedor.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retorna o nome do vendedor.
     *
     * @return o nome do vendedor.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna a data de nascimento do vendedor.
     *
     * @return a data de nascimento do vendedor.
     */
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    /**
     * Retorna o salário base do vendedor.
     *
     * @return o salário base do vendedor.
     */
    public Double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Retorna o departamento do vendedor.
     *
     * @return o departamento do vendedor.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Retorna uma representação em String do objeto Vendedor.
     *
     * @return uma String com as informações do vendedor.
     */
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

    /**
     * Classe Builder para construir uma instância de Vendedor.
     */
    public static class Builder {
        private Long id;
        private String name;
        private LocalDateTime birthDate;
        private Double baseSalary;
        private Department department;

        /**
         * Define o ID do vendedor.
         *
         * @param id o ID do vendedor.
         * @return o próprio Builder para encadeamento de métodos.
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * Define o nome do vendedor.
         *
         * @param name o nome do vendedor.
         * @return o próprio Builder para encadeamento de métodos.
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Define a data de nascimento do vendedor.
         *
         * @param birthDate a data de nascimento do vendedor.
         * @return o próprio Builder para encadeamento de métodos.
         */
        public Builder birthDate(LocalDateTime birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Define o salário base do vendedor.
         *
         * @param baseSalary o salário base do vendedor.
         * @return o próprio Builder para encadeamento de métodos.
         */
        public Builder baseSalary(Double baseSalary) {
            this.baseSalary = baseSalary;
            return this;
        }

        /**
         * Define o departamento do vendedor.
         *
         * @param department o departamento do vendedor.
         * @return o próprio Builder para encadeamento de métodos.
         */
        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        /**
         * Constrói e retorna uma instância de Vendedor com os dados configurados.
         *
         * @return uma nova instância de Vendedor.
         */
        public Vendedor build() {
            return new Vendedor(this);
        }
    }
}
