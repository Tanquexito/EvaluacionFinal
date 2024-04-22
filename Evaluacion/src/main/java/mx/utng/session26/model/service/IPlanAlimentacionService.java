package mx.utng.session26.model.service;

import java.util.List;

import mx.utng.session26.model.entity.PlanAlimentacion;





public interface IPlanAlimentacionService { 
    List<PlanAlimentacion> list();
    void save(PlanAlimentacion plan);
    PlanAlimentacion getById(Long id);
    void delete(Long id);
}
