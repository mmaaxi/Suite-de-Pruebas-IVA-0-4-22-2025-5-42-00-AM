Feature: Validate inclusion and content of the column 'IVA 0%'

  Scenario: Verify presence and correctness of 'IVA 0%' column in the exported report
    Given The user exports the report and opens the Excel file
    Then The column 'IVA 0%' should be present in the file
    And The values in the 'IVA 0%' column should be correct