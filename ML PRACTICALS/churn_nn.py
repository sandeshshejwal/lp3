# First let's start with calling all the dependencies for this project 
import numpy as np 
import pandas as pd
import math
import matplotlib.pyplot as plt
%matplotlib inline 
import seaborn as sns 

df = pd.read_csv('G:/dypiemr2/dypiemr22-23/sem_I/BE_I/databse/Churn_Modelling.csv')
df.head()

df.shape

df.drop(['RowNumber','Surname'], axis = 'columns', inplace =True)

df.isna().sum()

df.dtypes

 df['Geography'].unique()
 
 df['Gender'].unique()
 
 df['Gender'].replace(['Male', 'Female'],[1, 0], inplace= True)

#one hot encoding
df = pd.get_dummies(data = df, columns=['Geography'])
df.dtypes

df['Exited'].value_counts()

def visualization(x, y, xlabel):
    plt.figure(figsize=(10,5))
    plt.hist([x, y], color=['red', 'green'], label = ['exit', 'not_exit'])
    plt.xlabel(xlabel,fontsize=20)
    plt.ylabel("No. of customers", fontsize=20)
    plt.legend()
    
#get in to temp fframe
df_exited = df[df['Exited']==1]['Tenure']
df_not_exited = df[df['Exited']==0]['Tenure']

visualization(df_exited, df_not_exited, "Tenure")

df_exited1 = df[df['Exited']==1]['Age']
df_not_exited1= df[df['Exited']==0]['Age']

visualization(df_exited1, df_not_exited1, "Tenure")

# normalization
cols_to_scale = ['CustomerId','CreditScore', 'Age','Tenure', 'Balance', 'NumOfProducts', 'EstimatedSalary']

from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
df[cols_to_scale] = scaler.fit_transform([cols_to_scale])

#separate outcome or target col
X = df.drop(['Exited'], axis=1)
y = df['Exited']

from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score

X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.2,random_state=0)

from sklearn.preprocessing import StandardScaler

# feature scaling

scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)

import tensorflow as tf
from tensorflow import keras

