package es.unican.supermercado.businessLayer.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase de dominio que representa
 * un pedido del supermercado
 * @author Juan Manuel Lomas
 *
 */
@Entity @Table(name = "PEDIDO")
@NamedQueries({
	@NamedQuery ( name = "pedidoPorEstadoyFecha", query = "SELECT p FROM Pedido p WHERE p.estado = :estado ORDER BY p.fecha DESC" )
})
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;
	private Date fecha;
	private Date horaRecogida;	

	// Relaciones con otras clases de dominio
	@ManyToOne
	@JoinColumn ( name = "usuario_fk" )
	private Usuario usuario;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<LineaPedido> lineasPedido;	
	
	// Getters y setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public EstadoPedido getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	
	public Date getHoraRecogida() {
		return horaRecogida;
	}

	public void setHoraRecogida(Date horaRecogida) {
		this.horaRecogida = horaRecogida;
	}
	
}
