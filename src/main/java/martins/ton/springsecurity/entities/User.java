package martins.ton.springsecurity.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
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

    private String email;

    private String userRg;

    private String userCpf;

    @OneToMany(mappedBy = "user")
    private Set<Address> address = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Jobs> jobs = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @CreationTimestamp
    private Instant creationTimestampUser;

    public User() {
    }

    public User(UUID userId, String userName, String name, String lastName, String password, String userPhone,
                String email,String userRg, String userCpf, Instant creationTimestampUser) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.userPhone = userPhone;
        this.email = email;
        this.userRg = userRg;
        this.userCpf = userCpf;
        this.creationTimestampUser = creationTimestampUser;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRg() {
        return userRg;
    }

    public void setUserRg(String userRg) {
        this.userRg = userRg;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public Set<Jobs> getJobs() {
        return jobs;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Instant getCreationTimestampUser() {
        return creationTimestampUser;
    }

    public void setCreationTimestampUser(Instant creationTimestampUser) {
        this.creationTimestampUser = creationTimestampUser;
    }
}
