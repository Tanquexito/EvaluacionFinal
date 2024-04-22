package mx.utng.session26.model.service;

import java.util.List;

import mx.utng.session26.model.entity.Empleado;



public interface IEmpleadoService {
    List<Empleado> list();
    void save(Empleado empleado);
    Empleado getById(Long id);
    void delete(Long id);
}
