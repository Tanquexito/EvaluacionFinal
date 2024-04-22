package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.Empleado;


public interface IEmpleadoDao {
    List<Empleado> list();
    void save(Empleado empleado);
    Empleado getById(Long id);
    void delete(Long id);
}
