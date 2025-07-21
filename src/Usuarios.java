import java.util.ArrayList;
import java.util.List;

public final class Usuarios {

	private static Usuarios instance;

	private List<Usuario> usuarios;

	public Usuarios() {
		this.usuarios = new ArrayList<>();
		Usuario manuel = new Usuario("Manuel", "12345678", "senha1", "Gerente");
		usuarios.add(manuel);
	}
	public Usuario adicionaUsuario(String nome, String matricula, String senha,
			String tipo){
		Usuario usuario = new Usuario(nome, matricula, senha, tipo);
		usuarios.add(usuario);
		System.out.println("Usuário foi adicionado com sucesso!");
		return usuario;
	}
	public int indexof(String matricula){
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		return -1;
	}

	public Usuario checkCredenciais(String matricula, String senha){
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getMatricula().equals(matricula)) {
				if (usuarios.get(i).getSenha().equals(senha)) {
					return usuarios.get(i);
				}
			}
		}
		return null;
	}

	public void removeUsuario(String matricula){
		int indice = this.indexof(matricula);
		if (indice != -1) {
			usuarios.remove(indice);
			System.out.println("Usuário removido com sucesso!");

		} else {
			System.out.println("Usuário não foi encontrado");
		}
	}

	public List<Usuario> getUsuario(){
		return this.usuarios;
	}
	public static Usuarios getInstance(){
		if (instance == null) {
			instance = new Usuarios();

		}

		return instance;
	}
}
