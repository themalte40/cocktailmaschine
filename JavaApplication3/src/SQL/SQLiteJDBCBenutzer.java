package SQL;
import java.sql.*;

public class SQLiteJDBCBenutzer
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Benutzer.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO DENNIS (ID,NAME,AGE,PASSWORT) " +
                   "VALUES (1, 'Dennis', 23, 123456);"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO DENNIS (ID,NAME,AGE,PASSWORT) " +
            "VALUES (2, 'Malte', 20, 123456);"; 
      stmt.executeUpdate(sql);
      
      sql = "INSERT INTO DENNIS (ID,NAME,AGE,PASSWORT) " +
            "VALUES (3, 'Cocktailmaschine', 1, 987654321);"; 
      stmt.executeUpdate(sql);


      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
}