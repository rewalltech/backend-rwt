package backend.api.controller;

import backend.api.dto.PatrocinioRequest;
import backend.api.model.Patrocinio;
import backend.api.service.PatrocinioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patrocinio")
public class PatrocinioController {

    private final PatrocinioService patrocinioService;

    public PatrocinioController(PatrocinioService patrocinioService) {
        this.patrocinioService = patrocinioService;
    }

    @PostMapping
    public ResponseEntity<Patrocinio> criarPatrocinio(
            @RequestBody PatrocinioRequest request) {

        Patrocinio patrocinio = new Patrocinio();

        patrocinio.setNome(request.getNome());
        patrocinio.setEmail(request.getEmail());
        patrocinio.setTelefone(request.getTelefone());
        patrocinio.setTipo(request.getTipo());
        patrocinio.setValor(request.getValor());
        patrocinio.setMensagem(request.getMensagem());
        patrocinio.setTermos(request.getTermos());

        Patrocinio patrocinioSalvo =
                patrocinioService.salvar(patrocinio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patrocinioSalvo);
    }
}