# Flight-Network
You will implement a directed graph to represent a flight network and perform various operations on it. The flight network consists of city as nodes and flight routes as directed edges. You should read flight network data from the txt file. Also, txt file has the following structures:

Ankara,Istanbul

Istanbul,Izmır

Ankara,Eskisehir

Ankara,Amsterdam

Istanbul,Amsterdam

Amsterdam,Paris

Amsterdam,Konya

Konya,Eskisehir

Berlin,Ankara

Paris,Berlin

Each line represent flight from source city to destination city, e.g. the first line means that there is a flight from Ankara to Istanbul. 

Your purpose is to find all city that can be reached from a given city within a certain number of stops (hops). Then, you should print that city with existing hops in ascending order.
