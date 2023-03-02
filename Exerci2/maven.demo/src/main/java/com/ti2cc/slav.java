package com.ti2cc;

public class slav {
	private int codigo;
	private String nome;
	private int idade;
	private String curso;
	
	public slav() {
		this.codigo = -1;
		this.nome = "";
		this.idade = 0;
		this.curso = "";
	}
	
	public slav(int Codigo, String nome, int idade, String Curso) {
		this.codigo = Codigo;
		this.nome = nome;
		this.idade = idade;
		this.curso = Curso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String Curso) {
		this.curso = Curso;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", idade=" + idade + ", Curso=" + curso + "]";
	}	
}
