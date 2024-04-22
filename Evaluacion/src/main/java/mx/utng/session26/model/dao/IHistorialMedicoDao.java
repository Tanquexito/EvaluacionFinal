package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.HistorialMedico;



public interface IHistorialMedicoDao {
    List<HistorialMedico> list();
    void save(HistorialMedico historial);
    HistorialMedico getById(Long id);
    void delete(Long id);
}
