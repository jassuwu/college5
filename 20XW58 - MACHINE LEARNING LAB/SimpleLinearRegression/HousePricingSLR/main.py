import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

def SimpleLinearRegression(indep, dep):
    y = np.array(dep)
    x = [ 1 for x in indep]
    ogX = np.array(indep)
    for i in indep:
        x.append(i)
    x = np.array(x)
    plt.scatter(ogX,y)
    plt.title(indep.name)
    # plt.show()
    x = x.reshape(len(ogX), 2, order = 'F')
    
    xt = x.transpose()
    xtx = np.dot(xt,x)
    xty = np.dot(xt,y)
    xtxInverse = np.linalg.inv(xtx)
    B = np.dot(xtxInverse, xty)
    print(f"b0 = {B[0]}, b1 = {B[1]}")
    
    # Plot the estimator
    estimatorFn = B[1]*ogX + B[0]
    plt.plot(ogX,estimatorFn)
    plt.show()    
    
    yDash = estimatorFn.mean()

    #SSE, SST, and SSR.
    SSE = 0
    SST = 0
    SSR = 0
    SumOfErr = 0

    for i in range(len(ogX)):
        SSE += (y[i] - (B[1]*ogX[i] + B[0])) ** 2
        SST += (y[i] - yDash) ** 2
        SSR += ((B[1]*ogX[i] + B[0]) - yDash) ** 2
        SumOfErr += y[i] - (B[1]*ogX[i] + B[0])
           
    print(f"\nSum of errors = {SumOfErr}, \nSSE = {SSE}, \nSST = {SST}, \nSSR = {SSR}")

    print(f"SSE + SSR = {SSE+SSR} == {SST} = SST") #Not actually ==, but almost.
    
    return SSE


data = pd.read_csv("data.csv")

SSEDict = {}

for i in data.columns:
    print("###########################################################################")
    print(i)
    if i != 'price' and str(data[i][0]).replace(".", "", 1).isdigit(): 
        SSEDict[i] = SimpleLinearRegression(data[i], data['price']);
    else: 
        print("ERR : THEY NOT DIGITS.")
    print("###########################################################################")

print("###########################################################################")
print("Most error-free feature found : ", min(SSEDict, key = lambda k: SSEDict[k]))
print("###########################################################################")