import numpy as np
import matplotlib.pyplot as plt

def graficar_recta(pendiente, punto, a, b):
    x = np.linspace(min(a) - 300, max(a) + 300, 100)  
    y = pendiente * (x - punto[0]) + punto[1]

   
    plt.plot(x, y, label=f'Recta: y = {pendiente}(x - {punto[0]}) + {punto[1]}')
    
    
    plt.scatter(punto[0], punto[1], color='red', label='Punto en la recta')
    j=0
    while(j<len(a)):
         plt.scatter(a[j], b[j], color='yellow', label='dato real')
         j+=1
    
    plt.axhline(0, color='black',linewidth=0.5)
    plt.axvline(0, color='black',linewidth=0.5)
    plt.grid(color = 'gray', linestyle = '--', linewidth = 0.5)
    plt.title('regresión lineal')
    plt.xlabel('x')
    plt.ylabel('y')
   
    
  
    plt.show()

def sumatoria(arreglo):
    suma=0
    for elemento in arreglo:
        suma+=elemento
    return suma

x=[102,110,125,128,180,205,215]
y=[0.9,1.4,1.2,1.6,2.2,2.4,3]
xy=[]
x2=[]
i=0

while i<len(x):
    xy.append(x[i]*y[i])
    x2.append(x[i]*x[i])
    i+=1

sx=sumatoria(x)
sy=sumatoria(y)
sxy=sumatoria(xy)
sx2=sumatoria(x2)
print(sx,sy,sxy,sx2)
m=(sxy-((sx)*(sy))/len(x))/((sx2)-((sx*sx)/len(x)))
print(m)
b=(sy/len(x))-m*(sx/len(x))
print(b)

graficar_recta(pendiente=m,punto=(0,b), a=x, b=y)