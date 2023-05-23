package BrunoSilva.DesafioDigix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import BrunoSilva.DesafioDigix.models.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Familia findByNomeDoResponsavel(String nomeDoResponsavel);
    @Query("SELECT f FROM Familia f ORDER BY f.pontos DESC")
    List<Familia> findByOrderByPontosDec();
}
