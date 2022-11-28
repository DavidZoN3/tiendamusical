/**
 * 
 */
package mx.com.americancotton.tiendamusicalservices.service;

import java.util.List;

import mx.com.americancotton.tiendamusicalentities.dto.ArtistaAlbumDTO;

/**
 * @author David Serrano
 *Interface que define los metodos de logica de negocio ´para la pantalla del Home.
 */
public interface HomeService {

	/**
	 * Metodo que permite consultar los albums con base al filtro que ingrese el cliente con base al filtro que ingrese el cliente en el buscador de su home
	 * @param filtro {@link String} Texto ingresado por el usuario.
	 * @return {@link List} lista de albums que coinciden con el texto ingresado
	 */
	List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro);
}
