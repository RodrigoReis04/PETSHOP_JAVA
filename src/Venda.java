
public class Venda {
	private double valor;
	private String formaPagamento;
	private String matricula;
	
	public Venda(double valor, String formaPagamento, String matricula) {
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.matricula = matricula;
		
		 
	}

	public double getValor(){
		return valor;
	}

	public void setValor(double valor){
		this.valor = valor;
	}

	public String getFormaPagamento(){
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento){
		this.formaPagamento = formaPagamento;
	}

	public String getMatricula(){
		return matricula;
	}

	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	
	
	
}
