package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdministradorService {
    @Autowired
    private IAdministradorRepository administradorRepository;

    public Administrador incluir(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Collection<Administrador> obterLista() {
        return (Collection<Administrador>) administradorRepository.findAll();
    }

    public void excluir(Integer id) {
        administradorRepository.deleteById(id);
    }

    public Administrador obterPorId(Integer id) {
        return administradorRepository.findById(id).orElse(null);
    }
}
