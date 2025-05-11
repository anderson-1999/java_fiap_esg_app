package br.com.fiap_esg.esg_fiap.service;

import br.com.fiap_esg.esg_fiap.entity.PoluicaoEntity;
import br.com.fiap_esg.esg_fiap.reponse.PoluicaoResponseDTO;
import br.com.fiap_esg.esg_fiap.repository.PoluicaoRepository;
import br.com.fiap_esg.esg_fiap.request.PoluicaoRequestDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
@Data
public class PoluicaoService {

    @Autowired
    private PoluicaoRepository poluicaoRepository;

    public PoluicaoResponseDTO gravarPoluicao(PoluicaoRequestDTO poluicaoRequestDTO) {
        try {
            notNull(poluicaoRequestDTO, "Os dados de poluicao são obrigatórios");
            PoluicaoEntity novaPoluicao = new PoluicaoEntity();
            BeanUtils.copyProperties(poluicaoRequestDTO, novaPoluicao);

            PoluicaoEntity poluicaoSalvo = poluicaoRepository.save(novaPoluicao);
            return new PoluicaoResponseDTO(poluicaoSalvo);
        } catch (Exception e) {
            throw new NullPointerException("Erro ao gravar dados da poluição");
        }
    }


    public PoluicaoResponseDTO buscaDadosPoluicao(Long id) {
        try {
            Optional<PoluicaoEntity> entity = poluicaoRepository.findById(id);

            if (entity.isPresent()){
                return new PoluicaoResponseDTO(entity.get());
            } else {
                throw new RuntimeException("Dados da poluição não existe!");
            }

        } catch (Exception e) {
            throw new NullPointerException("Erro ao buscar dados de Poluição");
        }
    }

    public List<PoluicaoResponseDTO> buscarTodasPoluicoes(){
        return poluicaoRepository
                .findAll()
                .stream()
                .map(PoluicaoResponseDTO::new)
                .toList();

    }

    @Transactional
    public void deletaDadosPoluicao(Long id) {
        Optional<PoluicaoEntity> entity = poluicaoRepository.findById(id);
        if (entity.isPresent()){
            poluicaoRepository.deleteById(id);
        }  else {
            throw new RuntimeException("Dados da poluição não existe!");
        }

    }


}