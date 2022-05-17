Feature: Find Pets By Status Tests

  @smoke @findByStatus
  Scenario: Able to retrieve data using status - available
    Given I request the petstore url to find the pet using "available" status
    Then I should get status code as 200
    And I verify the performance response time is less than or equal to 5000 milliseconds
    And I verify all the pets with "category.name" as "Lions" in the result
    And I verify the response conforms to schema

  @smoke @findByStatus
  Scenario: Able to retrieve data using status - sold
    Given I request the petstore url to find the pet using "pending" status
    Then I should get status code as 200
    And I verify the performance response time is less than or equal to 5000 milliseconds
    And I verify all the pets with "category.name" as "Lions" in the result using json deserialize
    And I verify the response conforms to schema

  @findByStatus
  Scenario Outline: Able to retrieve data using status - <status>
    Given I request the petstore url to find the pet using "<status>" status
    Then I should get status code as 200
    And I verify the performance response time is less than or equal to 5000 milliseconds
    And I verify all the pets with "category.name" as "lion" in the result
    And I verify the response conforms to schema

    Examples: 
      | status    |
      | available |
      | pending   |
      | sold      |

  @findByStatus
  Scenario Outline: Able to retrieve data using multiple status - <status1> and <status2>
    Given I request the petstore url to find the pet using "<status1>" and "<status2>" status
    Then I should get status code as 200
    And I verify the performance response time is less than or equal to 5000 milliseconds
    And I verify all the pets with "category.name" as "lion" in the result
    And I verify the response conforms to schema

    Examples: 
      | status1   | status2   |
      | available | pending   |
      | pending   | sold      |
      | sold      | available |

  @findByStatus
  Scenario Outline: Returns 400 when <condition> status value is passed
    Given I request the petstore url to find the pet using "<status>" status
    Then I should get status code as 400
    Then I verify the performance response time is less than or equal to 5000 milliseconds

    Examples: 
      | condition | status          |
      | multiple  | available, sold |
      | null      |                 |
