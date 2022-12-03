package com.ris.projektris.dao;

import com.ris.projektris.models.Odgovor;
import com.ris.projektris.models.Vprasanje;
import org.springframework.data.repository.CrudRepository;

public interface OdgovorRepository extends CrudRepository<Odgovor,Long> {
}
