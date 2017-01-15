package dao;

import java.util.List;

import javax.ejb.Stateless;

import domain.Articulo;

/**
 * Clase DAO para persistir articulos
 * @author Juan Manuel Lomas
 *
 */
@Stateless
public class ArticulosDAO extends GenericDAO<Articulo> implements IArticulosDAO {

	public Articulo addArticulo(Articulo articulo) {
		return create(articulo);
	}

	public void deleteArticulo(Articulo articulo) {
		delete(articulo);
	}

	public Articulo updateArticulo(Articulo articulo) {
		return update(articulo);
	}

	public Articulo getArticulo(String id) {
		return find(id);
	}

	public List<Articulo> listArticulos() {
		return findAll();
	}
	
}
