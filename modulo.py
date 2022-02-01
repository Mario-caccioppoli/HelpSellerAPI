def install(package):
    # This is an evil little function
    # that installs packages via pip.
    # This means the script can install
    # it's own dependencies.
    try:
        __import__(package)
    except:
        import subprocess
        subprocess.call([sys.executable, "-m", "pip", "install", package])


def data():
    try:
        connection = mysql.connector.connect(host='localhost',
                                             database='helpseller',
                                             user='root',
                                             password='root')
        sql_select_Query = "select * from recensione"
        cursor = connection.cursor()
        cursor.execute(sql_select_Query)
        records = cursor.fetchall()
    except mysql.connector.Error as e:
        print("Errore nella connessione al DB", e)
    finally:
        if connection.is_connected():
            connection.close()
            cursor.close()
            with open('bigData.csv', 'w', newline='') as f_handle:
                writer = csv.writer(f_handle)
                header = ['id', 'testo', 'voto', 'data', 'idProdotto', 'idDistributore']
                writer.writerow(header)
                for row in records:
                    writer.writerow(row)


def l1():
    ratings = pd.read_csv('bigData.csv')
    popular_products = pd.DataFrame(ratings.groupby('idProdotto')['voto'].count())
    most_popular = popular_products.sort_values('voto', ascending=False)
    most_popular = most_popular.index.tolist()
    for el in most_popular:
        print(el)


def l2():
    ratings = pd.read_csv('bigData.csv')
    X = ratings.pivot_table(values='voto', index='idProdotto', columns='idDistributore', fill_value=0)
    SVD = TruncatedSVD(n_components=3)
    decomposed_matrix = SVD.fit_transform(X)
    correlation_matrix = np.corrcoef(decomposed_matrix)
    Recommend = []
    for el in sys.argv[2:]:  # salto i primi due elementi
        i = X.index[int(el)]  # -1?
        product_names = list(X.index)
        product_ID = product_names.index(i)
        correlation_product_ID = correlation_matrix[product_ID]
        Recommend = Recommend + list(X.index[correlation_product_ID > 0.5])
        Recommend.remove(i)
        Recommend = list(set(Recommend))
    for num in Recommend:
        print(str(num))

import sys
install("sklearn")
install("numpy")
install("pandas")
install("python-csv")
install("mysql-connector")
import csv
import mysql.connector
import pandas as pd
import numpy as np
from sklearn.decomposition import TruncatedSVD


data()
if sys.argv[1] == 0:
    l1()
else:
    l2()




