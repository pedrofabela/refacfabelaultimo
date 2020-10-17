package daos;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.InputStream;
import java.sql.DriverManager;

import javax.sql.DataSource;
import oracle.jdbc.rowset.OracleCachedRowSet;


import mappers.Mapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;


public class OracleDAOFactory implements DAOFactory {
	
    private static String dbdriver = "oracle.jdbc.driver.OracleDriver";
    private Connection conn;
    private Statement st;
    private PreparedStatement pstmt;
    
   
     /*// PRODUCCION
    private String username = "REFACFAB";	
	private String url = "jdbc:oracle:thin:@192.168.0.80:1521:xe";	
    private String password = "fabela041287p"; 
   	//*/
    
    //DESARROLLO
    private String username = "REFACFAB";	
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";	
    private String password = "fabela041287p"; 
	//*/
    
    public Statement getSt() {
		return this.st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}
	
	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

//*	SIN POOL
	public Connection createConnection() throws SQLException{
		Constantes.enviaMensajeConsola("entre a los parametros de conexion");
		conn = DriverManager.getConnection(url,username, password);
		return conn;
	}
	
	/*CON POOL
   public Connection createConnection() throws SQLException, NamingException, ClassNotFoundException{
		Class.forName(OracleDAOFactory.dbdriver);
		Connection conn = null;
    	if(this.conn == null){
    		conn=regresarConection();
    	}
    	else{
    		if(this.conn.isClosed()){
    			this.conn=null;
    			conn=regresarConection();
    		}
    		else{
    			conn=this.conn;
    		}
    	}
    	return conn;
    	
	}
	//CON POOL
   public  Connection regresarConection()throws SQLException, NamingException, ClassNotFoundException{
		Connection conn;
    	Class.forName(OracleDAOFactory.dbdriver);
    	
    	Context initContext = new InitialContext();
    	Context envContext  = (Context)initContext.lookup("java:/comp/env");
    	Constantes.enviaMensajeConsola("entre a los parametros de conexion");		
    	DataSource fuenteDatos=(DataSource)envContext.lookup("jdbc/PERMANECER"); 
    	
		conn= fuenteDatos.getConnection();
    	return conn;
	} 
	
	*/
	
	public void closeConnection() throws SQLException {
		if(conn!=null) {
		   conn.close();
		}
	}

	public void closeStatement() throws SQLException {
		if(this.st!=null || !this.st.isClosed()) {
		   //System.out.println(this.st.isClosed());
		   this.st.close();
		}
	}

	//SIN POOL DE CONEXIONES
	public void createStatement() throws Exception {
        Class.forName(OracleDAOFactory.dbdriver);
        conn = DriverManager.getConnection(url, 
                username, password);
        st = conn.createStatement();
	}

	/*CON POOL
	public void createStatement() throws Exception {
        Class.forName(OracleDAOFactory.dbdriver);
        this.conn = this.createConnection();
        this.st = this.conn.createStatement();
	}*/
	
	public Statement createStatement2(Connection conn1) throws Exception {
		Statement st1 = conn1.createStatement();
        return st1;
	}

	public void closeAll(ResultSet rs1, Statement st1, Connection conn1) throws SQLException {
		if(rs1!=null){
            rs1.close();
            rs1=null;
        }
		if(st1!=null){
			st1.close();
			st1=null;
        }
        if(conn1!=null){
        	conn1.close();
        	conn1=null;
       }
	}
	
	/*public Statement createStatement2() throws Exception {
		Class.forName(OracleDAOFactory.dbdriver);
		conn = createConnection();
        st = conn.createStatement();
        return st;
	}*/



	public void updateQueryCons(final String sql) throws Exception {
		try {
			this.st.executeUpdate(sql);
		}finally{}
	}
        

	public void updateQuery(final String sql) throws Exception {
		try {
			this.createStatement();
			this.st.executeUpdate(sql);
		} finally {
			this.closeConnection();
			this.closeStatement();
		}
	}
	//no cierra conecion por si se realiza un rollback  2/SEPT/2011
	public void updateQuery2(final String sql) throws Exception {
		try {
			this.createStatement();
			this.st.executeUpdate(sql);
		} finally {
			this.closeStatement();
		}
	}	
	
//ROLLBACK 2/SEPT/2011
	public void rollback() throws Exception {
		try {
			this.conn.rollback();
		} finally {
			this.closeConnection();

		}
	}
	

