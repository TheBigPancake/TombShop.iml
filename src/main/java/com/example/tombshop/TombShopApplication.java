package com.example.tombshop;

import com.example.tombshop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class TombShopApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(TombShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SelectTombs();
        SelectOrdeers();
    }

    private void SelectTombs() {
        String sql = "SELECT * FROM [TombShop].[dbo].[tombs]";
        List<Tomb> tombs = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Tomb.class));

        tombs.forEach(System.out :: println);
    }
    private void SelectOrdeers() {
        String sql = "SELECT * FROM [TombShop].[dbo].[orders]";
        List<Order> orders = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Order.class));

        orders.forEach(System.out :: println);
    }

}
