package com.api.superaapi.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="transferencia")
public class Transaction {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 50)
	private LocalDate data_transferencia;

	@Column(precision = 20, scale = 2)
	private Float valor ;
	@Column(nullable = false,length = 15)
	private String tipo ;
	@Column(nullable = false,length = 50)
	private String nome_operador_transacao ;

	@OneToOne(mappedBy ="transaction" ,cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
	private Conta conta;


	public Transaction() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDate getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(LocalDate data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
