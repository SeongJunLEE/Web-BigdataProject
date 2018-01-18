# -*- coding: utf-8 -*-
"""
Created on Mon Aug 28 15:21:07 2017

@author: KODB
"""

import requests
from bs4 import BeautifulSoup
import csv 

f = open('output13.csv', 'w', encoding='utf-8', newline='')
wr = csv.writer(f)

for n in range(4917437, 4100000, -1):
    url='https://pro-labs.imdb.com/title/tt'+str(n)+'/'

    source_code = requests.get(url)
    plain_text = source_code.text
    soup = BeautifulSoup(plain_text, 'lxml')

    # 마지막에 Not None
    if soup.h1 is None:
        print('tt'+str(n))
        print("null")

    else:
        print('tt'+str(n))
        tp =soup.find(id='type')

        if tp is None:
            #제목
            mname=soup.h1.span.get_text()
            print(mname)
            wr.writerow(["tt"+str(n), mname])

f.close() 
