/**
 * 
 */
package mx.com.americancotton.tiendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.com.americancotton.tiendamusicalentities.dto.ArtistaAlbumDTO;
import mx.com.americancotton.tiendamusicalservices.service.HomeService;

/**
 * @author DavidSerrano Clase que controla el flujo de informacion para la
 *         pantalla de Home de cualquier tipo de usuario
 */
@ManagedBean
@ViewScoped
public class HomeController {

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
	 * Inicializando pantalla
	 */
	@PostConstruct
	public void init() {
		System.out.println("Inicializando HOME");
	}

	/**
	 * Metodo que permite obtener los albums de los artistasencontradoas en la base de datos con respecto al filtro ingresado por el usuario
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistasAlbumDTO!=null) {
			this.artistasAlbumDTO.forEach(artistasAlbumDTO -> {
				System.out.println("Artista: "+artistasAlbumDTO.getArtista().getNombre());
			});
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
}
