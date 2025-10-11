package br.com.fiap_esg.esg_fiap.repository;

import br.com.fiap_esg.esg_fiap.entity.UsuarioEntity;
import br.com.fiap_esg.esg_fiap.reponse.UsuarioResposeDTO;
import br.com.fiap_esg.esg_fiap.request.RegisterRequestDTO;
import br.com.fiap_esg.esg_fiap.utils.UserRole;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Should get Usuario successfully from case1")
    void findByLoginCase1() {

        String login = "anderson";
        String senha = "senha";
        UserRole role = UserRole.valueOf("ADMIN");

        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO(
                login,
                senha,
                role
        );

        UsuarioResposeDTO usuarioResposeDTO = this.register(registerRequestDTO);

        UserDetails usuario = this.usuarioRepository.findByLogin(login);

        assertNotNull(usuario);

    }

    @Test
    @DisplayName("Should not get Usuario from when usuario not exists from case2")
    void findByLoginCase2() {

        String login = "anderson";

        UserDetails usuario = this.usuarioRepository.findByLogin(login);

        assertNull(usuario);

    }

    private UsuarioResposeDTO register(RegisterRequestDTO requestDTO){

        UsuarioEntity usuario = new UsuarioEntity();
        BeanUtils.copyProperties(requestDTO, usuario);
        this.entityManager.persist(usuario);

        return new UsuarioResposeDTO(usuario);

    }

}