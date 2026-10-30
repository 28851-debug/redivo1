
package escola.service;

import escola.model.Sala;
import escola.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public Sala cadastrar(Sala sala) {

        if (repository.existsByCodigo(sala.getCodigo())) {
            throw new IllegalStateException("Já existe uma sala com esse código");
        }

        sala.setReservada(false);

        return repository.save(sala);
    }

    public List<Sala> listarTodas() {
        return repository.findAll();
    }

    public Sala buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new SalaNaoEncontradaException("Sala não encontrada"));
    }

    public void reservar(Long id) {

        Sala sala = buscarPorId(id);

        if (sala.isReservada()) {
            throw new IllegalStateException("A sala já está reservada");
        }

        sala.setReservada(true);

        repository.save(sala);
    }

    public void liberar(Long id) {

        Sala sala = buscarPorId(id);

        if (!sala.isReservada()) {
            throw new IllegalStateException("A sala já está livre");
        }

        sala.setReservada(false);

        repository.save(sala);
    }

    public void excluir(Long id) {

        Sala sala = buscarPorId(id);

        if (sala.isReservada()) {
            throw new IllegalStateException(
                    "Não é possível excluir uma sala reservada");
        }

        repository.delete(sala);
    }
}
