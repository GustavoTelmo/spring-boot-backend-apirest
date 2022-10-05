package com.bolsadeideas.springboot.backend.aprirest.services;
import com.bolsadeideas.springboot.backend.aprirest.entities.Cliente;
import com.bolsadeideas.springboot.backend.aprirest.entities.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

     List<Cliente> findAll();

     Page<Cliente> findAll(Pageable pageable);

     Cliente findById(Long id);

     Cliente save(Cliente cliente);

     void delete(Long id);

     List<Region> findAllRegiones();

}
