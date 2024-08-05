package io.microservices.User.model;

import com.SpringBoot.EcommerceSiteProject.User.model.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String userName;
    private  String email;
    private  String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

   /* @OneToMany(mappedBy = "user")
    private List<Address> addresses;*/

/*    @JsonIgnore
    @OneToOne(mappedBy = "user",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private Cart cart;*/

   /* @OneToMany(mappedBy = "user")
    private List<Product> products;*/


   /* @OneToMany(mappedBy = "user",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private List<Order> order;*/

    /*@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Payment> payment = new ArrayList<>();*/
}
