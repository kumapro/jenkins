package test.accolite;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test {
    private volatile Map<ProductType, Integer>  productTypeIntegerMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        ProductType productType = new ProductType();
        productType.setId(101);
        Product product = new Product(1, "prodName 1", productType);
        Product product2 = new Product(2, "prodName 2", productType);
        Product product3 = new Product(3, "prodName 3", productType);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
        Map<ProductType, Integer> productTypeIntegerMap = aggregate1(products);
        productTypeIntegerMap.forEach((key, val) -> System.out.println(key + " : " + val));

    }

    public Map<ProductType, Integer> aggregate(List<Product> products){
        Map<ProductType, List<Product>> productTypeListMap = products.stream().collect(Collectors.groupingBy(Product::getProductType));
        Map<ProductType, Integer> result = new HashMap<>();
        for (Map.Entry<ProductType, List<Product>> entry : productTypeListMap.entrySet()){
            result.put(entry.getKey(), entry.getValue().size());
        }
        return result;
    }

    public static Map<ProductType, Integer> aggregate1(List<Product> products){
        Map<ProductType, Integer> collect = products.stream().collect(Collectors.groupingBy(Product::getProductType))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));

        System.out.println(collect instanceof LinkedHashMap);//false
        System.out.println(collect instanceof HashMap);//true

        return collect;
    }

    public static Map<ProductType, Integer> aggregate2(List<Product> products){
        Map<ProductType, Integer> collect = products.stream().collect(Collectors.groupingBy(Product::getProductType))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));

        System.out.println(collect instanceof LinkedHashMap);//false
        System.out.println(collect instanceof HashMap);//true

        return collect;
    }
    public void threadAggregate(List<Product> products){
        Map<ProductType, List<Product>> productTypeListMap = products.stream().collect(Collectors.groupingBy(Product::getProductType));
        for (Map.Entry<ProductType, List<Product>> entry : productTypeListMap.entrySet()){
            if (productTypeIntegerMap.containsKey(entry.getKey())){
                int size = entry.getValue().size();
                productTypeIntegerMap.put(entry.getKey(),productTypeIntegerMap.get(entry.getKey()) + size);
            }
            productTypeIntegerMap.put(entry.getKey(), entry.getValue().size());
        }
    }
}
