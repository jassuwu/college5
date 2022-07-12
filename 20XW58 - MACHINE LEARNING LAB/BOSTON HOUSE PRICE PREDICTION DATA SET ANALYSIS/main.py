# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 15:06:29 2022

@author: 20pw14
"""

import pandas as pd

housingData = pd.read_csv("bostonHousing.csv")

for column in housingData.columns[:-2]:
    print( column, ":\n")
    mean_data = housingData[column].mean()
    median_data = housingData[column].median()
    mode_data = housingData[column].mode()
    std_data = housingData[column].std()
    skew_data = housingData[column].skew()
    kurt_data = housingData[column].kurt()
    print("Mean:", mean_data, "\nMedian:",median_data, "\nMode:", mode_data[0], "\nStandard Deviation:", std_data, "\nSkewness:", skew_data, "\nKurtosis:", kurt_data,"\n" )
    print("\n#######################################################\n")
    
print("\n\nCovariance: \n", housingData.cov())
print("\n#######################################################\n")
print("\n\nCoefficient of Correlation : \n", housingData.corr(method='pearson'))
print("\n#######################################################\n")