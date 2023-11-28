package arbolbinario;
/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        ArbolBinario ab = new ArbolBinario(200000);

        for(int i=0;i<10000;i++){
            float num = (float)Math.random()*400000;
            ab.insertar(num);
        }

        System.out.println("\nRecorrido Inorder: "+ab.inOrder());
        System.out.println("Reccorrido Preorder: "+ab.preOrder());
        System.out.println("\nRecorrido Postorder: "+ab.postOrder());

        System.out.println(ab.busqueda((float)Math.random()*400000));
        System.out.println("\nJSON: "+ab.generaJSON());
    }  
}
