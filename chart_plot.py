
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

tree_sort_data = pd.read_csv('treesort_time_data.csv', header = None, names = ['Size', 'Time'])
bubble_sort_data = pd.read_csv('bubblesort_time_data.csv', header = None, names = ['Size', 'Time'])

x = tree_sort_data['Size'].to_numpy()
y = tree_sort_data['Time'].to_numpy()
z= bubble_sort_data['Time'].to_numpy()

plt.plot(x,y, label = 'Tree Sort')
plt.plot(x,z, label = 'Bubble Sort')
plt.xlabel('Data Size')
plt.ylabel('Sorting Time')
plt.legend()
plt.grid()
plt.show()
