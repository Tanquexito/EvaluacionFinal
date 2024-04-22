package mx.utng.session26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.IPlanAlimentacionDao;
import mx.utng.session26.model.entity.PlanAlimentacion;






@Service
public class PlanAlimentacionServiceImpl implements IPlanAlimentacionService {
    @Autowired
    private IPlanAlimentacionDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<PlanAlimentacion> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(PlanAlimentacion plan) {
        dao.save(plan);
    }

    @Transactional(readOnly = true)
    @Override
    public PlanAlimentacion getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    
}
