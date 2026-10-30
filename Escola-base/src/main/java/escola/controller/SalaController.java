
package escola.controller;

import escola.model.Sala;
import escola.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Sala> cadastrar(
            @Valid @RequestBody Sala sala) {

        Sala novaSala = service.cadastrar(sala);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaSala);
    }

    @GetMapping
    public ResponseEntity<List<Sala>> listarTodas() {

        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}/reservar")
    public ResponseEntity<Void> reservar(@PathVariable Long id) {

        service.reservar(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/liberar")
    public ResponseEntity<Void> liberar(@PathVariable Long id) {

        service.liberar(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
