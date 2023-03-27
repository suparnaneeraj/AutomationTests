Feature: Login Functionality

  Scenario Outline: Verify if the login is success on providing correct credentials

    Given the user is in the login page
    When the user enters the given username "<username>" and password "<password>"
    And clicks login button
    Then user should be logged in successfully

    Examples:
      | username  | password  |
      | standard_user | secret_sauce  |
      | problem_user  | secret_sauce  |
      
  Scenario Outline: Verify if the login fails on providing incorrect credentials

    Given the user is in the login page
    When the user enters the given username "<username>" and password "<password>"
    And clicks login button
    Then login failed message should be displayed

    Examples:
      | username  | password  |
      | standard_user | secretsauce  |
      | problemuser  | secret_sauce  |
      | 344 | 123 |