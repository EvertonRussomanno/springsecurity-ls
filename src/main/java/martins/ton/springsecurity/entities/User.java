package martins.ton.springsecurity.entities;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String userName;

    private String userLastName;

    private String password;

    private String userPhone;

    private String userRg;

    private String userCpf;

    private Address address;

    private Set<Role> roles;
}
