/**
 * 
 */
package mx.com.americancotton.tiendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import mx.com.americancotton.tiendamusicalentities.entities.Persona;

/**
 * @author David Serrano
 *Clase DAO uqe realiza el CRUD con SpringJPA para la tabla persona.
 */
public interface PersonaDAO extends PagingAndSortingRepository<Persona, Long>{

	/**
	 * Metodo que permite consultar el usuario que que trata iniciar session.
	 * @param usuario {@link String} usuario capturado por la persona.
	 * @param password {@link String} contraseña capturada por la persona.
	 * @return {@link Persona} objeto con la persona encontrada.
	 */
	@Query("SELECT p FROM Persona p WHERE p.usuario = ?1 AND p.password = ?2")
	Persona findByUsuarioAndPassword(String usuario, String password);
	
}
