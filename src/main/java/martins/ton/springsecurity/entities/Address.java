package martins.ton.springsecurity.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id")
    private UUID addressId;

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
    @JoinColumn(name = "address_id", referencedColumnName = "userId", nullable = false)
    private User user;
}
