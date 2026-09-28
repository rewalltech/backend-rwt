package backend.api.controller;

import backend.api.dto.PatrocinioRequest;
import backend.api.model.Patrocinio;
import backend.api.service.PatrocinioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrocinio")
public class PatrocinioController {

    private final PatrocinioService patrocinioService;

    public PatrocinioController(PatrocinioService patrocinioService) {
        this.patrocinioService = patrocinioService;
    }

    @PostMapping
    public ResponseEntity<Patrocinio> criar(
            @RequestBody PatrocinioRequest request
    ) {

        Patrocinio patrocinio = new Patrocinio();

        patrocinio.setNome(request.getNome());
        patrocinio.setEmail(request.getEmail());
        patrocinio.setTelefone(request.getTelefone());
        patrocinio.setTipo(request.getTipo());
        patrocinio.setValor(request.getValor());
        patrocinio.setMensagem(request.getMensagem());
        patrocinio.setTermos(request.getTermos());

        Patrocinio salvo =
                patrocinioService.salvar(patrocinio);

        return ResponseEntity
                .status(201)
                .body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Patrocinio>> listar() {

        return ResponseEntity.ok(
                patrocinioService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrocinio> buscarPorId(
            @PathVariable Long id
    ) {

        return patrocinioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}