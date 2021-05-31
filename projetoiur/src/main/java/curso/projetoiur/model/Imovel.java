package curso.projetoiur.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import javassist.bytecode.ByteArray;

@Entity
public class Imovel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String rua;
	private int numero;
	private String tipo;
	private String descricao;
	private BigDecimal valor;
	private Date data;
	
	
	
	@Lob
	@Column(name = "imagem")
	private byte[] imagem;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long Id) {
		this.id = Id;
	}
	
	public String getRua() {
		return this.rua;
	}
	public void setRua( String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero( int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	
	
}
