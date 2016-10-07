package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//jpaリポジトリを継承したinterfaceの作成だけでcrud(create,read,update,delete)が可能。
//エンティティクラスとpキーを設定する。
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

