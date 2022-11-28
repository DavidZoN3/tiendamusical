/**
 * 
 */
package mx.com.americancotton.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.com.americancotton.tiendamusicalentities.entities.Persona;
import mx.com.americancotton.tiendamusicalservices.service.LoginService;
import mx.com.americancotton.tiendamusicalweb.session.SessionBean;
import mx.com.americancotton.tiendamusicalweb.utils.CommonUtils;

/**
 * @author David Serrano Controlador que se encarga del flujo del la pantalla
 *         del login.xhtml
 *
 */
@ManagedBean
@ViewScoped
public class LoginController {

	/**
	 * Usuario capturado por la persona
	 */
	private String usuario;
	/**
	 * Contraseña capturada por la persona
	 */
	private String password;
	
	/**
	 * Propiedad de la logica de negocio inyectada con JSF y SPRING.
	 */
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginServiceImpl;
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	@PostConstruct
	public void init() {
		System.out.println("Inicializando login...");
	}
	
	/**
	 * Metodo que permite al usuario ingresar a su pantalla de home
	 */
	public void entrar() {
		
		Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);		
		
		if (personaConsultada != null) {
//			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso!", "Bienvenido al home");
			try {
				this.sessionBean.setPersona(personaConsultada);
				
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error!", "Formato incorrecto en el cual se ingresa a la pantalla deseada.");
			}
		}else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error!", "El usuario y/o contraseña son incorrectos");
		}
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
