
public class Gerente extends Usuario implements IUsuario {
	
	public static Vendas vendas = Vendas.getInstance();
	Usuarios usuarios;

	public Gerente(String nome, String matricula, String Senha) {
		super(nome, matricula, Senha, "Gerente");
	}
	public void cadastraVendedor(String nome, String matricula, String senha){
		usuarios.adicionaUsuario(nome, matricula, senha, "Vendedor");

	}
	public void removeUsuario(String matricula){
		usuarios.removeUsuario(matricula);
	}  
	@Override
	public void gerarRelatorio() {
		vendas.gerarRelatorio();
	}
	public void gerarRelatorioIndividual(String matricula) {
		vendas.gerarRelatorioIndividual(matricula);
	}

}
