package martins.ton.springsecurity.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(unique = true)
    private String userName;

    private String name;

    private String lastName;

    private String password;

    private String userPhone;

    private String userRg;

    private String userCpf;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<Address> address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @CreationTimestamp
    private Instant creationTimestamp;
}
