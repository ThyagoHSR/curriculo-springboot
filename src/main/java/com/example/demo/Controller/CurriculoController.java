package com.example.demo.Controller;



import com.example.demo.Model.Curriculo;
import com.example.demo.Repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {

    @Autowired
    private com.example.demo.Repository.CurriculoRepository CurriculoRepository;

    @GetMapping
    public List<Curriculo> listarCurriculos() {
        return CurriculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curriculo buscarCurriculo(@PathVariable Long id) {
        return CurriculoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Curriculo cadastrarCurriculo(@RequestBody Curriculo curriculo) {
        return CurriculoRepository.save(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculoAtualizado) {
        Curriculo curriculo = CurriculoRepository.findById(id).orElse(null);
        if (curriculo != null) {
            curriculo.setNome(curriculoAtualizado.getNome());
            curriculo.setExperiencia(curriculoAtualizado.getExperiencia());
            curriculo.setCep(curriculoAtualizado.getCep());
            curriculo.setNumero(curriculo.getNumero());

            return CurriculoRepository.save(curriculo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirCurriculo(@PathVariable Long id) {
        CurriculoRepository.deleteById(id);
    }
}
