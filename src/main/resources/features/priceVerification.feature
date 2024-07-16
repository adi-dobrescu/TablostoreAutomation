Feature: Product details verification

  Scenario Outline: Verify product names and prices for all variants
    Given I am on the collection page
    When I click on product number "<productNumber>"
    Then the product name should be "<expectedProductName>"
    And the price for variant "<variantName>" should be "<expectedPrice>"

    Examples:
      | productNumber | expectedProductName     | variantName   | expectedPrice |
      | 1             | "PINK BLOOM"            | 45 X 60 CM    | 499,00 lei    |
      | 1             | "PINK BLOOM"            | 60 X 80 CM    | 599,00 lei    |
      | 1             | "PINK BLOOM"            | 70 X 100 CM   | 699,00 lei    |
      | 2             | "SIMPLICITY"            | 45 X 60 CM    | 199,00 lei    |
      | 2             | "SIMPLICITY"            | 60 X 80 CM    | 249,00 lei    |
      | 2             | "SIMPLICITY"            | 70 X 100 CM   | 299,00 lei    |
      | 3             | "FLOWER MISTERY"        | 45 X 60 CM    | 199,00 lei    |
      | 3             | "FLOWER MISTERY"        | 60 X 80 CM    | 249,00 lei    |
      | 3             | "FLOWER MISTERY"        | 70 X 100 CM   | 299,00 lei    |
      | 4             | "PASSION"               | 45 X 60 CM    | 499,00 lei    |
      | 4             | "PASSION"               | 60 X 80 CM    | 599,00 lei    |
      | 4             | "PASSION"               | 70 X 100 CM   | 699,00 lei    |
      | 5             | "CHARMING WOMEN"        | 45 X 60 CM    | 499,00 lei    |
      | 5             | "CHARMING WOMEN"        | 60 X 80 CM    | 599,00 lei    |
      | 5             | "CHARMING WOMEN"        | 70 X 100 CM   | 699,00 lei    |
      | 6             | "MISTERIOUS WOMEN"      | 45 X 60 CM    | 499,00 lei    |
      | 6             | "MISTERIOUS WOMEN"      | 60 X 80 CM    | 599,00 lei    |
      | 6             | "MISTERIOUS WOMEN"      | 70 X 100 CM   | 699,00 lei    |
      | 7             | "GOLDEN VIBES"          | 45 X 60 CM    | 499,00 lei    |
      | 7             | "GOLDEN VIBES"          | 60 X 80 CM    | 599,00 lei    |
      | 7             | "GOLDEN VIBES"          | 70 X 100 CM   | 699,00 lei    |
      | 8             | "BROWN TOUCH"           | 45 X 60 CM    | 499,00 lei    |
      | 8             | "BROWN TOUCH"           | 60 X 80 CM    | 599,00 lei    |
      | 8             | "BROWN TOUCH"           | 70 X 100 CM   | 699,00 lei    |
      | 9             | "FLOWER LIPS"           | 45 X 60 CM    | 499,00 lei    |
      | 9             | "FLOWER LIPS"           | 60 X 80 CM    | 599,00 lei    |
      | 9             | "FLOWER LIPS"           | 70 X 100 CM   | 699,00 lei    |
      | 10            | "ETERNAL BEAUTY"        | 45 X 60 CM    | 199,00 lei    |
      | 10            | "ETERNAL BEAUTY"        | 60 X 80 CM    | 249,00 lei    |
      | 10            | "ETERNAL BEAUTY"        | 70 X 100 CM   | 299,00 lei    |
      | 11            | "DREAM GARDEN"          | 40 X 80 CM    | 249,00 lei    |
      | 11            | "DREAM GARDEN"          | 50 X 100 CM   | 299,00 lei    |
      | 11            | "DREAM GARDEN"          | 60 X 120 CM   | 349,00 lei    |
      | 12            | "DREAM WORLD"           | 40 X 60 CM    | 199,00 lei    |
      | 12            | "DREAM WORLD"           | 60 X 90 CM    | 249,00 lei    |
      | 12            | "DREAM WORLD"           | 80 X 120 CM   | 299,00 lei    |
