package beans;

import java.io.Serializable;


public class usuarioBean implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;

	private String NAMEUSUARIO;
	private String PASSWORD;
	private Integer PERFIL;
	private String NAMEPERFIL;
	private String USUARIO;
	private String FILTRO;
	 
	
	public String getNAMEUSUARIO() {
		return NAMEUSUARIO;
	}
	public void setNAMEUSUARIO(String nAMEUSUARIO) {
		NAMEUSUARIO = nAMEUSUARIO;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Integer getPERFIL() {
		return PERFIL;
	}
	public void setPERFIL(Integer pERFIL) {
		PERFIL = pERFIL;
	}
	public String getNAMEPERFIL() {
		return NAMEPERFIL;
	}
	public void setNAMEPERFIL(String nAMEPERFIL) {
		NAMEPERFIL = nAMEPERFIL;
	}
	public String getUSUARIO() {
		return USUARIO;
	}
	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}
	public String getFILTRO() {
		return FILTRO;
	}
	public void setFILTRO(String fILTRO) {
		FILTRO = fILTRO;
	}
	
}
