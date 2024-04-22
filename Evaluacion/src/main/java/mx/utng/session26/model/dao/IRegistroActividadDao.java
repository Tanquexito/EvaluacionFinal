package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.RegistroActividad;



public interface IRegistroActividadDao {
    List<RegistroActividad> list();
    void save(RegistroActividad registro);
    RegistroActividad getById(Long id);
    void delete(Long id);
}
