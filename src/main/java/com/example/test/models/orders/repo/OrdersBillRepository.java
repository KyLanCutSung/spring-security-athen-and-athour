package com.example.test.models.orders.repo;

import com.example.test.models.orders.dtos.OrdersBill;
import com.example.test.models.orders.dtos.OrdersBillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersBillRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<OrdersBillDetail> billDetails(Long userId){
        String sSQL =
                "select u.name, u.phone, o.shipping_address, p.product_name, p.product_price, o.received_day\n" +
                "from users u join orders o on u.user_id = o.user_id\n" +
                "join product p on o.product_id = p.product_id where u.user_id = :userId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId", userId);
        return namedParameterJdbcTemplate.query(sSQL, parameterSource, new BeanPropertyRowMapper<>(OrdersBillDetail.class));
    }
    public List<OrdersBill> totalBill(){
        String sSQL = "select u.name, p.product_name, count(p.product_name) as quantity, sum(p.product_price) as totalPrice\n" +
                "from users u join orders o on u.user_id = o.user_id\n" +
                "join product p on o.product_id = p.product_id\n" +
                "group by u.name, p.product_name";
        return namedParameterJdbcTemplate.query(sSQL, new BeanPropertyRowMapper<>(OrdersBill.class));
    }
}
