/**
 * 
 */
package mx.com.americancotton.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.americancotton.tiendamusicalentities.entities.Persona;

/**
 * @author David Serrano
 * Clase que mantendra la informacion de la session de usuario
 *
 */
@ManagedBean
@SessionScoped
public class SessionBean {

	/**
	 * Objeto persona que se mantendra en la session
	 */
	private Persona persona;
	
	@PostConstruct
	public void init() {
		System.out.println("Creando sesion...");
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
