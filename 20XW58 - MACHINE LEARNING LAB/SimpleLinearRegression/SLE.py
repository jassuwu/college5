import matplotlib.pyplot as plt
import numpy as np

x = np.array([1, 1, 1, 1, 1, 1, 1, 4, 4.5, 5, 5.5, 6, 6.5, 7])
ogX = np.array([4, 4.5, 5, 5.5, 6, 6.5, 7])
y = np.array([33, 42, 45, 51, 53, 61, 62])

plt.scatter(ogX,y)
#Col major order
x = x.reshape(7,2, order='F')


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

print(f"SSE + SSR = {SSE+SSR} == {SST} = SST")