package mx.utng.session26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.IRegistroActividadDao;
import mx.utng.session26.model.entity.RegistroActividad;




@Service
public class RegistroActividadServiceImpl implements IRegistroActividadService {
    @Autowired
    private IRegistroActividadDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<RegistroActividad> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RegistroActividad registro) {
        dao.save(registro);
    }

    @Transactional(readOnly = true)
    @Override
    public RegistroActividad getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    
}
