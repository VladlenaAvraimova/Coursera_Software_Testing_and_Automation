Feature: BellyFeature

  Scenario: eaten few cukes
    Given I have eaten 42 cukes
    When I wait 2 hour
    Then my Belly should growl

  Scenario: eaten many cukes
    Given I have eaten 9 cukes
    When I wait 1 hour
    Then my Belly should not growl

  Scenario: eaten few cukes
    Given I have eaten 10 cukes
    When I wait 2 hour
    Then my Belly should not growl

  Scenario: eaten few cukes but er
    Given I have eaten 9 cukes
    When I wait 0 hour
    Then my Belly should not growl

  Scenario: eaten few cukes but er
    Given I have eaten 0 cukes
    When I wait 3 hour
    Then my Belly should not growl



