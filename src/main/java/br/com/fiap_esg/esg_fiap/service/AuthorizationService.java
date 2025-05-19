package br.com.fiap_esg.esg_fiap.service;

import br.com.fiap_esg.esg_fiap.entity.UsuarioEntity;
import br.com.fiap_esg.esg_fiap.reponse.UsuarioResposeDTO;
import br.com.fiap_esg.esg_fiap.repository.UsuarioRepository;
import br.com.fiap_esg.esg_fiap.request.RegisterRequestDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails usuarioEntity = usuarioRepository.findByLogin(username);

        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }

        return usuarioEntity;
    }

    public UsuarioResposeDTO salvarUsuario(RegisterRequestDTO usuarioDTO){

        String senhaCriptografada = new
                BCryptPasswordEncoder().encode(usuarioDTO.senha());

        UsuarioEntity usuario = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResposeDTO(usuarioSalvo);

    }

}