package backend.api.repository;

import backend.api.model.Patrocinio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatrocinioRepository extends JpaRepository<Patrocinio, Long> {
}