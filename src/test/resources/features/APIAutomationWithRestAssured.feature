Feature: Perform Assertions
  I will get or delete an employee from the API

  Scenario: Use any 2 methods(Get, and Delete) from end-points listed in http://dummy.restapiexample.com/
    Given Get & Delete - Status code to be Successful
    Then Get - Return specific Employee details(Any)
    Then Delete - message : successfully! deleted Records
