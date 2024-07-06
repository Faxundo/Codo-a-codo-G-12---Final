package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.model.Category;

@RestController
public class CategoryController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarCategory")
    public List<Category> listarCategory() {
        CategoryDAO categoryDAO=new CategoryDAO();
        return categoryDAO.listar();
    }
}
