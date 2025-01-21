package hackerrank;

import java.util.List;
import java.util.stream.Collectors;

public class QueryProducts {

    public List<String> query(List<List<Object>> products, List<List<Object>> queries) {
        return products.stream()
                .filter(
                        product -> queries.stream().allMatch(
                                query -> matchesQuery(product, query
                                )
                        )
                )
                .map(product -> (String) product.get(0))
                .collect(Collectors.toList());
    }

    private boolean matchesQuery(List<Object> product, List<Object> query) {
        String queryType = (String) query.get(0);
        int queryValue = (int) query.get(1);

        switch (queryType) {
            case "Type 1": // Manufacturer year equal
                return (int) product.get(2) == queryValue;

            case "Type 2": // Price less than
                return (int) product.get(1) < queryValue;

            case "Type 3": // Price greater than
                return (int) product.get(1) > queryValue;

            default:
                throw new IllegalArgumentException("Unknown query type: " + queryType);
        }
    }
}
