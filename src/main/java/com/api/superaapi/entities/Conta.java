package com.api.superaapi.entities;




import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="conta")
public class Conta{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_conta;
	@Column(nullable = false,length = 50)
	private String  nome_responsavel;
	@OneToOne
	@JoinColumn(name = "id")
	private Transaction transaction;
	
	
	public Conta() {
		
	}

	public UUID getId_conta() {
		return id_conta;
	}

	public void setId_conta(UUID id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