	public Object queryForObject(final String sql, final Mapper m) throws Exception {
		Object retorno = null;
		try {
			this.createStatement();
            ResultSet rs = this.st.executeQuery(sql);
            if ( rs.next()){            
               retorno = m.mapRow(rs);
            }
		} finally {
			this.closeConnection();
		} 
        return retorno;
	}
	
	public String queryStringUnCampoOpen( Statement stei,String sql) throws Exception {
        String cad="";
        try {
            ResultSet rs = stei.executeQuery(sql);
            if(rs.next()){
            	cad = rs.getString(1);
            }
        } finally {
        	
        }
        return cad;
    }
	
	public List<Object> queryForList(final String sql, final Mapper m) throws Exception {
		List<Object> list = new ArrayList<Object>();
		try{
			this.createStatement();
			ResultSet rs = this.st.executeQuery(sql);
			while(rs.next()){
				list.add(m.mapRow(rs));
			}
			rs.close();
		}finally{
			this.closeConnection();
		}
		
		return list;
	}
	
	//Unico registro
    public Integer queryInteger(String sql) throws Exception {
        Integer num = 0;
        try {
        	this.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            num = rs.getInt(1);
        } finally {
        	this.closeConnection();
        }
        return num;
    }
    
    public String queryStringUnCampo(String sql) throws Exception {
        String cad="";
        try {
        	this.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
            	cad = rs.getString(1);
            }
        } finally {
        	this.closeConnection();
        }
        return cad;
    }
    
    
    public ResultSet queryResultSet(String sql) throws Exception{
        ResultSet rs=null;
        OracleCachedRowSet cachedRowSet=null;

        try{
        	
        	this.createStatement();
        	rs=st.executeQuery(sql);
        
        //resultSet = preparedStatement.executeQuery();
        	cachedRowSet=new OracleCachedRowSet();
        	cachedRowSet.populate(rs);
        	rs.close();

        
       // rs.close();
	    } finally {
	    	this.closeConnection();
	    }
   /* while (rs.next()) {
        System.out.println("rdinamico" +rs.getString("CMPCCT"));
        System.out.println("rdinamico" +rs.getString("CMPNOMCCT"));
     }*/
	    return cachedRowSet;
    }

	@Override
	public boolean queryForExist(final String sql) throws Exception {
		boolean existe = false;

		try {
			this.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			}
		} finally {
			this.closeConnection();
		}
		return existe;
	}
	
	public void updateQuery2(Connection conexion, final String sql) throws Exception {
		try {
			//createStatement();
			this.st = conexion.createStatement();
			this.st.executeUpdate(sql);
		} finally {
			if(this.st!=null) {
				   this.st.close();
				   this.st=null;
				}
		}
	}
	
	//ROLLBACK 2/SEPT/2011
	public void rollback(Connection conexion) throws Exception {
		//System.out.println("entra a rollback");
		try {
			if(conexion!=null && !conexion.isClosed())
				conexion.rollback();
		} finally {
			if(conexion!=null) {
				conexion.close();
				conexion=null;
				}
		}
		//System.out.println("sale de rollback");
	}
	
	public void closeConnection1(Connection conexion1) throws SQLException {
		if(conexion1!=null) {
			conexion1.close();
		}
	}
	
	public boolean queryInsert(String Tabla, ArrayList<ObjPrepareStatement> arregloCampos) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryInsert---------------");
		boolean inserto = false;
		StringBuffer query=new StringBuffer();
		StringBuffer camposInsertar=new StringBuffer();
		String unionCampos = " ";
		
		query.append("INSERT INTO ");
		query.append(Tabla);
		query.append(" (");
		
		camposInsertar.append("(");
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				camposInsertar.append(unionCampos);
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE") ||  obj.getTipoDato().toUpperCase().contains("CODIGO")){
					camposInsertar.append(obj.getValorCampo().toString());
					
				}else{ 
					//***********************************************emh
					//if(obj.getTipoDato().toUpperCase().contains("STRING")){
					   //obj.setValorCampo( obj.getValorCampo().toString());          //.toUpperCase());
					//} //*********************************************fin emh
					  camposInsertar.append("? ");
				}
				unionCampos=", ";
			}//if(obj.getValorCampo()!=null){
		}
		
		query.append(") ");
		camposInsertar.append(") ");
		
		String queryCompleto = query.toString()+" VALUES "+camposInsertar.toString();
		Constantes.enviaMensajeConsola("queryCompleto--->"+queryCompleto);
		
		this.pstmt = this.createConnection().prepareStatement(queryCompleto);
		int registroInsertado = -1;
		try{
			Constantes.enviaMensajeConsola("---tamao arreglo--"+arregloCampos.size());
			asignarTiposPSTMT(arregloCampos, 1);
			Constantes.enviaMensajeConsola("---termino asignacion tipos----");
			registroInsertado = this.pstmt.executeUpdate();
			Constantes.enviaMensajeConsola("-------EJECUTO INSERT ---------------");
		}finally{
			if(this.pstmt!=null){
				this.pstmt.close();
				Constantes.enviaMensajeConsola("-------CERRO STATEMENT ---------------");
				this.pstmt=null;
			}
			if(this.conn!=null){
				this.conn.close();
				Constantes.enviaMensajeConsola("-------CERRO CONEXION ---------------");
				this.conn=null;
			}
				
		}
		if(registroInsertado==1){
			inserto=true;
		}
		
		
		return inserto;
		
	}
	
	public boolean queryInsertTransaccion(Connection c, PreparedStatement p, String Tabla, ArrayList<ObjPrepareStatement> arregloCampos) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryInsert---------------");
		boolean inserto = false;
		StringBuffer query=new StringBuffer();
		StringBuffer camposInsertar=new StringBuffer();
		String unionCampos = " ";
		
		query.append("INSERT INTO ");
		query.append(Tabla);
		query.append(" (");
		
		camposInsertar.append("(");
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				camposInsertar.append(unionCampos);
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
					camposInsertar.append(obj.getValorCampo().toString());
				}else{
					camposInsertar.append("? ");
				}
				unionCampos=", ";
			}//if(obj.getValorCampo()!=null){
		}
		
		query.append(") ");
		camposInsertar.append(") ");
		
		String queryCompleto = query.toString()+" VALUES "+camposInsertar.toString();
		Constantes.enviaMensajeConsola("queryCompleto--->"+queryCompleto);
		
		p = c.prepareStatement(queryCompleto);
		int registroInsertado = -1;

		
		Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCampos.size());
		asignarTiposPSTMT(arregloCampos, 1,p);
		Constantes.enviaMensajeConsola("---termino asignacion tipos----");
		registroInsertado = p.executeUpdate();
		Constantes.enviaMensajeConsola("-------EJECUTO INSERT ---------------");

		
		if(registroInsertado==1){
			inserto=true;
		}
		
		
		return inserto;
		
	}
        
        
        public boolean queryConsultoTransaccion(Connection c, PreparedStatement p, String Tabla, ArrayList<ObjPrepareStatement> arregloCampos) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryInsert---------------");
		boolean inserto = false;
		StringBuffer query=new StringBuffer();
		StringBuffer camposInsertar=new StringBuffer();
		String unionCampos = " ";
		
		query.append("INSERT INTO ");
		query.append(Tabla);
		query.append(" (");
		
		camposInsertar.append("(");
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				camposInsertar.append(unionCampos);
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
					camposInsertar.append(obj.getValorCampo().toString());
				}else{
					camposInsertar.append("? ");
				}
				unionCampos=", ";
			}//if(obj.getValorCampo()!=null){
		}
		
		query.append(") ");
		camposInsertar.append(") ");
		
		String queryCompleto = query.toString()+" VALUES "+camposInsertar.toString();
		Constantes.enviaMensajeConsola("queryCompleto--->"+queryCompleto);
		
		p = c.prepareStatement(queryCompleto);
		int registroInsertado = -1;

		
		Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCampos.size());
		asignarTiposPSTMT(arregloCampos, 1,p);
		Constantes.enviaMensajeConsola("---termino asignacion tipos----");
		registroInsertado = p.executeUpdate();
		Constantes.enviaMensajeConsola("-------EJECUTO INSERT ---------------");

		
		if(registroInsertado==1){
			inserto=true;
		}
		
		
		return inserto;
		
	}
	
	
	public boolean queryUpdate(String Tabla, ArrayList<ObjPrepareStatement> arregloCampos, String where) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryUpdate---------------");
		boolean modifico = false;
		StringBuffer query=new StringBuffer();
		String unionCampos = " ";
		
		query.append("UPDATE ");
		query.append(Tabla);
		query.append(" SET ");
		
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=");
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
					query.append(obj.getValorCampo().toString());
				}else{
					//if(obj.getTipoDato().toUpperCase().contains("STRING")){ //emh***
					  // obj.setValorCampo( obj.getValorCampo().toString());                     //.toUpperCase()); //emh****
					//}   //emh***
					query.append("? ");
				}
				unionCampos=", ";
			}else{//if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=null");
			}
		}
		
		if(where!=null && where.length()!=0){
			query.append(where);
		}
		
		
		Constantes.enviaMensajeConsola("queryCompleto--->"+query.toString());
		
		this.pstmt = this.createConnection().prepareStatement(query.toString());
		int posicion = 1;
		int registroInsertado = -1;
		try{
			Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCampos.size());
			for(ObjPrepareStatement obj: arregloCampos){
				/////************* SE ASIGNA TIPO DE DATO SEGUN CAMPO DE LA TABLA, Se deber�n agregar los tipos de dato faltantes***********
				if(obj.getValorCampo()!=null){
					if(obj.getTipoDato().toUpperCase().contains("STRING")){
						this.pstmt.setString(posicion, (String) obj.getValorCampo());
						Constantes.enviaMensajeConsola("pstmt String["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("INT")){
						this.pstmt.setInt(posicion, (Integer) obj.getValorCampo());
						Constantes.enviaMensajeConsola("pstmt INT["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("SECUENCIA")){
						//this.pstmt.setInt(posicion, 0);
						Constantes.enviaMensajeConsola("pstmt SECUENCIA["+posicion+"]--->"+obj.getValorCampo().toString());
						Constantes.enviaMensajeConsola("----- NO SETEA TIPO A PSTMT -----");
						posicion--;
						
					}else if(obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
						
						//this.pstmt.setDate(posicion, (java.sql.Date) obj.getValorCampo() );
						Constantes.enviaMensajeConsola("pstmt CURRENT_DATE["+posicion+"]--->"+obj.getValorCampo().toString());
						posicion--;
						
					}else if(obj.getTipoDato().toUpperCase().contains("DATE")){
						
						SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date fechaPrueba = formatoFecha.parse(obj.getValorCampo().toString());
						java.sql.Date sqlFecha = new java.sql.Date(fechaPrueba.getTime());
						
						this.pstmt.setDate(posicion, sqlFecha);
						Constantes.enviaMensajeConsola("pstmt DATE["+posicion+"]--->"+obj.getValorCampo().toString());
						
					}else if(obj.getTipoDato().toUpperCase().contains("BLOB")){
						this.pstmt.setBlob(posicion, (InputStream) obj.getValorCampo() );
						Constantes.enviaMensajeConsola("pstmt BLOB["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("LONG")){
						this.pstmt.setLong(posicion, (Long) obj.getValorCampo());
						Constantes.enviaMensajeConsola("pstmt LONG["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("DOUBLE")){
						this.pstmt.setDouble(posicion, (Double) obj.getValorCampo());
						Constantes.enviaMensajeConsola("pstmt DOUBLE["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("BIGDECIMAL")){
						this.pstmt.setBigDecimal(posicion, (BigDecimal) obj.getValorCampo());
						Constantes.enviaMensajeConsola("pstmt BIGDECIMAL["+posicion+"]--->"+obj.getValorCampo().toString());
					}
					posicion++;
				} //if(obj.getValorCampo()!=null){
					
			}	//for(ObjPrepareStatement obj: arregloCampos){
			Constantes.enviaMensajeConsola("---termino asignacion tipos----");
			registroInsertado = this.pstmt.executeUpdate();
			Constantes.enviaMensajeConsola("-------EJECUTO UPDATE ---------------");
		}finally{
			if(this.pstmt!=null){
				this.pstmt.close();
				this.pstmt=null;
			}
			if(this.conn!=null){
				this.conn.close();
				this.conn=null;
			}
				
		}
		if(registroInsertado==1){
			modifico=true;
		}
		
		
		return modifico;
		
	}

	
	//********************************************************************************************************}
	public boolean queryUpdateTransaccion(Connection c, PreparedStatement p, String Tabla, ArrayList<ObjPrepareStatement> arregloCampos, String where) throws Exception {
		//Constantes.enviaMensajeConsola("------ENTRA A  queryUpdate---------------");
		boolean modifico = false;
		StringBuffer query=new StringBuffer();
		String unionCampos = " ";
		
		query.append("UPDATE ");
		query.append(Tabla);
		query.append(" SET ");
		
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=");
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
					query.append(obj.getValorCampo().toString());
				}else{
					//if(obj.getTipoDato().toUpperCase().contains("STRING")){ //emh***
					   //obj.setValorCampo( obj.getValorCampo().toString());                  //.toUpperCase()); //emh****
					//}   //emh***
					query.append("? ");
				}
				unionCampos=", ";
			}else{//if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=null");
			}
		}
		
		if(where!=null && where.length()!=0){
			query.append(where);
		}
		
		
		//Constantes.enviaMensajeConsola("queryCompleto--->"+query.toString());
		
                //reacondicionando la conexion  
		p = c.prepareStatement(query.toString());
		int posicion = 1;
		int registroInsertado = -1;
		
			Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCampos.size());
			for(ObjPrepareStatement obj: arregloCampos){
				/////************* SE ASIGNA TIPO DE DATO SEGUN CAMPO DE LA TABLA, Se deber�n agregar los tipos de dato faltantes***********
				if(obj.getValorCampo()!=null){
					if(obj.getTipoDato().toUpperCase().contains("STRING")){
						p.setString(posicion, (String) obj.getValorCampo());
						Constantes.enviaMensajeConsola("p String["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("INT")){
						p.setInt(posicion, (Integer) obj.getValorCampo());
						Constantes.enviaMensajeConsola("p INT["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("SECUENCIA")){
						//this.pstmt.setInt(posicion, 0);
						Constantes.enviaMensajeConsola("p SECUENCIA["+posicion+"]--->"+obj.getValorCampo().toString());
						Constantes.enviaMensajeConsola("----- NO SETEA TIPO A PSTMT -----");
						posicion--;
						
					}else if(obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
						
						//this.pstmt.setDate(posicion, (java.sql.Date) obj.getValorCampo() );
						Constantes.enviaMensajeConsola("p CURRENT_DATE["+posicion+"]--->"+obj.getValorCampo().toString());
						posicion--;
						
					}else if(obj.getTipoDato().toUpperCase().contains("DATE")){
						
						SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date fechaPrueba = formatoFecha.parse(obj.getValorCampo().toString());
						java.sql.Date sqlFecha = new java.sql.Date(fechaPrueba.getTime());
						
						p.setDate(posicion, sqlFecha);
						Constantes.enviaMensajeConsola("p DATE["+posicion+"]--->"+obj.getValorCampo().toString());
						
					}else if(obj.getTipoDato().toUpperCase().contains("BLOB")){
						p.setBlob(posicion, (InputStream) obj.getValorCampo() );
						Constantes.enviaMensajeConsola("p BLOB["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("LONG")){
						p.setLong(posicion, (Long) obj.getValorCampo());
						Constantes.enviaMensajeConsola("p LONG["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("DOUBLE")){
						p.setDouble(posicion, (Double) obj.getValorCampo());
						Constantes.enviaMensajeConsola("p DOUBLE["+posicion+"]--->"+obj.getValorCampo().toString());
					}else if(obj.getTipoDato().toUpperCase().contains("BIGDECIMAL")){
						p.setBigDecimal(posicion, (BigDecimal) obj.getValorCampo());
						Constantes.enviaMensajeConsola("p BIGDECIMAL["+posicion+"]--->"+obj.getValorCampo().toString());
					}
					posicion++;
				} //if(obj.getValorCampo()!=null){
					
			}	//for(ObjPrepareStatement obj: arregloCampos){
			Constantes.enviaMensajeConsola("---termino asignacion tipos----");
			registroInsertado = p.executeUpdate();
			Constantes.enviaMensajeConsola("-------EJECUTO UPDATE ---------------");

			
		if(registroInsertado==1){
			modifico=true;
		}
		
		
		return modifico;
		
	}


	//********************************************************************************************************
	
	public boolean queryDelete(String Tabla, ArrayList<ObjPrepareStatement> arregloCampos, String Condicion) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryDelete---------------");
		boolean modifico = false;
		StringBuffer query=new StringBuffer();
		String unionCampos = " ";
		
		query.append("DELETE FROM ");
		query.append(Tabla);
		query.append(" WHERE ");
		
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=");
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")
						|| obj.getTipoDato().toUpperCase().contains("NULL")){
					query.append(obj.getValorCampo().toString());
				}else{
					query.append("? ");
				}
				unionCampos=", ";
			}else{//if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=null");
			}
		}
		
		Constantes.enviaMensajeConsola("queryCompleto, DELETE--->"+query.toString());
		
		this.pstmt = this.createConnection().prepareStatement(query.toString());
		int registroInsertado = -1;
		try{
			Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCampos.size());
			asignarTiposPSTMT(arregloCampos,1);
			Constantes.enviaMensajeConsola("---termino asignacion tipos----");
			registroInsertado = this.pstmt.executeUpdate();
			Constantes.enviaMensajeConsola("-------EJECUTO DELETE ---------------");
		}finally{
			if(this.pstmt!=null){
				this.pstmt.close();
				this.pstmt=null;
			}
			if(this.conn!=null){
				this.conn.close();
				this.conn=null;
			}
				
		}
		if(registroInsertado==1){
			modifico=true;
		}
		
		
		return modifico;
		
	}
	
	private int asignarTiposPSTMT(ArrayList<ObjPrepareStatement> arregloCampos, int posInicial) throws SQLException, ParseException{
		int posicion = posInicial;
		for(ObjPrepareStatement obj: arregloCampos){
			/////************* SE ASIGNA TIPO DE DATO SEGUN CAMPO DE LA TABLA, Se deber�n agregar los tipos de dato faltantes***********
			if(obj.getValorCampo()!=null){
				if(obj.getTipoDato().toUpperCase().contains("STRING")){
					this.pstmt.setString(posicion, (String) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt String["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("INT")){
					this.pstmt.setInt(posicion, (Integer) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt INT["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("SECUENCIA")){
					//this.pstmt.setInt(posicion, 0);
					Constantes.enviaMensajeConsola("pstmt SECUENCIA["+posicion+"]--->"+obj.getValorCampo().toString());
					Constantes.enviaMensajeConsola("----- NO SETEA TIPO A PSTMT -----");
					posicion--;
					
				}else if(obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
					
					//this.pstmt.setDate(posicion, (java.sql.Date) obj.getValorCampo() );
					Constantes.enviaMensajeConsola("pstmt CURRENT_DATE["+posicion+"]--->"+obj.getValorCampo().toString());
					posicion--;
					
				}else if(obj.getTipoDato().toUpperCase().contains("NULL")){
					
					//this.pstmt.setDate(posicion, (java.sql.Date) obj.getValorCampo() );
					Constantes.enviaMensajeConsola("pstmt NULL["+posicion+"]--->"+obj.getValorCampo().toString());
					posicion--;
					
				}else if(obj.getTipoDato().toUpperCase().contains("DATE")){
					java.sql.Date sqlFecha = null;
					if(!(obj.getValorCampo() instanceof Date)){
						SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date fechaPrueba = formatoFecha.parse(obj.getValorCampo().toString());
						sqlFecha = new java.sql.Date(fechaPrueba.getTime());
					}
					else{
						 SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
						 String fecha = formateador.format(obj.getValorCampo());
						 SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
						 java.util.Date fechaPrueba = formatoFecha.parse(fecha);
						 sqlFecha = new java.sql.Date(fechaPrueba.getTime());
					}
					
					this.pstmt.setDate(posicion, sqlFecha);
					Constantes.enviaMensajeConsola("pstmt DATE["+posicion+"]--->"+obj.getValorCampo().toString());
					
				}else if(obj.getTipoDato().toUpperCase().contains("BLOB")){
					byte[] archivo = (byte[]) obj.getValorCampo();
					ByteArrayInputStream input = new ByteArrayInputStream(archivo);
					this.pstmt.setBlob(posicion, input );
					Constantes.enviaMensajeConsola("pstmt BLOB["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("LONG")){
					this.pstmt.setLong(posicion, (Long) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt LONG["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("DOUBLE")){
					this.pstmt.setDouble(posicion, (Double) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt DOUBLE["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("BIGDECIMAL")){
					this.pstmt.setBigDecimal(posicion, (BigDecimal) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt BIGDECIMAL["+posicion+"]--->"+obj.getValorCampo().toString());
				}
				posicion++;
			} //if(obj.getValorCampo()!=null){
				
		}	//for(ObjPrepareStatement obj: arregloCampos){
		return posicion;
	}
	
	private int asignarTiposPSTMT(ArrayList<ObjPrepareStatement> arregloCampos, int posInicial, PreparedStatement pstmt) throws SQLException, ParseException{
		int posicion = posInicial;
		for(ObjPrepareStatement obj: arregloCampos){
			/////************* SE ASIGNA TIPO DE DATO SEGUN CAMPO DE LA TABLA, Se deber�n agregar los tipos de dato faltantes***********
			if(obj.getValorCampo()!=null){
				if(obj.getTipoDato().toUpperCase().contains("STRING")){
					pstmt.setString(posicion, (String) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt String["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("INT")){
					pstmt.setInt(posicion, (Integer) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt INT["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("SECUENCIA")){
					//this.pstmt.setInt(posicion, 0);
					Constantes.enviaMensajeConsola("pstmt SECUENCIA["+posicion+"]--->"+obj.getValorCampo().toString());
					Constantes.enviaMensajeConsola("----- NO SETEA TIPO A PSTMT -----");
					posicion--;
					
				}else if(obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")){
					
					//this.pstmt.setDate(posicion, (java.sql.Date) obj.getValorCampo() );
					Constantes.enviaMensajeConsola("pstmt CURRENT_DATE["+posicion+"]--->"+obj.getValorCampo().toString());
					posicion--;
					
				}else if(obj.getTipoDato().toUpperCase().contains("NULL")){
					
					//this.pstmt.setDate(posicion, (java.sql.Date) obj.getValorCampo() );
					Constantes.enviaMensajeConsola("pstmt NULL["+posicion+"]--->"+obj.getValorCampo().toString());
					posicion--;
					
				}else if(obj.getTipoDato().toUpperCase().contains("DATE")){
					java.sql.Date sqlFecha = null;
					if(!(obj.getValorCampo() instanceof Date)){
						SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date fechaPrueba = formatoFecha.parse(obj.getValorCampo().toString());
						sqlFecha = new java.sql.Date(fechaPrueba.getTime());
					}
					else{
						 SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
						 String fecha = formateador.format(obj.getValorCampo());
						 SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
						 java.util.Date fechaPrueba = formatoFecha.parse(fecha);
						 sqlFecha = new java.sql.Date(fechaPrueba.getTime());
					}
					
					pstmt.setDate(posicion, sqlFecha);
					Constantes.enviaMensajeConsola("pstmt DATE["+posicion+"]--->"+obj.getValorCampo().toString());
					
				}else if(obj.getTipoDato().toUpperCase().contains("BLOB")){
					byte[] archivo = (byte[]) obj.getValorCampo();
					ByteArrayInputStream input = new ByteArrayInputStream(archivo);
					pstmt.setBlob(posicion, input );
					Constantes.enviaMensajeConsola("pstmt BLOB["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("LONG")){
					pstmt.setLong(posicion, (Long) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt LONG["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("DOUBLE")){
					pstmt.setDouble(posicion, (Double) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt DOUBLE["+posicion+"]--->"+obj.getValorCampo().toString());
				}else if(obj.getTipoDato().toUpperCase().contains("BIGDECIMAL")){
					pstmt.setBigDecimal(posicion, (BigDecimal) obj.getValorCampo());
					Constantes.enviaMensajeConsola("pstmt BIGDECIMAL["+posicion+"]--->"+obj.getValorCampo().toString());
				}
				posicion++;
			} //if(obj.getValorCampo()!=null){
				
		}	//for(ObjPrepareStatement obj: arregloCampos){
		return posicion;
	}

	
	public int queryUpdate( Connection c, PreparedStatement p, String Tabla, ArrayList<ObjPrepareStatement> arregloCamposModif, ArrayList<ObjPrepareStatement> arregloCamposWhere) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryUpdate---------------");
		StringBuffer query=new StringBuffer();
		String unionCampos = " ";
		
		query.append("UPDATE ");
		query.append(Tabla);
		query.append(" SET ");
		
		
		for(ObjPrepareStatement obj: arregloCamposModif){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=");
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")
						|| obj.getTipoDato().toUpperCase().contains("NULL")){
					query.append(obj.getValorCampo().toString());
				}else{
					query.append("? ");
				}
				unionCampos=", ";
			}else{//if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=null");
			}
		}
		
		if(arregloCamposWhere!=null && arregloCamposWhere.size()>0){
			unionCampos = " WHERE ";
		}
		
		for(ObjPrepareStatement obj: arregloCamposWhere){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=");
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")
						|| obj.getTipoDato().toUpperCase().contains("NULL")){
					query.append(obj.getValorCampo().toString());
				}else{
					query.append("? ");
				}
				unionCampos=" AND ";
			}else{//if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=null");
			}
		}
		
		
		Constantes.enviaMensajeConsola("queryCompleto--->"+query.toString());
		
		p = c.prepareStatement(query.toString());
		int registroInsertado = -1;

			Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCamposModif.size());
			int posFinal = asignarTiposPSTMT(arregloCamposModif, 1,p);
			Constantes.enviaMensajeConsola("---termino asignacion tipos update, posFinal---->"+posFinal);
			Constantes.enviaMensajeConsola("---tama�o arreglo where --"+arregloCamposWhere.size());
			posFinal = asignarTiposPSTMT(arregloCamposWhere, posFinal,p);
			Constantes.enviaMensajeConsola("---termino asignacion tipos update----"+posFinal);
			registroInsertado = p.executeUpdate();
			Constantes.enviaMensajeConsola("-------EJECUTO UPDATE ---------------");
			
		return registroInsertado;
		
	}
	
	public int queryDelete( Connection c, PreparedStatement p, String Tabla, ArrayList<ObjPrepareStatement> arregloCampos) throws Exception {
		Constantes.enviaMensajeConsola("------ENTRA A  queryDelete---------------");
		StringBuffer query=new StringBuffer();
		String unionCampos = " ";
		
		query.append("DELETE FROM ");
		query.append(Tabla);
		query.append(" WHERE ");
		
		
		for(ObjPrepareStatement obj: arregloCampos){
			if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=");
				if(obj.getTipoDato().toUpperCase().contains("SECUENCIA") || obj.getTipoDato().toUpperCase().contains("CURRENT_DATE")
						|| obj.getTipoDato().toUpperCase().contains("NULL")){
					query.append(obj.getValorCampo().toString());
				}else{
					query.append("? ");
				}
				unionCampos=", ";
			}else{//if(obj.getValorCampo()!=null){
				query.append(unionCampos);
				query.append(obj.getCampoTabla());
				query.append("=null");
			}
		}
		
		Constantes.enviaMensajeConsola("queryCompleto, DELETE--->"+query.toString());
		
		p = c.prepareStatement(query.toString());
		int registroInsertado = -1;
		
			Constantes.enviaMensajeConsola("---tama�o arreglo--"+arregloCampos.size());
			asignarTiposPSTMT(arregloCampos,1,p);
			Constantes.enviaMensajeConsola("---termino asignacion tipos----");
			registroInsertado = p.executeUpdate();
			Constantes.enviaMensajeConsola("-------EJECUTO DELETE ---------------");

		return registroInsertado;
		
	}
	
	public boolean modificar(final String sql){
		boolean respuesta = true;
		try {
			createStatement();
			st.executeUpdate(sql);
		}
		catch(SQLException e){
			respuesta = false;
			System.out.println(e);
		} catch (Exception e) {
			respuesta = false;
			System.out.println(e);
		}
		finally {
			try {
				closeConnection();
				closeStatement();
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return respuesta;
	}
}

