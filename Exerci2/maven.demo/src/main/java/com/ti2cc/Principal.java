package com.ti2cc;

public class Principal {

	public static void main(String[] args) {
DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		slav usuario = new slav(13, "pablito", 19,"CC");
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
		
		//Mostrar Aluno do Curso CC	
		System.out.println("==== Mostrar Alunos do Curso CC === ");
		slav[] usuarios = dao.getCC();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usuário
		usuario.setNome("Novo nome");
		dao.atualizarUsuario(usuario);

		//Mostrar Alunos do Curso EF
		System.out.println("==== Mostrar alunos do Curso EM=== ");
		usuarios = dao.getEM();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		//Excluir usuário
		dao.excluirAluno(usuario.getCodigo());
		
		//Mostrar usuários
		usuarios = dao.getslav();
		System.out.println("==== Mostrar Alunos === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		dao.close();
	}

	}


