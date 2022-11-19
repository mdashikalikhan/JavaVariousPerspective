package com.feature.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
public class StreamExample1 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "P1", 1000));
        productList.add(new Product(2, "P2", 2000));
        productList.add(new Product(3, "P3", 3000));
        productList.add(new Product(4, "P4", 4000));
        productList.add(new Product(5, "P5", 5000));
        List<Double> productPriceList1 = new ArrayList<>();
        for(Product product : productList) {
            if(product.getPrice()<3000) {
                productPriceList1.add(product.getPrice());
            }
        }
        
        System.out.println(productPriceList1);
        System.out.println(productList);
        
        List<Double> productPriceList2 = productList.stream()
                                        .filter(p->p.getPrice()<3000)
                                        .map(p -> p.getPrice())
                                        .collect(Collectors.toList());
        System.out.println(productPriceList2);
        
        Stream.iterate(1, i->i+1)
        .filter(i->i%10==0)
        .limit(10)
        .forEach(System.out::println);
        
        System.out.println("===========");
        
        Stream.iterate(100, t->t-1)
        .filter(p->p%5==0)
        .limit(10)
        .forEach(System.out::println);
        
        System.out.println("===========");
        
        List<Double> productPriceList3 = productList.stream()
                                        .filter(t -> t.getPrice()>=3000)
                                        .map(p ->p.getPrice())
                                        .collect(Collectors.toList());
        System.out.println(productPriceList3);
        
        List<Product> productList1 = productList.stream()
                                     .filter(p->p.getPrice()>=2000)
                                     .collect(Collectors.toList());
        System.out.println(productList1);
        
        productList.stream().filter(p->p.getPrice()>=4000)
        .map(p->p.getId() + " " + p.getPrice())
        .forEach(System.out::println);
    }
}


@AllArgsConstructor
@ToString
class Product{
    @Getter @Setter 
    private int id;
    @Getter @Setter 
    private String name;
    @Getter @Setter 
    private double price;
    
    
}