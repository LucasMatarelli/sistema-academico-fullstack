package com.sistema.academico.controller;

import com.sistema.academico.model.Curso;
import com.sistema.academico.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @PostMapping
    public Curso criar(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    // Método PUT para Edição (Atualiza o curso pelo ID)
    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso detalhesCurso) {
        return cursoRepository.findById(id)
            .map(cursoExistente -> {
                cursoExistente.setNome(detalhesCurso.getNome());
                cursoExistente.setCargaHoraria(detalhesCurso.getCargaHoraria());
                Curso cursoAtualizado = cursoRepository.save(cursoExistente);
                return ResponseEntity.ok(cursoAtualizado);
            }).orElse(ResponseEntity.notFound().build());
    }
}