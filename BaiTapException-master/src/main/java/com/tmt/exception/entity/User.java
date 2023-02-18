package com.tmt.exception.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Bạn phải nhập tên người dùng")
    private String userName;

    @JsonIgnore
    @Min(value = 8)
    @NotEmpty(message = "Bạn nhập mật khẩu")
    private String passWord;

    @Size(min = 10, max = 11)
    private int phone;

    @NotNull(message = "Bạn nhập email người dùng")
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String avatar;

   @ManyToMany
   @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;
}
