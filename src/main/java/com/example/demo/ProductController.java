package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;

@RestController
public class ProductController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarProduct")
    public List<Product> listarProduct() {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.listar();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.add(product);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delProduct/{id}")
    public void delProduct(@PathVariable("id") Integer id) {

        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(id);
        productDAO.del(product);

    }
}
