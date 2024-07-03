package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@RestController
public class ProductController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarProduct")
    public List<Product> listarProduct() {
        ProductDAO productDAO=new ProductDAO();
        return productDAO.listar();
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody String category, String title, String description,  String price, String url) {
    
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category2 = categoryDAO.search(Integer.parseInt(category));
        Product product = new Product(category2, title, description, Float.parseFloat(price), url);

        ProductDAO productDAO= new ProductDAO();
        productDAO.add(product);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delProduct/{id}")
    public void delProduct(@PathVariable("id") Integer id) {

        ProductDAO productDAO=new ProductDAO();
        Product product = productDAO.search(id);
        productDAO.del(product);

    }
}
