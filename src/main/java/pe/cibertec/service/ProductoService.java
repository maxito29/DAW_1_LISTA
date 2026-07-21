package pe.cibertec.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pe.cibertec.entities.Producto;
import pe.cibertec.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @PersistenceContext
    private EntityManager em;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Insercion por lotes (Batch Insert)
    @Transactional
    public void registrarLote (List<Producto> productos) {
        int i = 0;
        for (Producto p : productos) {
            em.persist(p);
            i++;
            if(i % 10 == 0){
                em.flush();
                em.clear();
            }
        }
    }

    public List<Producto> listarTodos( ){
        return em.createQuery("SELECT p FROM Producto p", Producto.class)
                .setHint("org.hibernate.fetchSize", 5)  //Trae todos, pero lee de 5 en 5
                .getResultList();
    }

    public List<Producto> buscar(String nombre){
        return productoRepository.findByNombre(nombre);
    }
}
