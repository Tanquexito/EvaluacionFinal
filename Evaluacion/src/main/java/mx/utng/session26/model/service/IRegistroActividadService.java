package mx.utng.session26.model.service;

import java.util.List;

import mx.utng.session26.model.entity.RegistroActividad;



public interface IRegistroActividadService {
    List<RegistroActividad> list();
    void save(RegistroActividad registro);
    RegistroActividad getById(Long id);
    void delete(Long id);
}
