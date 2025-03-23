package martins.ton.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(nullable = false)
    private String addressCep;

    @Column(nullable = false)
    private String typeCep;

    private String subTypeCep;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String address;

    private String complementation;

    private String ibgeCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
    }

    public Address(Long addressId, String addressCep, String typeCep, String subTypeCep,
                   String uf, String city, String neighborhood, String address,
                   String complementation, String ibgeCode, User user) {
        this.addressId = addressId;
        this.addressCep = addressCep;
        this.typeCep = typeCep;
        this.subTypeCep = subTypeCep;
        this.uf = uf;
        this.city = city;
        this.neighborhood = neighborhood;
        this.address = address;
        this.complementation = complementation;
        this.ibgeCode = ibgeCode;
        this.user = user;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressCep() {
        return addressCep;
    }

    public void setAddressCep(String addressCep) {
        this.addressCep = addressCep;
    }

    public String getTypeCep() {
        return typeCep;
    }

    public void setTypeCep(String typeCep) {
        this.typeCep = typeCep;
    }

    public String getSubTypeCep() {
        return subTypeCep;
    }

    public void setSubTypeCep(String subTypeCep) {
        this.subTypeCep = subTypeCep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplementation() {
        return complementation;
    }

    public void setComplementation(String complementation) {
        this.complementation = complementation;
    }

    public String getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
