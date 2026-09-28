package backend.api.service;

import backend.api.model.Patrocinio;
import backend.api.repository.PatrocinioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinioService {

    private final PatrocinioRepository patrocinioRepository;

    public PatrocinioService(
            PatrocinioRepository patrocinioRepository
    ) {
        this.patrocinioRepository = patrocinioRepository;
    }

    public Patrocinio salvar(Patrocinio patrocinio) {
        return patrocinioRepository.save(patrocinio);
    }

    public List<Patrocinio> listar() {
        return patrocinioRepository.findAll();
    }

    public Optional<Patrocinio> buscarPorId(Long id) {
        return patrocinioRepository.findById(id);
    }
}