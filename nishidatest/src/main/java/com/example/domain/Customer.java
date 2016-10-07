
package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data //getter/setter/コンストラクタの自動生成
@NoArgsConstructor //引数なしのコンストラクタ
@AllArgsConstructor

@Entity //jpaエンティティ
@Table(name = "customers") //tb名
public class Customer {
    @Id //pキー
    @GeneratedValue //autoIncrement
    private Integer id;
	private String firstName;
    private String lastName;
}