package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Category;

public class CategoryDAO {

    public List<Category> listar() {

        try {
            Statement st = ConnectorDB.getSt();
            ResultSet rs = st.executeQuery("SELECT * FROM category");

            List<Category> listCategory = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("title"));
                listCategory.add(category);
            }
            rs.close();
            return listCategory;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return null;

    }

    public Boolean add(Category category) {
        try {
            Statement st = ConnectorDB.getSt();
            Integer canInsert = st.executeUpdate("INSERT INTO category (title) VALUES ('" + category.getTitle() + "')"
            );

            return canInsert == 1;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return false;

    }

    public Boolean del(Category category) {
        try {
            Statement st = ConnectorDB.getSt();
            Integer canDelete = st.executeUpdate("DELETE FROM category WHERE id = " + category.getId());

            return canDelete == 1;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return false;

    }

    public Category search(int id) {
        Category category = null;
        try {
            Statement st = ConnectorDB.getSt();
            String sql = "SELECT category.* FROM category WHERE category.id=" + id;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setTitle(rs.getString("title"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return category;
    }
}
