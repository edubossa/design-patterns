package br.com.globalcode.facade;

import br.com.globalcode.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Esta classe deve ser utilizada para implementação do acesso ao banco de dados
 */
public class JDBCFacade {
    
    private final static JDBCFacade instance = new JDBCFacade();
    
    static List<Produto> produtos = new ArrayList<>();
    
    private JDBCFacade() { }
    
    public static JDBCFacade getInstance() {
        return instance;
    }
    
    //implementar este método
    public List<Produto> lerProdutos() {
        /*List<Produto> produtos = new ArrayList<Produto>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produtos order by 'id'");
            while(rs.next()) {
                produtos.add(new Produto(rs.getInt("id"),rs.getString("nome")
                ,rs.getDouble("preco"),rs.getString("marca")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    	
    	List<Produto> lista = new ArrayList<>();
    	
    	for (int i = 1; i <= 5; i++) {
    		lista.add(new Produto(i, UUID.randomUUID().toString(), new Random().nextDouble(), UUID.randomUUID().toString()));
		}
    	
    	produtos.addAll(lista);
    	
        return produtos;
    }
    
    //implementar este método
    public void salvarProduto(Produto produto) {
        /*try{
            
            Connection conn = getConnection();
            String sql;
            if(produto.getId()==0) {
                sql = "insert into produtos ( nome, preco, marca ) values ( ?, ?, ? )";
            } else {
                sql = "update produtos set nome = ?, preco = ?, marca = ? where id = ?";
            }
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,produto.getNome());
            st.setDouble(2,produto.getPreco());
            st.setString(3,produto.getMarca());
            if (produto.getId()!=0) {
                st.setInt(4,produto.getId());
            }
            st.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    	produto.setId(produtos.size() + 1);
    	produtos.add(produto);
    }
    
    private Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://academias:3306/aw","aw","aw");
        return conn;
    }
    
}
