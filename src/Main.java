import db.DB;
import db.DbException;
import model.entities.Department;
import model.entities.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        List<Vendedor> vendedores = new ArrayList<>();

        try (Connection connection = DB.getConnection();
             PreparedStatement stmt = connection
                     .prepareStatement("SELECT vendedor.Id, vendedor.Name, vendedor.BirthDate, vendedor.BaseSalary, departamento.Id, departamento.Name \n" +
                                            "FROM seller AS vendedor\n" +
                                            "INNER JOIN department departamento\n" +
                                            "ON vendedor.DepartmentId = departamento.Id;")
        ){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Vendedor vendedor = new Vendedor.Builder()
                        .id(rs.getLong("vendedor.Id"))
                        .name(rs.getString("vendedor.Name"))
                        .birthDate(LocalDateTime.parse(rs.getString("vendedor.BirthDate"), fmt))
                        .baseSalary(rs.getDouble("vendedor.BaseSalary"))
                        .department(new Department(rs.getLong("departamento.Id"), rs.getString("departamento.Name")))
                        .build();

                vendedores.add(vendedor);
            }

            vendedores.stream()
                    .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                    .forEach(System.out::println);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection();
        }

    }
}