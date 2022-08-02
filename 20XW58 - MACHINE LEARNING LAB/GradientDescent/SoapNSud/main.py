import matplotlib.pyplot as plt
import numpy as np

# X = np.array([4, 4.5, 5, 5.5, 6, 6.5, 7])
# y = np.array([33, 42, 45, 51, 53, 61, 62])


xySet = np.array([(4,33), (4.5,42), (5,45), (5.5, 51), (6,53), (6.5, 61), (7, 62)])



η = 0.1
Bold = [0,0]
Bnew = [0,0]
print(f"b0 = {B[0]}, b1 = {B[1]}")


while True:
    gradSSE = [0,0]
    for (xi,yi) in xySet:
        gradSSE[0] += B[0] - B[1]*xi
        gradSSE[1] += (B[0] - B[1]*xi)*xi

    Bnew[0] = Bold[0] - η*gradSSE[0]
    Bnew[1] = Bold[1] - η*gradSSE[1]    


# Plot the estimator
# estimatorFn = B[1]*ogX + B[0]
# plt.plot(ogX, estimatorFn)
# plt.show()      


# yDash = estimatorFn.mean()

# #SSE, SST, and SSR.
# SSE = 0
# SST = 0
# SSR = 0 
# SumOfErr = 0

# for i in range(len(ogX)):
#     SSE += (y[i] - (B[1]*ogX[i] + B[0])) ** 2
#     SST += (y[i] - yDash) ** 2
#     SSR += ((B[1]*ogX[i] + B[0]) - yDash) ** 2
#     SumOfErr += y[i] - (B[1]*ogX[i] + B[0])
# print(f"\nSum of errors = {SumOfErr}, \nSSE = {SSE}, \nSST = {SST}, \nSSR = {SSR}")

# print(f"SSE + SSR = {SSE+SSR} == {SST} = SST")