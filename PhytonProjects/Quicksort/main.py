import os
def quicksort(arr):
    if len(arr)<=1:
        return(arr)
    else:
        menor=[]
        mayor=[]
        pivot=arr[0]
        for n in arr[1:]:
            if n<=pivot:
                menor.append(n)
        for n in arr[1:]:
            if n>pivot:
                mayor.append(n)
        return quicksort(menor)+[pivot]+quicksort(mayor)
    
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

rutaTxt = 'C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\Quicksort\\h.txt'
rutaSalida = 'C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\Quicksort\\resultado.txt'
print(generaArchivo(quicksort(HexADeci(abrirTxt(rutaTxt))),rutaSalida))


