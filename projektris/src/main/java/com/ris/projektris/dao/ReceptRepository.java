package com.ris.projektris.dao;

import com.ris.projektris.models.Recept;
import com.ris.projektris.models.Uporabnik;
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

    @Query("SELECT r FROM Recept r WHERE r.steviloKalorij = :kalorije AND r.steviloOseb = :osebe")
    public Iterable<Recept> findBykalorijeosebe(@Param("kalorije") int kalorije,@Param("osebe") int osebe);

    @Query("SELECT r FROM Recept r, Komentar k WHERE k.recept = r GROUP BY r HAVING COUNT( k.recept) > :stKomentarjev")
    public List<Recept> vrniRecepteGledeNaSteviloKomentarjev(@Param("stKomentarjev") int stKomentarjev);

    @Query("SELECT r FROM Recept r, Vsecek v WHERE v.recept = r GROUP BY r HAVING COUNT( v.recept) > :stVseckov")
    public List<Recept> vrniRecepteGledeNaSteviloVseckov(@Param("stVseckov") int stVseckov);

}
