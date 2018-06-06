package crossingjdbctrue;
import dao.CrossingDao;
import java.util.ArrayList;
import java.util.List;
import obj.User;
import obj.Character;
import obj.Item;

public class CrossingJDBCTrue {
    public static void main(String[] args) {
        CrossingDao crossingDao = new CrossingDao();
        List<User> users = new ArrayList<>();
     
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
            
            /* ejemplo de error
            User errorValidacion = new User("error", "error");
            if (crossingDao.validacionUser(errorValidacion) == true) {
            System.out.println("Se ha validado correctamente el usuario(" + errorValidacion.getUsername() + ") ");
            System.out.println("--------------------------------------");
            } else {
            System.out.println("ERROR: El username o password estan mal");
            System.out.println("--------------------------------------");
            };*/
            
            
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
        
        //(7)
         
        
        //(8)
          
        
        //(9)
         
        
        //(10)
            
        
        //(11)
           
        
        //(12)
          
        
        //(13)
          
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
