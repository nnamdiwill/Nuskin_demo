@NuskinAll

  Feature: Test cases for Nuskin

    @Nuskin1
    Scenario: Open a browser, add something to cart and close browser
      Given I open the nuskin website
      When I add item to cart
      Then I take a screenshot and close

      @Nuskin2
      Scenario: Open Browser, do a search and put return into a list
        Given I open up the webpage
        When I type in searchbox
        Then I put the items into a list and close