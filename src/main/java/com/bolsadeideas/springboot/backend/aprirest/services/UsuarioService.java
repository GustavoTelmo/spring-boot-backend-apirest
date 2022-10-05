package com.bolsadeideas.springboot.backend.aprirest.services;
import com.bolsadeideas.springboot.backend.aprirest.daos.IUsuarioDao;
import com.bolsadeideas.springboot.backend.aprirest.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioDao.findByUsername(username);
        if(usuario==null){
            log.error("error no existe el usuario '"+username+"' en el sistema");
            throw new UsernameNotFoundException("error no existe el usuario'"+username+"' en el sistema");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority->log.info("role: "+authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(),usuario.getPassword(),usuario.getEnabled(),true,
                true,true,authorities);
    }
}