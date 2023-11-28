from heapq import heappop, heappush  
import os
   
def heapsort(list1):  
    heap = []  
    for ele in list1:  
        heappush(heap, ele)   
    sort = []  
    while heap:  
        sort.append(heappop(heap))  
    return sort  
   
def HexADeci(array):
    arrayDecimal = []
    for line in array:
        valorDeci = int(line, 16)
        arrayDecimal.append(valorDeci)
    return arrayDecimal

def abrirTxt(rute):
    textAux = ""
    with open(rute,'r') as archivo:
        for linea in archivo:
            textAux += linea
    aux = 0
    listaAux = []
    while aux < len(textAux):
        if aux + 8 <= len(textAux):
            listaAux.append(textAux[aux:aux+8])
        aux += 8
    return listaAux

def generaArchivo(array,ruta):
    if os.path.exists(ruta):
        os.remove(ruta)
    with open(ruta,'a') as archivo:
        for line in array:
            archivo.write(str(line)+",")
    return array

rutaTxt = 'C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\HeapSort\\h.txt'
rutaSalida = 'C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\HeapSort\\resultado.txt'
print(generaArchivo(heapsort(HexADeci(abrirTxt(rutaTxt))),rutaSalida))