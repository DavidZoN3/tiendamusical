/**
 * 
 */
package mx.com.americancotton.tiendamusicalservices.service;

import mx.com.americancotton.tiendamusicalentities.entities.Persona;

/**
 * @author David Serrano
 *Interface que realiza la logica de negocio para el inicio de session de la persona.
 */
public interface LoginService {
	/**
	 * Metodo que permite consultar un usuario que trata de ingresar a session en la tienda musical
	 * @param usuario {@link String} Usuario capturado por la pesona.
	 * @param password {@link String} Contraseña capturada por la persona
	 * @return {@link Persona} Usuario encontrado en la base de datos.
	 */
	Persona consultarUsuarioLogin(String usuario, String password);

}
