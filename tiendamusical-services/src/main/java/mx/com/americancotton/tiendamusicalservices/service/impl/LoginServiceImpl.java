/**
 * 
 */
package mx.com.americancotton.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.americancotton.tiendamusicaldata.dao.PersonaDAO;
import mx.com.americancotton.tiendamusicalentities.entities.Persona;
import mx.com.americancotton.tiendamusicalservices.service.LoginService;

/**
 * @author David Serrano
 *Clase que implementa las funciones para la logica de negocio para la pantalla de login.
 */

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private PersonaDAO personaDAOImpl;
	
	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		
		return this.personaDAOImpl.findByUsuarioAndPassword(usuario, password);
	}

}
