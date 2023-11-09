import random
import json

class Nodo:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None

class ArbolBinario: 
    data=[]
    def __init__(self,value_r):
        self.raiz=Nodo(value_r)

    def insertar(self,value):
        self.insertarRecursivo(self.raiz,value)
    
    def insertarRecursivo(self,nodo,value):
        if value<nodo.value:
            if nodo.left is None:
                nodo.left=Nodo(value)
            else:
                self.insertarRecursivo(nodo.left,value)
            if nodo.right is None:       
                nodo.right=Nodo(value)
            else:
                self.insertarRecursivo(nodo.right,value) 

    def inorder(self):
        self.data=[]
        self.inorderRecursivo(self.raiz)
        return self.data
    
    def inorderRecursivo(self,nodo):
        if nodo is not None:
            self.inorderRecursivo(nodo.left)
            self.data.append(nodo.value)
            self.inorderRecursivo(nodo.right)
    
    def preorder(self):
        self.data=[]
        self.preorderRecursivo(self.raiz)
        return self.data
    
    def preorderRecursivo(self,nodo):
        if nodo is not None:
             self.data.append(nodo.value)
             self.preorderRecursivo(nodo.left)
             self.preorderRecursivo(nodo.right)
    
    def postorder(self):
        self.data=[]
        self.postorderRecursivo(self.raiz)
        return self.data
    
    def postorderRecursivo(self,nodo):
        if nodo is not None:
             self.postorderRecursivo(nodo.left)
             self.postorderRecursivo(nodo.right)
             self.data.append(nodo.value)
    
    def buisqueda(self,value):
        return self.busquedaRecursivo(self.raiz,value)
    
    def busquedaRecursivo(self,nodo,value):
        if nodo is None: 
            return False
        if nodo.value==value:
            return True
        if value<nodo.value:
            return self.busquedaRecursivo(nodo.left,value)
        else:
            return self.busquedaRecursivo(nodo.right,value)

    def generaJson(self):
        self.tree_dict=self.json(self.raiz)
        return json.dumps(self.tree_dict)

    def json(self,nodo):
        if nodo is None:
            return None
        else:
            nodo_d={"valor" : nodo.value,
                "left":self.json(nodo.left),
                "right":self.json(nodo.right)}
            return nodo_d
        
ab = ArbolBinario(200000)

for i in range(10000):
    num = round(random.uniform(1,400000),2)
    ab.insertar(num)

print("\nRecorrido Inorder: ",ab.inorder())
print("Reccorrido Preorder: ",ab.preorder())
print("\nRecorrido Postorder: ",ab.postorder())

print(ab.buisqueda(random.uniform(1,400000)))
#print(ab.generaJson())