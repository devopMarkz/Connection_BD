package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe utilitária para gerenciar a conexão com o banco de dados.
 * Responsável por estabelecer e encerrar a conexão de maneira centralizada.
 */
public class DB {

    /** Conexão estática compartilhada para o banco de dados */
    private static Connection connection = null;

    /**
     * Obtém uma conexão com o banco de dados. Caso a conexão não exista, cria uma nova.
     *
     * @return Connection conexão ativa com o banco de dados
     * @throws DbException se ocorrer algum erro ao estabelecer a conexão
     */
    public static Connection getConnection(){
        if(connection == null){
            try{
                String url = loadProperties().getProperty("dburl");
                connection = DriverManager.getConnection(url, loadProperties());
                return connection;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        } else return connection;
    }

    /**
     * Encerra a conexão com o banco de dados, se houver uma conexão ativa.
     *
     * @throws DbException se ocorrer algum erro ao fechar a conexão
     */
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Carrega as propriedades de configuração do banco de dados a partir do arquivo 'db.properties'.
     *
     * @return Properties propriedades de configuração para o banco de dados
     * @throws RuntimeException se ocorrer um erro de leitura do arquivo de propriedades
     */
    private static Properties loadProperties(){
        try (FileInputStream fr = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fr);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}