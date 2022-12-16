package com.ris.projektris.dao;

import com.ris.projektris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UporabnikRepository extends CrudRepository<Uporabnik,Long> {


   /* @Query("SELECT * FROM Uporabnik u JOIN Recept r ON  r.id_Recept = u.id_Recept  WHERE r.steviloKalorij > :kalorije AND r.steviloOseb > :osebe AND r.casKuhanja > :cas")
    public Iterable<Uporabnik> findBykalorijeosebecas(@Param("kalorije") int kalorije, @Param("osebe") int osebe, @Param("cas") int cas);

    */

    @Query("select u from Uporabnik u, Recept r where r.uporabnik = u and r.steviloOseb = :steviloOseb")
    public Iterable<Uporabnik> vrniUporabnikeGledeNaSteviloOsebRecepta(@Param("steviloOseb") int stOseb);

    @Query("select u from Uporabnik u, Recept r where r.uporabnik = u and r.casKuhanja > :casKuhanja")
    public Iterable<Uporabnik> vrniUporabnikeGledeNaCasKuhanjaRecepta(@Param("casKuhanja") int stOseb);

    public boolean existsByUporabniskoIme(String uporabniskoIme);
}
