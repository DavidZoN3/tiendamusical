/**
 * 
 */
package mx.com.americancotton.tiendamusicalweb.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.americancotton.tiendamusicalentities.dto.ArtistaAlbumDTO;
import mx.com.americancotton.tiendamusicalservices.service.HomeService;
import mx.com.americancotton.tiendamusicalweb.session.SessionBean;
import mx.com.americancotton.tiendamusicalweb.utils.CommonUtils;

/**
 * @author DavidSerrano Clase que controla el flujo de informacion para la
 *         pantalla de Home de cualquier tipo de usuario
 */
@ManagedBean
@ViewScoped
public class HomeController {
	
	/**
	 * Objeto que permite mostrar los mensajes del log en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

	/**
	 * Texto ingresado por el usuatio en el buscador
	 */
	private String filtro;

	/**
	 * lISTA OBTENIDA A PARTOIR DEL FILTRO INGRESADO EN EL BUSCADOR
	 */
	private List<ArtistaAlbumDTO> artistasAlbumDTO;

	/**
	 * Se inyecta el objeto de Spring con jsf para obtener los metodos con logica de
	 * negocio del HOME.
	 */
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	
	/**
	 * Objeto que almacena la informacion en session
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	/**
	 * Inicializando pantalla
	 */
	@PostConstruct
	public void init() {
//		System.out.println("Inicializando HOME");
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		LOGGER.fatal("FATAL");
	}

	/**
	 * Metodo que permite obtener los albums de los artistasencontradoas en la base de datos con respecto al filtro ingresado por el usuario
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistasAlbumDTO!=null) {
			this.artistasAlbumDTO.forEach(artistasAlbumDTO -> {
				LOGGER.info("Artista: "+artistasAlbumDTO.getArtista().getNombre());
			});
		}
	}
	
	/**
	 * Metodo que permite ver el detalle del album seleccionado por el cliente
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album seleccionado.
	 */
	public void verDetalleAlbum(ArtistaAlbumDTO artistaAlbumDTO) {
		this.sessionBean.setArtistaAlbumDTO(artistaAlbumDTO);
		try {
			CommonUtils.redireccionar("/pages/cliente/detalle.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Hubo un error de formato en la pagina a ingresar, favor de contactar con soporte.");
			e.printStackTrace();
		}
	}

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	/**
	 * @return the artistasAlbumDTO
	 */
	public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
		return artistasAlbumDTO;
	}

	/**
	 * @param artistasAlbumDTO the artistasAlbumDTO to set
	 */
	public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
		this.artistasAlbumDTO = artistasAlbumDTO;
	}

	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}

	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
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
