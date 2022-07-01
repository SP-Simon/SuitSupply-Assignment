
@SuitSupply

Feature: adding to cart


  Scenario: adding a customised jacket to the cart with size

    Given launch the application with "https://suitsupply.com/en-nl/"
    Then click on menu
    And select fabric
    And select the style
    And choose the size
    Then add to cart
