
"""

@author : 20PW14 

"""
import pandas as pd

irisData = pd.read_csv("iris.csv")

for column in irisData.columns[:-2]:
    print( column, ":\n")
    mean_data = irisData[column].mean()
    median_data = irisData[column].median()
    mode_data = irisData[column].mode()
    std_data = irisData[column].std()
    skew_data = irisData[column].skew()
    kurt_data = irisData[column].kurt()
    print("Mean:", mean_data, "\nMedian:",median_data, "\nMode:", mode_data[0], "\nStandard Deviation:", std_data, "\nSkewness:", skew_data, "\nKurtosis:", kurt_data,"\n" )
    print("\n#######################################################\n")

print("\n\nCovariance: \n", irisData.cov())
print("\n#######################################################\n")
print("\n\nCoefficient of Correlation : \n", irisData.corr(method='pearson'))
print("\n#######################################################\n")