package com.example.web;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
//bean validation用class
public class CustomerForm {
    @NotNull
    @Size(min = 1, max = 10, message = "名は{min}文字から{max}文字で入力してください")
    private String firstName;
    @NotNull
    @Size(min = 1, max = 10, message = "姓は{min}文字から{max}文字で入力してください")
    private String lastName;
}