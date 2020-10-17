package utilidades;

import java.io.Serializable;

public class Constantes implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;
	
     //GENERALES
	 public static final String tablaDual="dual";
	 public static final String nombreSistema = "SEGESCN";
	 public static String usuarioseg= "SEGESCN";
	 public static final String modulo0 = "0";
	 public static final String moduloSegEsc = "segesc";

	 
	 //JOVENES CON VALOR
     //TABLAS
	 public static final String TablaUsuarios="USUARIOS";
	 public static final String TablaModulosPerfiles="MODULOSPERFILES";
	 public static final String TablaModulos="MODULOS";
	 public static final String catJoven= "CATALOGOSERVICIO";
	 
		 /**************DESARROLLO**********************************************************
	
		public static final boolean esDesarrollo = true;
		public static final String rutaProyectos = "http://172.20.2.110:8080/";	
		public static final String rutareportesjasper = "C:\\reportes/JasperSoft/permanecerEstudiando/";		                                                  
		public static final String rutaArch = "C:/archivos/permanecerEstudiando/";  //cambair cuando els ervidor este activo
                    public static final String rutaEstilos = "http://172.20.2.110:8080/estilosUDAI/" ;
		public static final String rutaManuales = "C:/manuales/permanecerEstudiando.pdf";
		public static final String rutaImages ="C:\\reportes/JasperSoft/logos/";		
		//*/
		
	 
		//******************* PRODUCCION*******************************************************
      
		public static final boolean esDesarrollo = true;		
		public static final String rutaProyectos =   "http://localhost:8084/";
		public static final String rutareportesjasper = "C:/REPORTES/";		                                                  
		public static final String rutaArch = "C:/REPORTES";  				
		public static final String rutaEstilos = "http://aplicaciones.edugem.gob.mx/estilosUDAI/";		                                        
		public static final String rutaImages = "C:/REPORTES";
		public static final String rutaManuales = "http://aplicaciones.edugem.gob.mx/manuales/ManualUsuario3P.pdf";		
		//*/
	  

	  public static void enviaMensajeConsola(String cadena){
			if(Constantes.esDesarrollo){
				System.out.println("MENSAJE_DESARROLLO: "+cadena);
			}
		}
} 

