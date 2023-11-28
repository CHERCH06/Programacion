package arbolbinario;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* @author VGSG */
public class ArbolBinario extends Nodo{
    ArrayList<Object> data = new ArrayList<>();
    Nodo raiz;
    
    public ArbolBinario(float value_r) {
        super(value_r);
        raiz = new Nodo(value_r);        
    }
    
    public void insertar(float value){
        insertarRecursivo(raiz,value);
    }

    public void insertarRecursivo(Nodo nodo,float value) {
        if(value<nodo.value){
            if(nodo.left == null){
                nodo.left = new Nodo(value);
            }else{
                insertarRecursivo(nodo.left,value);
            }
            if(nodo.right == null){       
                nodo.right = new Nodo(value);
            }else{
                insertarRecursivo(nodo.right,value);
            }
        }
    }
    
    public ArrayList<Object> inOrder(){
        data = new ArrayList<>();
        inOrderRecursivo(raiz);
        return data;
    }

    public void inOrderRecursivo(Nodo nodo) {
        if(nodo != null){
            inOrderRecursivo(nodo.left);
            data.add(nodo.value);
            inOrderRecursivo(nodo.right);
        }    
    }
    
    public ArrayList<Object> preOrder(){
        data = new ArrayList<>();
        preOrderRecursivo(raiz);
        return data;
    }

    
    private void preOrderRecursivo(Nodo nodo) {
        if(nodo != null){
            data.add(nodo.value);
            preOrderRecursivo(nodo.left);
            preOrderRecursivo(nodo.right);
        }     
    }
    
    public ArrayList<Object> postOrder(){
        data = new ArrayList<>();
        postOrderRecursivo(raiz);
        return data;
    }

    private void postOrderRecursivo(Nodo nodo) {   
        if(nodo != null){
            postOrderRecursivo(nodo.left);
             postOrderRecursivo(nodo.right);
             data.add(nodo.value);
        }                
    }
    
    public String busqueda(float value){
        return busquedaRecursivo(raiz,value);
    }

    private String busquedaRecursivo(Nodo nodo, float value) {
        if(nodo != null){
            return "No encontrado";
        }     
        if(nodo.value==value){
            return "Encontrado";
        }   
        if(value<nodo.value){
            return busquedaRecursivo(nodo.left,value);
        }else{
            return busquedaRecursivo(nodo.right,value);
        }
    }
    
    public String generaJSON(){
        String text = "";
        try {
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(data);
            text = jsonArray.toString();
        }catch(JSONException e) {
            e.printStackTrace();
        }
        return text;
    }
}
