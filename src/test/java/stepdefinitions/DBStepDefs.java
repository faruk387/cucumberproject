package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class DBStepDefs {
    @Given("user connects to the application database")
    public void user_connects_to_the_application_database() {
        DBUtils.createConnection();
    }
    @Given("user gets the column {string} from the table {string}")
    public void user_gets_the_column_from_the_table(String column, String table) {
//String query="SELECT * FROM jhi_user ORDER BY id";
String query="SELECT "+column+" FROM "+table+ " ORDER BY id";
DBUtils.executeQuery(query);

    }
    @Then("user reads all the column {string} data")
    public void user_reads_all_the_column_data(String column) throws Exception {
   //user result set to read the data,move between the rows
       DBUtils.getResultset().next();//go to the next row. By defoult driver is in the first row
        //DBUtils.getResultset().next();
        Object object1=DBUtils.getResultset().getObject(column);
        System.out.println(object1);//anonymoususer
       // Assert.assertTrue(object1.toString().equals("anonymoususer"));

        //Verify the next data equals abidincokyoruldu
        DBUtils.getResultset().next();
        Object object2=DBUtils.getResultset().getObject(column);
        System.out.println(object2);
        //Assert.assertTrue(object2.toString().equals("abidincokyoruldu"));
        //Verify the next data equals yhtyretye
        DBUtils.getResultset().next();
        Object object3=DBUtils.getResultset().getObject(column);
        System.out.println(object3);
     //   Assert.assertTrue(object3.toString().equals("yhtyretye"));
        //....................................................
        //        get all of the data and verify the columns contains adam_admin
        int rowNumber=3;
        while (DBUtils.getResultset().next()){//similar to hasNext()
            Object currentRowData= DBUtils.getResultset().getObject(column);
            System.out.println(currentRowData.toString());
            rowNumber++;

        }
        System.out.println("DATA COUNT: "+rowNumber);
        System.out.println("ROW COUNT: "+DBUtils.getRowCount());
    }
    @Then("verify table {string} and column {string} contains the data {string}")
    public void verify_table_and_column_contains_the_data(String table, String column, String data) {
      //Go to the table and the get the column data and store them in a list then do assertion
        String query="SELECT "+column+" FROM "+table+ " ORDER BY id";
       List<Object> currentColumnList= DBUtils.getColumnData(query,column);
        System.out.println(currentColumnList);
        //do the assertion
        Assert.assertTrue(currentColumnList.contains(data));
    }

}
