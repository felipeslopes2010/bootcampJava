package br.com.alura.livraria.modelo;

import java.time.LocalDate;

public class Autor {
	
	String nome;
	String email;
	LocalDate dataNascimento;
	String curriculo;
		
	public Autor(String nome, String email, LocalDate dataNascimento, String curriculo) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.curriculo = curriculo;
	}
	
	public Autor() {
		
	}
		
	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + ", curriculo="
				+ curriculo + "]";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	
}

