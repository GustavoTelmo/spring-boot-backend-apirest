package com.bolsadeideas.springboot.backend.aprirest.services;
import com.bolsadeideas.springboot.backend.aprirest.daos.IClienteDao;
import com.bolsadeideas.springboot.backend.aprirest.entities.Cliente;
import com.bolsadeideas.springboot.backend.aprirest.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao iClienteDao;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        return (List<Cliente>) iClienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return iClienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return iClienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       iClienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return iClienteDao.findAllRegiones();
    }

}
