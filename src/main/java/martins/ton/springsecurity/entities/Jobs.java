package martins.ton.springsecurity.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobs_id")
    private Long jobsId;

    private String jobName;

    private String jobDescription;

    private String jobObservations;

    private BigDecimal jobPrice;

    private User user;
}
