package martins.ton.springsecurity.repository;

import martins.ton.springsecurity.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsReposiitory extends JpaRepository<Jobs, Long> {
}
