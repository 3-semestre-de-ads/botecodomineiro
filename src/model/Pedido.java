package model;

public class Pedido {
	
	private int idPedido;
	private String tipo;
	private String mesa;
	private String status;
	private String cliente;
	private int idUsuario;
	
	public Pedido(String tipo, String mesa, String status, String cliente) {
		this.tipo = tipo;
		this.mesa = mesa;
		this.status = status;
		this.cliente = cliente;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}
