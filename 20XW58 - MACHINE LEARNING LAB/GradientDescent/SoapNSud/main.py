import matplotlib.pyplot as plt
import numpy as np
xy = [(4,33), (4.5, 42), (5, 45), (5.5,51), (6, 53), (6.5, 61), (7, 62)]

ogX = np.array([4, 4.5, 5, 5.5, 6, 6.5, 7])


eta = 0.0088315
Bold = [0, 0]
Bnew = [0, 0]

iterations=0
while True:
    grad = [0, 0]
    for xi,yi in xy:
        grad[0] += (yi - Bold[0] -Bold[1]*xi)
        grad[1] += (yi - Bold[0] -Bold[1]*xi)*xi
        
    
    Bnew[0] = Bold[0] + eta*grad[0]
    Bnew[1] = Bold[1] + eta*grad[1]
    
    
    iterations+=1
    if Bold==Bnew:
        break
    
    Bold[0] = Bnew[0]
    Bold[1] = Bnew[1]

# Plot the estimator
estimatorFn = Bold[1]*ogX + Bold[0]
plt.plot(ogX,estimatorFn)
# print(iterations)
plt.ylim((30, 70))    
plt.show()
print(f"Bold in {iterations}th iteration : {Bold}")