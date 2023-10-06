package com.example.demo.repos;
/** interfaces perform database operations such as saving, retrieving, updating, and deleting data
 JPA automatically generates the implementations of these methods based on the method names,
 allowing you to interact with the database without writing SQL queries**/


import com.example.demo.Models.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//perform database operations and configure the database connection
@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}