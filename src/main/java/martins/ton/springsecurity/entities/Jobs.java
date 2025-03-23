package martins.ton.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "jobs_id")
    private Long jobsId;

    private String jobName;

    private String jobDescription;

    private String jobObservations;

    private BigDecimal jobPrice;

    @CreationTimestamp
    private Instant creationTimestampJobs;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Jobs() {
    }

    public Jobs(Long jobsId, String jobName, String jobDescription, String jobObservations, BigDecimal jobPrice, Instant creationTimestampJobs, User user) {
        this.jobsId = jobsId;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobObservations = jobObservations;
        this.jobPrice = jobPrice;
        this.creationTimestampJobs = creationTimestampJobs;
        this.user = user;
    }

    public Long getJobsId() {
        return jobsId;
    }

    public void setJobsId(Long jobsId) {
        this.jobsId = jobsId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobObservations() {
        return jobObservations;
    }

    public void setJobObservations(String jobObservations) {
        this.jobObservations = jobObservations;
    }

    public BigDecimal getJobPrice() {
        return jobPrice;
    }

    public void setJobPrice(BigDecimal jobPrice) {
        this.jobPrice = jobPrice;
    }

    public Instant getCreationTimestampJobs() {
        return creationTimestampJobs;
    }

    public void setCreationTimestampJobs(Instant creationTimestampJobs) {
        this.creationTimestampJobs = creationTimestampJobs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
