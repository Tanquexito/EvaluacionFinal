package mx.utng.session26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.IHistorialMedicoDao;
import mx.utng.session26.model.entity.HistorialMedico;




@Service
public class HistorialMedicoServiceImpl implements IHistorialMedicoService {
    @Autowired
    private IHistorialMedicoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<HistorialMedico> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(HistorialMedico historial) {
        dao.save(historial);
    }

    @Transactional(readOnly = true)
    @Override
    public HistorialMedico getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    
}
