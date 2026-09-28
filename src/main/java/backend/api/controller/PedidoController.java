package backend.api.controller;

import backend.api.dto.PedidoRequest;
import backend.api.model.Pedido;
import backend.api.service.PedidoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(
            @RequestBody PedidoRequest request
    ) {

        Pedido pedido = new Pedido();

        pedido.setNome(request.getNome());
        pedido.setTelefone(request.getTelefone());
        pedido.setEmail(request.getEmail());
        pedido.setEndereco(request.getEndereco());
        pedido.setAltura(request.getAltura());
        pedido.setMao(request.getMao());
        pedido.setMensagem(request.getMensagem());

        Pedido salvo = pedidoService.salvar(pedido);

        return ResponseEntity
                .status(201)
                .body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {

        return ResponseEntity.ok(
                pedidoService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(
            @PathVariable Long id
    ) {

        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}