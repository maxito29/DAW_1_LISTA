package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}