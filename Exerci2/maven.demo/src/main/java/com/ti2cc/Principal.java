package com.ti2cc;

public class Principal {

	public static void main(String[] args) {
DAO dao = new DAO();
		
		dao.conectar();
        int entrada;
		//Inserir um elemento na tabela
		System.out.println("1 - Inserir um elemento na tabela");
		System.out.println("2 - Listar Alunos de CC");
		System.out.println("3 - Listar Alunos de EM");
		System.out.println("4 - Atualizar um Aluno");
		System.out.println("5 - Excluir um Aluno ");
		System.out.println("6 - Listar Todos os Alunos");
		
		slav[] usuers = dao.getslav();
		int j=usuers.length;
		do {
        System.out.println("Escolha uma Opcao");
		entrada = MyIO.readInt();
		
		//Inserir um elemento na tabela
		
		
		if(entrada == 1) {
			System.out.println("Insira o nome");
			String nomer = MyIO.readLine();
			System.out.println("Insira a idade");
			int idades = MyIO.readInt();
			System.out.println("Insira a Curso");
			String Cursor =MyIO.readLine();
			j++;
		slav usuario2 = new slav(j, nomer, idades,Cursor);
		if(dao.inserirUsuario(usuario2) == true) {
			System.out.println("Inserção com sucesso -> " + usuario2.toString());
		}
		}
		
		slav[] usuarios = dao.getslav();
		//Mostrar Alunos do Curso CC	
		
		if(entrada == 2) {
			System.out.println("==== Mostrar Alunos do Curso CC === ");
			slav[] usuarios2 = dao.getCC();
		for(int i = 0; i < usuarios2.length; i++) {
			System.out.println(usuarios2[i].toString());
		}
		}
		
		if(entrada == 4) {
		//Atualizar usuário
			System.out.println("Insira o Codigo do Aluno a ser Alterado");
			int entrada2 = MyIO.readInt();
			System.out.println("Insira novo nome do Aluno");
			String usu = MyIO.readLine();
			System.out.println("Insira a nova idade");
			int idad = MyIO.readInt();
			System.out.println("Insira o novo curso");
			String cursoi = MyIO.readLine();
			
		slav[] usuarios2 = dao.getslav();
		slav usuarios3 = usuarios2[entrada2];
		usuarios3.setNome(usu);usuarios3.setIdade(idad);usuarios3.setCurso(cursoi);
		dao.atualizarUsuario(usuarios3);
		}
		if(entrada == 3) {
		//Mostrar Alunos do Curso EM
		System.out.println("==== Mostrar alunos do Curso EM=== ");
		slav[] usuarios2 = dao.getEM();
		for(int i = 0; i < usuarios2.length; i++) {
			System.out.println(usuarios2[i].toString());
		}
		}
		if(entrada == 5) {
		//Excluir usuário
			System.out.println("Digite o codigo");
			int entrada2 = MyIO.readInt();
		dao.excluirAluno(entrada2);
		}
		if(entrada == 6) {
		//Mostrar usuários
		usuarios = dao.getslav();
		System.out.println("==== Mostrar Alunos === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		}}while(entrada!=7);
		
		dao.close();
	}

	}


