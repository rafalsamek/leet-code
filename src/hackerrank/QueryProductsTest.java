package hackerrank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryProductsTest {

    @ParameterizedTest
    @MethodSource("testQueryProvider")
    void testQuery(List<List<Object>> products, List<List<Object>> queries, List<String> expectedResults) {
        QueryProducts queryProducts = new QueryProducts();
        List<String> actualResults = queryProducts.query(products, queries);
        assertEquals(expectedResults, actualResults, "Query results do not match expected results.");
    }

    static List<Object[]> testQueryProvider() {
        // Test case 1
        List<List<Object>> products1 = Arrays.asList(
                Arrays.asList("Laptop", 1000, 2021),
                Arrays.asList("Smartphone", 500, 2022),
                Arrays.asList("Tablet", 300, 2020)
        );

        List<List<Object>> queries1 = Arrays.asList(
                Arrays.asList("Type 1", 2021),  // Manufacturer year == 2021
                Arrays.asList("Type 2", 1100), // Price < 1100
                Arrays.asList("Type 3", 500)   // Price > 500
        );

        List<String> expectedResults1 = List.of("Laptop");

        // Test case 2
        List<List<Object>> products2 = Arrays.asList(
                Arrays.asList("Watch", 200, 2023),
                Arrays.asList("Speaker", 150, 2019),
                Arrays.asList("Headphones", 300, 2022)
        );

        List<List<Object>> queries2 = Arrays.asList(
                Arrays.asList("Type 1", 2022), // Manufacturer year == 2022
                Arrays.asList("Type 2", 350),  // Price < 350
                Arrays.asList("Type 3", 100)   // Price > 100
        );

        List<String> expectedResults2 = List.of("Headphones");

        return Arrays.asList(
                new Object[]{products1, queries1, expectedResults1},
                new Object[]{products2, queries2, expectedResults2}
        );
    }
}
