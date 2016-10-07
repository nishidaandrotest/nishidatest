package com.example.service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //diコンテナに登録
@Transactional //dbトランザクションの制御
public class CustomerService {
	
    @Autowired //diによるインジェクション
    CustomerRepository customerRepository;

    //JpaRepository全件検索
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //JpaRepository1件検索
    public Customer findOne(Integer id) {
        return customerRepository.findOne(id);
    }

    //JpaRepository新規登録
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    //JpaRepository更新
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    //JpaRepository削除
    public void delete(Integer id) {
        customerRepository.delete(id);
    }
}