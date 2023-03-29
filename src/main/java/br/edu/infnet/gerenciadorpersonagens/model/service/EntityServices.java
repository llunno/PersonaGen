package br.edu.infnet.gerenciadorpersonagens.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServices {
    public final AparenciaService aparenciaService;
    public final CriadorService criadorService;
    public final PersonagemService personagemService;
    public final HabilidadeService habilidadeService;
    public final PersonalidadeService personalidadeService;
    public final AdministradorService adminService;

    @Autowired
    public EntityServices(AparenciaService aparenciaService, CriadorService criadorService, PersonagemService personagemService, HabilidadeService habilidadeService, PersonalidadeService personalidadeService, AdministradorService adminService) {
        this.aparenciaService = aparenciaService;
        this.criadorService = criadorService;
        this.personagemService = personagemService;
        this.habilidadeService = habilidadeService;
        this.personalidadeService = personalidadeService;
        this.adminService = adminService;
    }
}
