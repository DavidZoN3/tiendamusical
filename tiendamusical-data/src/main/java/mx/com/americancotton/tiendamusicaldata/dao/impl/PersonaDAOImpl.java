/**
 * 
 */
package mx.com.americancotton.tiendamusicaldata.dao.impl;

import mx.com.americancotton.tiendamusicaldata.common.CommonDAO;
import mx.com.americancotton.tiendamusicaldata.dao.PersonaDAO;
import mx.com.americancotton.tiendamusicalentities.entities.Persona;

/**
 * @author David Serrano
 *Clase que implementa el CRUD Generico y las funciones de la interface PersonaDAO
 */
public class PersonaDAOImpl extends CommonDAO<Persona, PersonaDAO> {
	/**
	 * Metodo que permite consuktar una persona por su usuario y contraseña
	 * @param usuario {@link String} usuario capturado por la persona.
	 * @param password {@link String} contraseña capturada por la persona.
	 * @return {@link Persona} persona encontrada.
	 */
	public Persona findUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}
}
