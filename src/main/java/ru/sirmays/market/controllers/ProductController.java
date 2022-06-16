package ru.sirmays.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sirmays.market.exceptions.MarketError;
import ru.sirmays.market.exceptions.ResourceNotFoundException;
import ru.sirmays.market.model.Product;
import ru.sirmays.market.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product id "+ id +" not found"));
    }

    @GetMapping("/products/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }



//    @GetMapping("/products/price")
//    public List<Product> findByPriceBetween(@RequestParam(name = "min") int minPrice,
//                                            @RequestParam(name = "max") int maxPrice) {
//        return productService.findByPriceBetween(minPrice, maxPrice);
//    }
//
//    @GetMapping("/products/priceunder")
//    public List<Product> findProductsByPriceLessThanEqual(@RequestParam(name = "max") int maxPrice) {
//        return productService.findProductsByPriceLessThanEqual(maxPrice);
//    }
//
//    @GetMapping("/products/priceabove")
//    public List<Product> findProductsByPriceGreaterThanEqual(@RequestParam(name = "min") int minPrice) {
//        return productService.findProductsByPriceGreaterThanEqual(minPrice);
//    }

// это без lombok
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
}
