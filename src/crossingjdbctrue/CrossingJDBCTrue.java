package crossingjdbctrue;
import dao.CrossingDao;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import obj.User;
import obj.Character;
import obj.Item;

public class CrossingJDBCTrue {
    public static void main(String[] args) {
        CrossingDao crossingDao = new CrossingDao();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Character> charactesLugarUsuario = new ArrayList<>();
     
        //Conexion con base de datos
        try{
            System.out.println("Conectado con la base datos...");
            System.out.println("----------------------------------");
            crossingDao.conectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }
        
        //(1)Creacion de usuario y insercion con check de si existe en DB
        try{
            User kelvin= new User("kelvin", "123", 0, 0, "barcelona", 0);
            if(crossingDao.insertarUser(kelvin)==true){
                System.out.println("Se ha insertado el usuario("+kelvin.getUsername()+")");
                System.out.println("----------------------------------");
            }else{
                System.out.println("El usuario("+ kelvin.getUsername() +") ya existe en la base de datos");
                System.out.println("----------------------------------");
            };
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }
        
        //(2)Obtener un usuario a partir de un nombre de usuario
        try{    
            User test2 = crossingDao.getUserFromUsername("kelvin");
                System.out.println("Se ha encontrado al usuario("+test2.getUsername()+")"+test2);
                System.out.println("----------------------------------");
            
            /*Ejemplo de error
                User test3 = crossingDao.getUserFromUsername("alguien");//ejemplo con mensaje de error
                System.out.println("algo");
                */
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }  
        
        //(3)Creacion de character y insercion con check de si existe en DB
        try{
            Character reseti = new Character("reseti", "daw", "tunel", "pico");
            if(crossingDao.insertarCharacter(reseti)==true){
                System.out.println("Se ha insertado el personaje("+reseti.getName()+")");
                System.out.println("----------------------------------");
            }else{
                System.out.println("El personaje("+ reseti.getName()+") ya existe en la base de datos");
                System.out.println("----------------------------------");
            };
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }   
        
        //(4)Creacion de item y insercion con check e si existe en DB
        try{
            Item pico = new Item("pico", 5.00, 1.00, "herramienta", "programacion");
            crossingDao.insertarItem(pico);
            if(crossingDao.checkItem("pico")==true){
                System.out.println("El item(pico) se ha insertado");
                System.out.println("----------------------------------");
            
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        } 
        
        //(5)Validacion de usuario
        try{
            User validacion = new User("kelvin", "123");
            if(crossingDao.validacionUser(validacion)==true){
                System.out.println("Se ha validado correctamente el usuario("+validacion.getUsername()+") ");
                System.out.println("--------------------------------------");
            }else{
                System.out.println("ERROR: El username o password estan mal");
                System.out.println("--------------------------------------");
            };         
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }  
        
        //(6) Actualizacion de datos de usuario
        try{    
            if(crossingDao.updateUsername("kelvin","kelvinAlpha")==true){
                System.out.println("Actualizacion correcta de datos");
                System.out.println("----------------------------------");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }
        
        //(7) Actualizar el lugar del usuario
        try{    
            if(crossingDao.updateLugarUser("kelvinAlpha","home")==true){
                System.out.println("Actualizacion correcta de lugar de usuario");
                System.out.println("----------------------------------");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }
         
        
        //(8) Actualizar el lugar de un personaje
        try{    
            if(crossingDao.updateLugarCharacter("reseti","tunel")==true){
                System.out.println("Actualizacion correcta de lugar de personaje");
                System.out.println("----------------------------------");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        } 
        
        //(9) Actualizacion de precio de un item
        try{   
            Item newPico = new Item("pico", 6.00);
            
            if(crossingDao.updatePrecioItem(newPico)==true){
                System.out.println("Actualizacion correcta de precio de item");
                System.out.println("----------------------------------");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }         
        
        
        //(10)Obtener datos de personajes que estan en el mismo lugar que un usuario
        try{
            User kelvinAlpha = new User("kelvinAlpha", "123", 100, 0, "tunel", 0);
            charactesLugarUsuario=crossingDao.getAllCharactersFromUserPlace(kelvinAlpha);
            
            for (int i = 0; i < charactesLugarUsuario.size(); i++) {
			System.out.println(charactesLugarUsuario.get(i));
            }
            System.out.println("--------------------------------------");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }  
        
        //(11)Compra de un objeto
        try{
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }     
        
        //(12)Venta de un objeto
        try{
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }    
        
        /*        
        //(13)Dar un objeto a un personaje
        try{
        
        
        }catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("--------------------------------------");
        }  
        */
        
        //(14)
        try{
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }   
        
        
        //Desconectar de la base de datos
        try{    
            System.out.println("Desconectado de la base datos...");
            crossingDao.desconectar();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------");
        }
    }
}
