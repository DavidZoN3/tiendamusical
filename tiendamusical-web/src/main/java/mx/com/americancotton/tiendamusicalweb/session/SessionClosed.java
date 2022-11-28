/**
 * 
 */
package mx.com.americancotton.tiendamusicalweb.session;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mx.com.americancotton.tiendamusicalweb.utils.CommonUtils;

/**
 * @author David Serrano
 *Clase que permite cerrar la sesion del usuario y redireccionar a la pantalla del login
 */
@ManagedBean
@ViewScoped
public class SessionClosed {
	
	/**
	 * Metodo que érmite cerrar la session del usuario
	 */
	public void cerrarSesion() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			CommonUtils.redireccionar("/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Ups!", "Hubo un problema al tratar de regresar al login, Favor de intentar más tarde");
			e.printStackTrace();
		}
	}
}
