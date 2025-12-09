package org.example.formsignup.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Size(min=5,max=45,message = "Nhap dung yeu cau first name")
    private String firstName;
    @Size(min=1,max=45,message = "Nhap dung yeu cau last name")
    private String lastName;
    @Pattern(regexp = "^0\\d{9}$",message = "SĐT có 10 số")
    private String phoneNumber;
    @Min(value = 18,message = "Phai lon hon 18 tuoi")
    private int age;
    @Pattern(regexp = "^[A-Za-z0-9_]+@gmail\\.com$",message = "email co dang: ....@gmail.com")
    private String email;
}
