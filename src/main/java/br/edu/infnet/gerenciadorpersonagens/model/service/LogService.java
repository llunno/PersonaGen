package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.repository.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LogService {

    private final ILogRepository logRepository;

    @Autowired
    public LogService(ILogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log incluir(Log log) {
        return logRepository.save(log);
    }

    public Collection<Log> obterLista() {
        return (Collection<Log>) logRepository.findAll();
    }

    public void excluir(Integer id) {
        logRepository.deleteById(id);
    }

    public void excluirTodos() {
        logRepository.deleteAll();
    }

    public Log obterPorId(Integer id) {
        return logRepository.findById(id).orElse(null);
    }

    public Collection<Log> obterListaPorUsuario(Integer userId) {
        return logRepository.findAllByUser(userId);
    }
}
