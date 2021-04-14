Feature: Search and Buy
  Agile Story: As a user, I will search an item and I will buy it

  Scenario: Item price verification
    Given Visit amazon.com Page
    Then Search for Book qa testing for beginners
    And Click on 1st item in the listed results
    And Before Click on add to cart Add to Cart asset price from Step3
    Then Click on Add to Cart
    And Before Click on Proceed to Checkout asset price from Step3
    Then Click on proceed to checkout
    And On the checkout page assert price from Step3



