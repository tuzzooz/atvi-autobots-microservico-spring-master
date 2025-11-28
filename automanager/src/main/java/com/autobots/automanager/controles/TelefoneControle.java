package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {
    @Autowired
    private TelefoneRepositorio repositorio;

    @GetMapping("/telefone/{id}")
    public Telefone obterTelefone(@PathVariable long id) {
        List<Telefone> telefones = repositorio.findAll();
        if (telefones == null) return null;
        for (Telefone tel : telefones) {
            if (tel != null && tel.getId() != null) {
                if (tel.getId().longValue() == id) {
                    return tel;
                }
            }
        }
        return null;
    }

    @GetMapping("/telefones")
    public List<Telefone> obterTelefones() {
        return repositorio.findAll();
    }

    @PostMapping("/cadastro")
    public void cadastrarTelefone(@RequestBody Telefone telefone) {
        repositorio.save(telefone);
    }

    @PutMapping("/atualizar")
    public void atualizarTelefone(@RequestBody Telefone atualizacao) {
        Telefone telefone = repositorio.getById(atualizacao.getId());
        TelefoneAtualizador atualizador = new TelefoneAtualizador();
        atualizador.atualizar(telefone, atualizacao);
        repositorio.save(telefone);
    }

    @DeleteMapping("/excluir")
    public void excluirTelefone(@RequestBody Telefone exclusao) {
        Telefone telefone = repositorio.getById(exclusao.getId());
        repositorio.delete(telefone);
    }
}
