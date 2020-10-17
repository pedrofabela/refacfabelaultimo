package utilidades;

public class ObjPrepareStatement {
	 
	private String campoTabla;
	private String tipoDato;
	private Object valorCampo;
	
	public ObjPrepareStatement(String campo, String tipo, Object valor){
		this.setCampoTabla(campo);
		this.setTipoDato(tipo);
		this.setValorCampo(valor);
	}
	 
	public String getCampoTabla() {
		return campoTabla;
	}
	public void setCampoTabla(String campoTabla) {
		this.campoTabla = campoTabla;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public Object getValorCampo() {
		return valorCampo;
	}
	public void setValorCampo(Object valorCampo) {
		this.valorCampo = valorCampo;
	}

}
