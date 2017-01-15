package dao;

import java.util.List;

import javax.ejb.Stateless;

import domain.Pedido;

/**
 * Clase DAO para persistir pedidos
 * @author Juan Manuel Lomas
 *
 */
@Stateless
public class PedidosDAO extends GenericDAO<Pedido> implements IPedidosDAO {

	public Pedido addPedido(Pedido pedido) {		
		return create(pedido);
	}

	public void deletePedido(Pedido pedido) {
		delete(pedido);
	}

	public Pedido updatePedido(Pedido pedido) {
		return update(pedido);
	}

	public Pedido getPedidoo(String id) {
		return find(id);
	}

	public List<Pedido> listPedidos() {
		return findAll();
	}
	
}
