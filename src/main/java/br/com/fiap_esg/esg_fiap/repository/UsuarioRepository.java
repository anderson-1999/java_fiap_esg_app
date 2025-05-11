package br.com.fiap_esg.esg_fiap.repository;

import br.com.fiap_esg.esg_fiap.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UserDetails findByLogin(String login);

}
