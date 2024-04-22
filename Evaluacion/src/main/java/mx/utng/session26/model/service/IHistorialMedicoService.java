package mx.utng.session26.model.service;

import java.util.List;

import mx.utng.session26.model.entity.HistorialMedico;



public interface IHistorialMedicoService { 
    List<HistorialMedico> list();
    void save(HistorialMedico historial);
    HistorialMedico getById(Long id);
    void delete(Long id);
}
