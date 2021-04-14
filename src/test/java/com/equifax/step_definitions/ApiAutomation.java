package com.equifax.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiAutomation {

    @Given("Get & Delete - Status code to be Successful")
    public void get_delete_status_code_to_be_successful() {
        Response responseGet = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
        Assert.assertEquals(200,responseGet.statusCode());
       // responseGet.body().prettyPrint();

        Response responseDelete = RestAssured.delete("http://dummy.restapiexample.com/api/v1/delete/1");
        Assert.assertEquals(200, responseDelete.getStatusCode());

    }

    @Then("Get - Return specific Employee details\\(Any)")
    public void get_return_specific_employee_details_any() {
        Response responseGetID = RestAssured.get("http://dummy.restapiexample.com/api/v1/employee/2");
        responseGetID.prettyPrint();

    }

    @Then("Delete - message : successfully! deleted Records")
    public void delete_message_successfully_deleted_records() {
        Response responseDeleteID = RestAssured.delete("http://dummy.restapiexample.com/api/v1/delete/3");

        JsonPath jsonData = responseDeleteID.jsonPath();
        String successMessage =jsonData.getString("message");
        System.out.println("successMessage = " + successMessage);

    }

}
