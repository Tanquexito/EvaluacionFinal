package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.HistorialMedico;



@Repository
public class HistorialMedicoDaoImpl implements IHistorialMedicoDao {
        @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<HistorialMedico> list() {
        return em.createQuery("from HistorialMedico").getResultList();
    }

    @Override
    public void save(HistorialMedico historial) {
        System.out.println("HistorialMedico id="+historial.getId());
        if(historial.getId() != null && historial.getId() >0){
            //Actualizo estudiante
            em.merge(historial);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(historial);
        }
    }

    @Override
    public HistorialMedico getById(Long id) {
        return em.find(HistorialMedico.class, id);
    }

    @Override
    public void delete(Long id) {
        HistorialMedico historial = getById(id);
        em.remove(historial);
    }

    
}
    

