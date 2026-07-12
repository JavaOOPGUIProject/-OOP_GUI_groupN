import java.sql.Connection;

class Main {
    public static void main(String[] args) {


            LoginFrame Loginframe = new LoginFrame();
            Loginframe.setVisible(true);

        Connection con = DBConnection.getConnection();

        //Test the connection
        if (con != null) {
            System.out.println("Database Connected!");
        } else {
            System.out.println("Connection Failed!");
        }

    }
}
