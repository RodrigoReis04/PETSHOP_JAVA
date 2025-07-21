import java.util.Scanner;

public final class Login {

	private static Login instance;
	private Usuario usuarioLogado;
	public Usuarios usuarios = Usuarios.getInstance();
	Scanner scanner = new Scanner(System.in);

	public void exibeLogin(){
		while (true) {
			System.out.println("=============================");
			System.out.println("  Bem vindo ao java petshow  ");
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("Matrícula--------------------");
			String matricula = scanner.next();
			System.out.println("=Senha=======================");
			String senha = scanner.next();
			System.out.println("=============================");
			System.out.println("=============================");
			boolean retornoLogin = realizaLogin(matricula, senha);

			if (retornoLogin) {
				if (this.usuarioLogado.getTipo().equals("Gerente")) {
					Gerente gerente = (Gerente) getUsuarioLogado();
					while (true) {
						System.out.println("======================-");
						System.out.println("Escolha uma das opções-");
						System.out.println("-----------------------");
						System.out.println("1 - Cadastrar vendedor-");
						System.out.println("2 - Remove vendedor ---");
						System.out.println("3 - Relatório de vendas");
						System.out.println("4 - Relatório de v. ind");
						System.out.println("5 - Logout");
						System.out.println("======================-");
						
						String opcao = scanner.next();
						if (opcao.equals("1")) {
							System.out.println("Nome--------------");
							String nomeCadastro = scanner.next();
							System.out.println("matricula---------");
							String matriculaCadastro = scanner.next();
							System.out.println("senha-------------");
							String senhaCadastro = scanner.next();
							gerente.cadastraVendedor(nomeCadastro,
									matriculaCadastro, senhaCadastro);

						} else if (opcao.equals("2")) {
							System.out.println("matricula---------");
							matricula = scanner.next();
							gerente.removeUsuario(matricula);

						}else if(opcao.equals("3")) {
							gerente.gerarRelatorio();
						
						}else if(opcao.equals("4")) {
							System.out.println("+ Matricula-----------");
							matricula = scanner.next();
							gerente.gerarRelatorioIndividual(matricula);
						}
						else if (opcao.equals("5")) {
							setUsuarioLogado(null);
							break;
						} else {
							System.out.println(
									"opção inválida. Digite uma nova opção.");
						}

					}
				} else if (this.usuarioLogado.getTipo().equals("Vendedor")) {
					while (true) {
						System.out.println("======================");
						System.out.println("Escolha uma das opções");
						System.out.println("----------------------");
						System.out.println("1 - logout------------");
						System.out.println("----------------------");
						String opcao = scanner.next();
						if (opcao.equals("1")) {
							setUsuarioLogado(null);
							break;
						} else {
							System.out.println(
									"opção inválida. Digite uma nova opção.");
						}

					}
				}
			}

		}
	}

	public boolean realizaLogin(String matricula, String senha){
		Usuario usuario = usuarios.checkCredenciais(matricula, senha);
		if (usuario != null) {
			this.usuarioLogado = usuario;
			System.out.println("Login realizado com sucesso !!");
			return true;
		}
		System.out.println("Credenciais inválidas");
		return false;
	}
	public Usuario getUsuarioLogado(){
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado){
		this.usuarioLogado = usuarioLogado;
	}

	public static Login getinstance(){
		if (instance == null) {
			instance = new Login();

		}
		return instance;
	}
}
