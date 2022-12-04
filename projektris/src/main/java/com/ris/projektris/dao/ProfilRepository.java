package com.ris.projektris.dao;

import com.ris.projektris.models.Profil;
import com.ris.projektris.models.Recept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProfilRepository extends CrudRepository<Profil,Long> {

    @Query( "SELECT p FROM Profil p WHERE p.teza < :teza AND p.starost < :starost AND p.spol=:spol")
    public Iterable<Profil> findBytezastarostspolManj(@Param("teza") int teza, @Param("starost") int starost, @Param("spol") String spol);

    @Query( "SELECT p FROM Profil p WHERE p.teza > :teza AND p.starost > :starost AND p.spol=:spol")
    public Iterable<Profil> findBytezastarostspolVec(@Param("teza") int teza, @Param("starost") int starost, @Param("spol") String spol);

}
