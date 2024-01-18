import java.sql.*;

public class JdbcBasics {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //insertPerson("Jane", "Doe", 35);
        loadAllPersons();

        //insert more persons

        //insertPersonUsingPreparedStatement("Mary", "Ashley", 35);
        loadPersonsUsingPreparedStatement();
        insertPersonUsingStoredProcedure("Kathy", "Smith", 35);
    }

    private static void insertPersonUsingStoredProcedure(String firstName, String lastName, int age) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Loading the driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String sql = "call insert_person(?, ?, ?)";
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, firstName);
            callableStatement.setString(2, lastName);
            callableStatement.setInt(3, age);
            callableStatement.execute();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static void loadPersonsUsingPreparedStatement() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Loading the driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String sql = "select * from persons where age > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 30);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println("id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }


    private static void insertPersonUsingPreparedStatement(String firstName, String lastName, int age) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Loading the driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String sql = "insert into persons(first_name, last_name, age) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 20; i++) {
                preparedStatement.setString(1, firstName + i);
                preparedStatement.setString(2, lastName + i);
                preparedStatement.setInt(3, age + i);
                preparedStatement.execute();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }


    }

    private static void loadAllPersons() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Loading the driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            Statement statement = connection.createStatement();
            String sql = "select * from persons";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println("id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", age: " + age);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static void insertPerson(String firstName, String lastName, int age) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Loading the driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO persons (first_name, last_name, age) VALUES ('%s', '%s', %d)"
                    .formatted(firstName, lastName, age);
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}
