package com.bolsadeideas.springboot.backend.aprirest.daos;
import com.bolsadeideas.springboot.backend.aprirest.entities.Cliente;
import com.bolsadeideas.springboot.backend.aprirest.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IClienteDao extends JpaRepository<Cliente,Long> {

    @Query("from Region")
    List<Region> findAllRegiones();
}
