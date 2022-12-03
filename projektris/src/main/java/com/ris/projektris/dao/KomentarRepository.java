package com.ris.projektris.dao;

import com.ris.projektris.models.Komentar;
import com.ris.projektris.models.Vprasanje;
import org.springframework.data.repository.CrudRepository;

public interface KomentarRepository extends CrudRepository<Komentar,Long> {
}
