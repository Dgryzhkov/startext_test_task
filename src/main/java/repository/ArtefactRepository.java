package repository;

import models.Artefact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtefactRepository  extends JpaRepository<Artefact, UUID> {
    boolean existByArtefactId(UUID artefactId);
}
