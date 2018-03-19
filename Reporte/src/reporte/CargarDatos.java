package reporte;
import java.io.FileReader;
import java.io.BufferedReader;
public class CargarDatos {
    public void leer(String nombre){
        try{
            FileReader file = new FileReader(nombre);
            BufferedReader bf = new BufferedReader(file);
            String tmp="";
            
            while(tmp != null){
                tmp=bf.readLine();
                String []arreglo=tmp.split("-");
                for(int i=0;i<arreglo.length;i++){
                    System.out.println(arreglo[i]);
                }
            }
            
        }catch(Exception e){
        }
        
        
    }
    
}
