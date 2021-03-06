package es.unican.supermercado.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import es.unican.supermercado.businessLayer.entities.LineaPedido;

/**
 * CDI Bean para mantener el carrito
 * de la sesion de usuario.
 *  
 * @author Juan Manuel Lomas
 *
 */
@Named
@SessionScoped
public class CarritoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	private double total = 0.0;
	private Date fechaRecogida;
	private LineaPedido lineaPedido = new LineaPedido();
	private List<LineaPedido> lineasPedido = new ArrayList<LineaPedido>();	
	
	// Atributos JSF
	private FacesContext context;
	private ResourceBundle bundle;
	private FacesMessage msg;
	
	@Inject
	UsuarioBean usuarioBean;
	
	/**
	 * Constructor
	 */
	public CarritoBean() {				
	}
	
	/**
	 * Metodo que agrega una linea de pedido al carro
	 * 
	 * @return el listado general de articulos si ha ido todo bien,
	 * la misma pagina en cualquier otro caso
	 */
	public String agregarArticuloAlCarrito(){				
		
		if(lineaPedido.getCantidad() <= lineaPedido.getArticulo().getUnidadesStock()){
			lineasPedido.add(lineaPedido);
			total += (lineaPedido.getArticulo().getPrecio() * lineaPedido.getCantidad());
			lineaPedido = new LineaPedido();
			
			return "/app/listaArticulos.xhtml";
		}else{
			context = FacesContext.getCurrentInstance();
			bundle = context.getApplication().getResourceBundle(context, "msg");
			
			lineaPedido.setCantidad(0);
			
			msg = new FacesMessage(bundle.getString("cart_not_enough_stok"));
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
			
			return null;
		}
		
	}

	/**
	 * Funcion para vaciar el carrito.
	 * Util tras realizar un pedido.
	 */
	public void empty(){
		lineasPedido = new ArrayList<LineaPedido>();
		lineaPedido = new LineaPedido();
		total = 0;
		fechaRecogida = null;		
	}
	
	// Getters y Setters
	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public LineaPedido getLineaPedido() {
		return lineaPedido;
	}

	public void setLineaPedido(LineaPedido lineaPedido) {
		this.lineaPedido = lineaPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFechaRecogida() {
		return fechaRecogida;
	}

	public void setFechaRecogida(Date fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
}