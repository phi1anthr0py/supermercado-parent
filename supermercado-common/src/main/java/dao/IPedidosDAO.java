package dao;

import java.util.List;

import javax.ejb.Local;

import domain.Pedido;
import domain.EstadoPedido;

@Local
public interface IPedidosDAO {

	public Pedido addPedido(Pedido pedido);
	
	public void deletePedido(Pedido pedido);
	
	public Pedido updatePedido(Pedido pedido);
	
	public Pedido getPedido(String id);
	
	public Pedido getUltimoPedidoPendiente(EstadoPedido estado);
	
	public List<Pedido> listPedidos();
}
