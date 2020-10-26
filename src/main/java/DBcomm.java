
import java.sql.*;
import java.util.ArrayList;

public class DBcomm {
private static Connection conn;
private PreparedStatement prep ;

    public static void main(String[] args) {
        //Bruges bare til at have en metode som kan køre det hele fra.
        //DBcomm db = new DBcomm();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //mysql skal ændres senere til MariaDB, localhost til en IPaddresse -
            String user,pass,url;
            user = "client";
            pass="bigboi";
            url="jdbc:mysql://localhost:3306/PhoenixHospital?serverTimezone=Europe/Amsterdam&amp";

            // Skal man fx. bruge 127.0.0.1 til en remote maskine?
//Connection connection =
// DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
            //Tænk jer om - kan man opnå mariadb forbindelse til en anden maskine uden at ændre denne her?


            conn=  DriverManager.getConnection(url,user,pass);

            System.out.println("Im in");

            //getHomeData();
            findUser("Wilge@dtu.dk");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //db.getHomeData();
    }

    public DBcomm(){



    }

    public static void insertIntoHome(){


    }

    public static ArrayList getHomeData() {
ArrayList data = new ArrayList();
        try {
            String sql = "select * from phoenixpoint.logins;";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
//rs.getDataType( tal) ; giver os en datatype på den 1, 2 osv. plads -
// Hvad sker hvis vi forsøger at hente et Int fra String?

                System.out.println(rs.getInt(1) + rs.getString("mail") + rs.getString("pass"));
//hvad hvis vi henviser til det ud fra navne fremfor index?
            }
            conn.close();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    private static String[] findUser(String mail){
        String[] result = new String[2];
        try {
            String sql = "select * from phoenixpoint.logins where mail=" +"'" +mail+"'" +"limit 1;";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
          while(rs.next()){
//rs.getDataType( tal) ; giver os en datatype på den 1, 2 osv. plads -
// Hvad sker hvis vi forsøger at hente et Int fra String?

                System.out.println(
                        "row:" + rs.getInt(1) +"\n" +
                        "mail: "+rs.getString("mail")+"\n" +
                                "pass:"+rs.getString("pass")+"\n");
//hvad hvis vi henviser til det ud fra navne fremfor index?
            }
            conn.close();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
       return result;

    }

    public static void insertIntoRemote(){


    }
    public static ArrayList getRemoteData(){

        return null;
    }
}
