package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import obj.User;
import obj.Character;
import obj.Item;
import obj.Contact;
import obj.Inventory;
import Exception.crossingException;

public class CrossingDao {

    private Connection conexion;

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stucomcrossing";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public boolean insertarUser(User u) throws SQLException {
        boolean inDB = checkUser(u.getUsername());
        boolean correcto = false;
        if(inDB == true){

        }else{
            String insert = "insert into user values(?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, 100);
            ps.setInt(4, 0);
            ps.setString(5, u.getPlace());
            ps.setInt(6, 0);
            ps.executeUpdate();
            ps.close();
            correcto = true;
        }
        
        return correcto;
    }
    
    public boolean checkUser(String username) throws SQLException {
        boolean check = false;
        String select = "select * from user where username='" + username + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            check = true;
        }
        rs.close();
        st.close();
        
        return check;
    }
    
    public User getUserFromUsername(String username) throws crossingException, SQLException{
        User userReturnee = new User();
        
        if(checkUser(username)== false){
            throw new crossingException("No existe ningun usuario con este username("+username+")"); 
        }else{
            String select = "select * from user where username='" + username + "'";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(select);
            if (rs.next()) {
                userReturnee.setUsername(rs.getString("username"));
                userReturnee.setPassword(rs.getString("password"));
                userReturnee.setLevel(rs.getInt("level"));
                userReturnee.setPoints(rs.getInt("points"));
                userReturnee.setStucoins(rs.getInt("stucoins"));
                userReturnee.setPlace(rs.getString("place"));        
            }
            rs.close();
            st.close();
            
        } 
        return userReturnee;
    }
    
    public boolean insertarCharacter(Character c) throws crossingException,SQLException{
        boolean inDB = checkCharacter(c.getName());
        boolean correcto = false;
        
        if(inDB == true){
            throw new crossingException("El personaje("+ c.getName() +") ya existe en la base de datos"); 
        }else{
            String insert = "insert into stucomcrossing.character values(?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, c.getName());
            ps.setString(2, c.getStudy());
            ps.setString(3, c.getPlace());
            ps.setString(4, c.getPreference());
            ps.executeUpdate();
            ps.close();
            correcto = true;
        }
        return correcto;
    }
    
    public boolean checkCharacter(String name) throws SQLException {
        boolean check = false;
        String select = "select * from stucomcrossing.character where name='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            check = true;
        }else{}
        rs.close();
        st.close();
        
        return check;
    }
    
    public void insertarItem(Item i) throws crossingException,SQLException{
        boolean inDB = checkItem(i.getName());
        
        if(inDB == true){
            throw new crossingException("El item("+ i.getName() +") ya existe en la base de datos"); 
        }else{
            String insert = "insert into stucomcrossing.item values(?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, i.getName());
            ps.setDouble(2, i.getPrice());
            ps.setDouble(3, i.getSaleprice());
            ps.setString(4, i.getType());
            ps.setString(5, i.getStyle());
            ps.executeUpdate();
            ps.close();
        }
    }
    
    public boolean checkItem(String name) throws SQLException {
        boolean check = false;
        String select = "select * from stucomcrossing.item where name='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            check = true;
        }else{}
        rs.close();
        st.close();
        
        return check;
    }
    
        public Item getItemFromName(String name) throws crossingException, SQLException{
        Item itemReturnee = new Item();
        
        if(checkItem(name)== false){
            throw new crossingException("No existe ningun item con este nombre("+name+")"); 
        }else{
            String select = "select * from item where name='" + name + "'";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(select);
            if (rs.next()) {
                itemReturnee.setName(rs.getString("name"));
                itemReturnee.setPrice(rs.getDouble("price"));
                itemReturnee.setSaleprice(rs.getDouble("saleprice"));
                itemReturnee.setType(rs.getString("type"));   
                itemReturnee.setStyle(rs.getString("style"));   
            }
            rs.close();
            st.close();
            
        } 
        return itemReturnee;
    }
    
    public boolean validacionUser(User u) throws SQLException{
        boolean check = false;
        String select = "select * from stucomcrossing.user where username='" + u.getUsername() + "' and password='"+u.getPassword()+"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            check = true;
        }else{}
        rs.close();
        st.close();
        
        return check;
    }
    
    public boolean updateUsername(String old, String nuevo) throws crossingException,SQLException{
        boolean correcto=false;
        if(checkUser(old)==true){
            if(checkUser(nuevo)==false){
               String update = "update user set username=? where username=?";
                PreparedStatement ps = conexion.prepareStatement(update);
                ps.setString(1, nuevo);
                ps.setString(2, old);
                ps.executeUpdate();
                ps.close();
                correcto=true;
            }else{
                throw new crossingException("Ya existe un usuario con este username("+nuevo+")"); 
            }
        }else{
            throw new crossingException("No existe ningun usuario con este username("+old+")"); 
        }
        return correcto;
    }
    
    public boolean updateLugarUser(String user,String lugar) throws crossingException,SQLException{
        boolean correcto=false;
        if(checkUser(user)==true){
            String update = "update user set place=? where username=?";
            PreparedStatement ps = conexion.prepareStatement(update);
            ps.setString(1, lugar);
            ps.setString(2, user);
            ps.executeUpdate();
            ps.close();
            correcto=true;
        }else{
            throw new crossingException("No existe un usuario con este username("+user+")");
        }
        
        return correcto;
    }
    
    public boolean updateLugarCharacter(String character,String lugar) throws crossingException,SQLException{
        boolean correcto=false;
        if(checkCharacter(character)==true){
            String update = "update stucomcrossing.character set place=? where name=?";
            PreparedStatement ps = conexion.prepareStatement(update);
            ps.setString(1, lugar);
            ps.setString(2, character);
            ps.executeUpdate();
            ps.close();
            correcto=true;
        }else{
            throw new crossingException("No existe un personaje con este nombre("+character+")");
        }

        return correcto;
    }
    
    public boolean updatePrecioItem(Item item) throws crossingException,SQLException{
        boolean correcto=false;
        if(checkItem(item.getName())==true){
            String update = "update item set price=? where name=?";
            PreparedStatement ps = conexion.prepareStatement(update);
            ps.setDouble(1, item.getPrice());
            ps.setString(2, item.getName());
            ps.executeUpdate();
            ps.close();    
            correcto=true;
        }else{
            throw new crossingException("No existe el objeto con este nombre("+item.getName()+")");
        }        
        return correcto;
    }
    
    public ArrayList<Character> getAllCharactersFromUserPlace(User user) throws crossingException, SQLException {
        ArrayList<Character> charactesLugarUsuario = new ArrayList<>();
        boolean correcto = false;

        String select = "select * from stucomcrossing.character where place = '" + user.getPlace() + "';";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);

        while (rs.next()) {
            Character c = new Character();
            c.setName(rs.getString("name"));
            c.setPreference(rs.getString("preference"));
            c.setPlace(rs.getString("place"));
            c.setStudy(rs.getString("study"));
            charactesLugarUsuario.add(c);
        }
        return charactesLugarUsuario;
    }
    
    public boolean compraItem(User u, Item i) throws crossingException, SQLException{
        boolean correcto = false;
        User auxUser = new User();
        Item auxItem = new Item();
        int auxQuantity = 0;
            if(checkUser(u.getUsername())==true){
                auxUser=getUserFromUsername(u.getUsername());
                
                if(checkItem(i.getName())==true){
                    auxItem=getItemFromName(i.getName());
                    
                    if(auxUser.getStucoins()>auxItem.getPrice()){
                        restaMonedasCompra(auxUser,auxItem.getPrice());
                        
                        if(checkInventoryUserItem(auxUser, auxItem)==true){
                        auxQuantity = getQuantitiesUserItem(auxUser,auxItem)+1;
                        
                        String update = "update stucomcrossing.inventory set quantity=?";
                        PreparedStatement ps = conexion.prepareStatement(update);
                        ps.setInt(1, auxQuantity);
                        ps.executeUpdate();
                        ps.close();
                    }
                    else{
                        restaMonedasCompra(auxUser,auxItem.getPrice());
                            
                        String insert = "insert into stucomcrossing.inventory values(?,?,?)";
                        PreparedStatement ps = conexion.prepareStatement(insert);
                        ps.setString(1, auxUser.getUsername());
                        ps.setString(2, auxItem.getName());
                        ps.setInt(3, 1);
                        ps.executeUpdate();
                        ps.close();
                    }
                    
                    }else{
                        throw new crossingException("No el usuario no tiene suficientes stucoins");
                    }
  
                }else{
                    throw new crossingException("No existe el objeto con este nombre("+i.getName()+")");
                }    
            }else{
                throw new crossingException("No existe el usuario con este username("+u.getUsername()+")");
            }
            
        return correcto;
    }
    
    public boolean checkInventoryUserItem(User u,Item i) throws crossingException,SQLException{
        boolean correcto=false;
        String select = "select * from inventory where user='"+u.getUsername()+"' and item='"+i.getName()+"'  ;";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        
        if (rs.next()) {
            correcto = true;
        }
        rs.close();
        st.close();
        
        return correcto;
    }
    
    public int getQuantitiesUserItem(User u,Item i) throws crossingException,SQLException{
        Item auxItem = new Item();
        int quantity = 0;
        
        String select = "select * from inventory where user='" + u.getUsername() + "' and item='" + i.getName() + "' ";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        
        if (rs.next()) {
                quantity= rs.getInt("quantity");
        }else{
            throw new crossingException("No se ha encontrado objeto en inventario");
        }
        
        
        return quantity;
    }
    
    public boolean restaMonedasCompra(User u,double precio) throws crossingException,SQLException{
        boolean correcion = false;
        int auxStucoins = u.getStucoins();
        int auxPrecio =(int) Math.ceil(precio);
        
        int finStucoins = auxStucoins - auxPrecio;
        
        String update = "update user set stucoins=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, finStucoins);
        ps.executeUpdate();
        ps.close();
        
        
        return correcion;
    }
  
}
