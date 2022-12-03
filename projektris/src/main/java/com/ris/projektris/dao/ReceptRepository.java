package com.ris.projektris.dao;

import com.ris.projektris.models.Recept;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceptRepository extends CrudRepository<Recept,Long> {

    @Query( "SELECT r FROM Recept r WHERE r.steviloKalorij < :kalorije AND r.steviloOseb < :osebe" )
    public Iterable<Recept> findBykalorijeosebeManj(@Param("kalorije") int kalorije,@Param("osebe") int osebe);

    @Query( "SELECT r FROM Recept r WHERE r.steviloKalorij < :kalorije AND r.steviloOseb < :osebe AND r.casKuhanja<:cas")
    public Iterable<Recept> findBykalorijeosebecasManj(@Param("kalorije") int kalorije,@Param("osebe") int osebe,@Param("cas") int cas);

    @Query( "SELECT r FROM Recept r WHERE r.steviloKalorij > :kalorije AND r.steviloOseb > :osebe AND r.casKuhanja > :cas")
    public Iterable<Recept> findBykalorijeosebecasVec(@Param("kalorije") int kalorije,@Param("osebe") int osebe,@Param("cas") int cas);
}