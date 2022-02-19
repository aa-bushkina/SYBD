import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
  public static void main(String[] args) throws SQLException
  {
    String url = "jdbc:mysql://localhost:3306/library";
    Connection connection = DriverManager.getConnection(url, "root", "root");

    if (connection.isValid(1))
    {
      System.out.println("Connection is OK\n");
    }

    Statement statement = connection.createStatement();
    cleanTable(statement, "CLIENTS");

    fillClients(statement);
  }

  public static void cleanTable(Statement statement, String tableName) throws SQLException
  {
    statement.executeUpdate("DELETE FROM " + tableName);
    statement.executeUpdate("ALTER TABLE " + tableName + " AUTO_INCREMENT = 0");
  }


  public static void fillClients(Statement statement) throws SQLException
  {
    statement.executeUpdate("INSERT INTO CLIENTS(FIRST_NAME, LAST_NAME, PATHER_NAME, PASSPORT_SERIA, PASSPORT_NUM) " +
      " VALUES ('Alex', 'Petrov', 'Vasilyevich', 1216, 345876)");
    statement.executeUpdate("INSERT INTO CLIENTS(FIRST_NAME, LAST_NAME, PATHER_NAME, PASSPORT_SERIA, PASSPORT_NUM) " +
      " VALUES ('Kate', 'Ivanova', 'Olegovna', 2567, 654321)");
    statement.executeUpdate("INSERT INTO CLIENTS(FIRST_NAME, LAST_NAME, PATHER_NAME, PASSPORT_SERIA, PASSPORT_NUM) " +
      " VALUES ('Mary', 'Ryzhaya', 'Viktorovna', 1754, 765678)");
    statement.executeUpdate("INSERT INTO CLIENTS(FIRST_NAME, LAST_NAME, PATHER_NAME, PASSPORT_SERIA, PASSPORT_NUM) " +
      " VALUES ('Sergey', 'Blue', 'Pavlovich', 2890, 345633)");
    statement.executeUpdate("INSERT INTO CLIENTS(FIRST_NAME, LAST_NAME, PATHER_NAME, PASSPORT_SERIA, PASSPORT_NUM) " +
      " VALUES ('Mikhail', 'Sidorov', 'Gennadievich', 4344, 458900)");
  }

  public static void fillJournal(Statement statement) throws SQLException
  {
    statement.executeUpdate("INSERT INTO JOURNAL(DATA_BEG, DATA_END, DATA_RET) " +
      " VALUES ('2016-01-12 10:15:11', '2016-02-12 10:15:11', '2016-02-10 10:15:11')");
  }
}


