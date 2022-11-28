/**
 * 
 */
package mx.com.americancotton.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.americancotton.tiendamusicaldata.dao.ArtistaDAO;
import mx.com.americancotton.tiendamusicalentities.dto.ArtistaAlbumDTO;
import mx.com.americancotton.tiendamusicalentities.entities.Persona;
import mx.com.americancotton.tiendamusicalservices.service.HomeService;

/**
 * @author David Serrano
 *Clase que implementa los metodos de logica de negocio de la interface de HomeService
 */
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private ArtistaDAO artistaDAOImpl;

	@Override
	public List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro) {
		// TODO Auto-generated method stub
		return this.artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}
	


}
