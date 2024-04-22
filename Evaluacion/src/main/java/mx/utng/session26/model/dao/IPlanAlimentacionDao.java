package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.PlanAlimentacion;





public interface IPlanAlimentacionDao {
    List<PlanAlimentacion> list();
    void save(PlanAlimentacion plan);
    PlanAlimentacion getById(Long id);
    void delete(Long id);
}
