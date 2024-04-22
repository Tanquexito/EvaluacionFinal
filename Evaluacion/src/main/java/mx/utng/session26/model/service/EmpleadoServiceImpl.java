package mx.utng.session26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.IEmpleadoDao;
import mx.utng.session26.model.entity.Empleado;





@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    @Autowired
    private IEmpleadoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Empleado> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Empleado empleado) {
        dao.save(empleado);
    }

    @Transactional(readOnly = true)
    @Override
    public Empleado getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    
}
