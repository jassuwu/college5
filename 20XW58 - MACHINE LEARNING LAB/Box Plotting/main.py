
"""

@author : 20PW14 

"""
import numpy as np 
import pandas as pd 
import matplotlib.pyplot as plt 
 
data = pd.read_csv("20pwclassheights.csv") 
 
heightsData = data[["Heights"]]
plt.figure(figsize = (10,7))
heightsData.boxplot()
plt.ylim(150,195)
print(
heightsData.min(), 
heightsData.max(),
heightsData.quantile(0.25),
heightsData.quantile(0.5),
heightsData.quantile(0.75),
heightsData.quantile(0.25) - 1.5*(heightsData.quantile(0.75) - heightsData.quantile(0.25)),
heightsData.quantile(0.75) + 1.5*(heightsData.quantile(0.75) - heightsData.quantile(0.25)),

)
