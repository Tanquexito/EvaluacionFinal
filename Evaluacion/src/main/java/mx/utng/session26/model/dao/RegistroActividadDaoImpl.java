package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.RegistroActividad;



@Repository
public class RegistroActividadDaoImpl implements IRegistroActividadDao {
        @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<RegistroActividad> list() {
        return em.createQuery("from RegistroActividad").getResultList();
    }

    @Override
    public void save(RegistroActividad registro) {
        System.out.println("RegistroActividad id="+registro.getId());
        if(registro.getId() != null && registro.getId() >0){
            //Actualizo estudiante
            em.merge(registro);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(registro);
        }
    }

    @Override
    public RegistroActividad getById(Long id) {
        return em.find(RegistroActividad.class, id);
    }

    @Override
    public void delete(Long id) {
        RegistroActividad registro = getById(id);
        em.remove(registro);
    }

    
}
    

