/**
 * 
 */
package mx.com.americancotton.tiendamusicalentities.dto;

import mx.com.americancotton.tiendamusicalentities.entities.Album;
import mx.com.americancotton.tiendamusicalentities.entities.Artista;

/**
 * @author David Serrano Clase DTO personalizada para obtener información de los
 *         albums que el cliente busca a través del filtro de busqueda del
 *         dashboard.
 */
public class ArtistaAlbumDTO {

	/**
	 * Objeto que contiene la información del Artista
	 */
	private Artista artista;

	/**
	 * Objeto que contiene la información del Album
	 */
	private Album album;

	/**
	 * Constructor default
	 */
	public ArtistaAlbumDTO() {
		super();
	}

	/**
	 * Constructor que inicializa la informacion consultada para la busqueda de
	 * lbums
	 * 
	 * @param album   {@link Album} objeto que contiene el album del artista.
	 * @param artista {@link Artista} objeto que contiene el artista(banda o
	 *                solista).
	 */
	public ArtistaAlbumDTO(Album album, Artista artista) {
		this.album = album;
		this.artista = artista;
	}

	/**
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
}
