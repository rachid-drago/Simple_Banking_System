package banking;

import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB {
    Connection con = null;
    Statement statement = null;
    String filePath ;
    SQLiteDataSource dataSource = new SQLiteDataSource();

    ConnectDB(String filePath) {
        this.filePath = filePath;
        String url = "jdbc:sqlite:" + filePath;
        //SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try  {
            con = dataSource.getConnection();
            if (con.isValid(5)) {
                System.out.println("Connection is valid.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {

            try  {

                statement = con.createStatement();
                // Statement execution
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS card(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "number TEXT NOT NULL," +
                        "pin TEXT NOT NULL," +
                        "balance INTEGER DEFAULT 0)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void addData(String num, String p) {
        try (Statement statement = con.createStatement()) {
            String query = "INSERT INTO 'card'(number,pin) VALUES('"+num+"','"+p+"')";
            int i = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<bankAccount> getData() {

        String query = "SELECT * FROM card";
        ArrayList<bankAccount> dataList = new ArrayList<>();

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next())
            {
                String num = rs.getString("number");
                String pin = rs.getString("pin");
                double balance = rs.getDouble("balance");

                dataList.add(new bankAccount(num,pin,balance));
            }

            return dataList;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void deleteData(String num, String p)
    {
        String query = "DELETE FROM card"+
                " WHERE number = ? AND pin = ?";

        try {

            PreparedStatement preStatement = con.prepareStatement(query);
            preStatement.setString(1, num);
            preStatement.setString(2, p);
            preStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateData(String num, String p, double b)
    {
        String query = "UPDATE card SET balance = ?"+
                " WHERE number = ? AND pin = ?";

        try {

            PreparedStatement preStatement = con.prepareStatement(query);
            preStatement.setDouble(1, b);
            preStatement.setString(2, num);
            preStatement.setString(3, p);
            preStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
