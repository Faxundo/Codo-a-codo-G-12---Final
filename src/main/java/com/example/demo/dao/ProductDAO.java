package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

public class ProductDAO {
 
    public List<Product> listar() {

        try {
            Statement st = ConnectorDB.getSt();
            ResultSet rs = st.executeQuery("SELECT product.*, category.id as categoryid, category.title as categorytitle FROM product INNER JOIN category ON product.category_id = category.id");

            List<Product> listProduct = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(rs.getInt("categoryid"), rs.getString("categorytitle"));
                Product product = new Product(rs.getInt("id"), category, rs.getString("title"), rs.getString("description"), rs.getFloat("price"), rs.getString("url"));
                listProduct.add(product);
            }
            rs.close();
            return listProduct;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return null;

    }

    public Boolean add(Product product) {
        try {
            Statement st = ConnectorDB.getSt();
            Integer canInsert = st.executeUpdate("INSERT INTO product(category_id, title, description, price, url) VALUES ('" + product.getCategory_id().getId() + "', '" + product.getTitle() + "', '" + product.getDescription() + "', '" + product.getPrice() + "', '" + product.getUrl() + "')");

            return canInsert == 1;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return false;

    }

    public Boolean del(Product product) {
        try {
            Statement st = ConnectorDB.getSt();
            Integer canDelete = st.executeUpdate("DELETE FROM product WHERE id = " + product.getId());

            return canDelete == 1;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return false;

    }

    public Product search(int id) {
        Product product = null;
        try {
            Statement st = ConnectorDB.getSt();
            String sql = "SELECT product.* FROM product WHERE product.id=" + id;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                product = new Product();
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }
}
