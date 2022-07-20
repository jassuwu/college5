
"""

@author : 20PW14 

"""
import pandas as pd
import matplotlib.pyplot as plt
irisData = pd.read_csv("iris.csv")

for column in irisData.columns[:-1]:
    print( column, ":\n")

    irisData.boxplot(column=column, by='class')
        
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



# Five-number summary
iris_setosa = irisData.loc[irisData["class"] == "Iris-setosa"]
iris_versicolor = irisData.loc[irisData["class"] == "Iris-versicolor"]
iris_virginica = irisData.loc[irisData["class"] == "Iris-virginica"]
datalist = [iris_setosa,iris_versicolor,iris_virginica]
for data in datalist:
    print("#########",data.iloc[0]['class'],"#########")
    for col in irisData:
        if col!= 'class':
            print(col)
            Data = irisData[col]      
            print("Min: ",Data.min())
            print("max: ",Data.max())
            print("Q1: ",Data.quantile(0.25))
            print("Q2: ",Data.quantile(0.5))
            print("Q3: ",Data.quantile(0.75))
    print("\n#######################################################\n")


#to show the plot in the first loop "irisData.boxplot(column=column, by='class')"
plt.show()

