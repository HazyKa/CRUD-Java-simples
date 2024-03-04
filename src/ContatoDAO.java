package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public static void save(Contato contato){

        String sql = "INSERT INTO contatos(nome, idade) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
    
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
    
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,contato.getNome());
            pstm.setInt(2, contato.getIdade());

            pstm.execute();

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static List<Contato> getContatos() {
        String sql = "SELECT * FROM contatos";
    
        List<Contato> contatos = new ArrayList<Contato>();
    
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet result = null;
    
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
    
            result = pstm.executeQuery();
    
            while (result.next()) {
                Contato contato = new Contato();
    
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setIdade(result.getInt("idade"));
    
                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contatos;
    }
    
    public static void update(Contato contato){
        String sql = "UPDATE contatos SET nome = ?, idade = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setInt(3, contato.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if (conn!=null) {
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }

    public static void delete(int id){
        String sql = "DELETE FROM contatos WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        System.out.println("chegou");
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
