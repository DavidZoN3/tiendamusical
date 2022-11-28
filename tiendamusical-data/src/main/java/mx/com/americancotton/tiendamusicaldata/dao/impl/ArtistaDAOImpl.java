/**
 * 
 */
package mx.com.americancotton.tiendamusicaldata.dao.impl;

import java.util.List;

import mx.com.americancotton.tiendamusicaldata.common.CommonDAO;
import mx.com.americancotton.tiendamusicaldata.dao.ArtistaDAO;
import mx.com.americancotton.tiendamusicalentities.dto.ArtistaAlbumDTO;
import mx.com.americancotton.tiendamusicalentities.entities.Artista;

/**
 * @author David Serrano
 *Clase que implementa el CRUD Generico para realizar las transacciones a la tabla de Artista.
 */
public class ArtistaDAOImpl extends CommonDAO<Artista, ArtistaDAO> {

	public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro) {
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}
}
