package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.PlanAlimentacion;




@Repository
public class PlanAlimentacionDaoImpl implements IPlanAlimentacionDao {
        @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<PlanAlimentacion> list() {
        return em.createQuery("from PlanAlimentacion").getResultList();
    }

    @Override
    public void save(PlanAlimentacion plan) {
        System.out.println("PlanAlimentacion id="+plan.getId());
        if(plan.getId() != null && plan.getId() >0){
            //Actualizo estudiante
            em.merge(plan);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(plan);
        }
    }

    @Override
    public PlanAlimentacion getById(Long id) {
        return em.find(PlanAlimentacion.class, id);
    }

    @Override
    public void delete(Long id) {
        PlanAlimentacion plan = getById(id);
        em.remove(plan);
    }

    
}
    

