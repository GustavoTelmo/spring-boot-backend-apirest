package com.bolsadeideas.springboot.backend.aprirest.daos;
import com.bolsadeideas.springboot.backend.aprirest.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario,Long> {

    Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    Usuario findByUsername2(String username);

}