import time
semaforo = [["Rojo", 10], ["Rojo", 8], ["Rojo", 7]]

def imprimir_semaforos():
    print(semaforo[0][0]+" "+semaforo[1][0]+" "+semaforo[2][0])

def cambio_semaforo(semaforo):
    if semaforo<2:
        muestra_semaforo(semaforo+1)
    else:
        muestra_semaforo(0)



def muestra_semaforo(focus_semaforo):
    semaforo[focus_semaforo][0] = "Verde"
    imprimir_semaforos()
    time.sleep(semaforo[focus_semaforo][1])
    semaforo[focus_semaforo][0] = "Amarillo"
    imprimir_semaforos()
    time.sleep(1)
    semaforo[focus_semaforo][0] = "Rojo"
    cambio_semaforo(focus_semaforo)
        
print("Peatones | Vehículos | Bicicletas")
muestra_semaforo(0)