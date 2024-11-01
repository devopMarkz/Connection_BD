package model.entities;

/**
 * Classe que representa um departamento com informações de identificação e nome.
 */
public class Department {

    private final Long id;
    private final String name;

    /**
     * Construtor para criar uma instância de Department com o ID e nome especificados.
     *
     * @param id   o ID do departamento.
     * @param name o nome do departamento.
     */
    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retorna o ID do departamento.
     *
     * @return o ID do departamento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retorna o nome do departamento.
     *
     * @return o nome do departamento.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna uma representação em String do objeto Department.
     *
     * @return uma String com as informações do departamento.
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
