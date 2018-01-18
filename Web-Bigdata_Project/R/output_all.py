# -*- coding: utf-8 -*-

"""
Created on Tue Aug 29 10:30:32 2017
@author: eunsol
"""

#배우1,2,3 좋아요

import re  
import requests
from bs4 import BeautifulSoup

import csv    
import codecs

like_num1 = None
like_num2 = None
like_num3 = None
    
like_num_d = None
like_num_a = None
like_num_w = None
    
ratings = None
ratingCounts = None
like_num = None

f = open('/Users\eunsol\output_all_18.csv', 'w', encoding='utf-8', newline='')
wr = csv.writer(f)  

f2 = codecs.open('/Users\eunsol\output_title_total_18.csv', 'r').readlines()
csvReader = csv.reader(f2)

for i in csvReader:
    serial = i[0]
    #imdb
    url = 'http://www.imdb.com/title/'+serial+'/?ref_=pro_tt_visitcons'
    source_code = requests.get(url)
    plain_text = source_code.text

    soup = BeautifulSoup(plain_text, 'lxml')

    #검색결과 없음
    if soup.h1 is None:
        print('검색결과 없음')

    #영화
    else :
        tp = soup.find(id='type') #영화는 type이 없다.
        if tp is None:    
            
            #평점
            print('평점 :')
            rating = soup.find(itemprop='ratingValue')
                
            if rating is not None:
                ratings = rating.get_text()
                print(ratings)
                
            #평점 남긴 수
            print('평점남긴수 :')
            ratingCount = soup.find(itemprop='ratingCount')
                
            if ratingCount is not None:
                ratingCounts = ratingCount.get_text()
                    
                print(ratingCounts)  
                
            ##좋아요 페이지 이동
            url_m = 'https://www.facebook.com/widgets/like.php?width=280&show_faces=1&layout=standard&href=http%3A%2F%2Fwww.imdb.com%2Ftitle%2F'+serial+'%2F&colorscheme=light'
            
            source_code_m = requests.get(url_m)
            plain_text_m = source_code_m.text
        
            soup_m = BeautifulSoup(plain_text_m, 'lxml')
            #영화 좋아요
            print('영화 좋아요 :')
            fb_m = soup_m.find(id='u_0_3').get_text().split('명')

            #만 곱하기               
            like_m = fb_m[0]                
            if '만' in like_m:
                a = like_m.split('만')
                like_num_m = float(a[0])*10000
                print(like_num_m)
                    
            elif '친구들이 무엇을 좋아하는지 알아보려면 가입하기' in like_m:
                like_num_m = None
                print(like_num_m)
                
            else:
                like_num_m = fb_m[0]
                print(like_num_m)
            
            
            ##감독 페이지 이동
            d_href = soup.find(itemprop='director')

            ##배우 페이지 이동               
            span_tag = soup.find_all(itemprop='actors')
            
            ##작가 페이지 이동
            w_href = soup.find(itemprop='creator')
            
            #감독
            if d_href is not None:
                d_hrefs = d_href.a.get('href')
                
            #감독 시리얼 넘버 d_serial
                pattern_d = re.compile(r'\d\d\d\d\d\d\d')
                d_serial = pattern_d.search(d_hrefs).group()   
                
                d_like = 'https://www.facebook.com/widgets/like.php?width=280&show_faces=1&layout=standard&href=http%3A%2F%2Fwww.imdb.com%2Fname%2Fnm'+str(d_serial)+'%2F&colorscheme=light'
            
                source_code = requests.get(d_like)
                plain_text = source_code.text
        
                soup = BeautifulSoup(plain_text, 'lxml')
                
                print('감독 좋아요 :')
                fbs_d = soup.find(id='u_0_3')
                
                if fbs_d is not None:
                    
                    fb_d = fbs_d.get_text().split('명')
                        #만 곱하기               
                    like_d = fb_d[0]                
                    if '만' in like_d:
                        a = like_d.split('만')
                        like_num_d = float(a[0])*10000
                        print(like_num_d)
                    elif '친구들이 무엇을 좋아하는지 알아보려면 가입하기' in like_d:
                        like_num_d = None
                        print(like_num_d)
                    
                    else:
                        like_num_d = fb_d[0]
                        print(like_num_d)
                        
            #배우            
            if span_tag is not None:
                span_tags = span_tag
                pattern = re.compile(r'\d\d\d\d\d\d\d')
                
                for num in range(0, len(span_tag), +1):
                    type_str_a = str(span_tags[int(num)])
                    search_pat_a = pattern.search(type_str_a).group()
                    #print(search_pat) --- 배우 시리얼넘
                    a_like = 'https://www.facebook.com/widgets/like.php?width=280&show_faces=1&layout=standard&href=http%3A%2F%2Fwww.imdb.com%2Fname%2Fnm'+str(search_pat_a)+'%2F&colorscheme=light'

                    source_code = requests.get(a_like)
                    plain_text = source_code.text
                    soup = BeautifulSoup(plain_text, 'lxml')

                    fbs_a = soup.find(id='u_0_3')
                    if fbs_a is not None:
                        print('배우 좋아요 '+ str(num) +' :')
                        fb_a = fbs_a.get_text().split('명')
    
                        #만 곱하기               
                        like_a = fb_a[0]                
                        if '만' in like_a:
                            a = like_a.split('만')
                            like_num_a = float(a[0])*10000 
                            
                            print(like_num_a)
    
                            if str(num) == '0':
                                like_num1 = like_num_a
                            elif str(num) == '1':
                                like_num2 = like_num_a
                            else:
                                like_num3 = like_num_a
        
                        elif '친구들이 무엇을 좋아하는지 알아보려면 가입하기' in like_a:
    
                            like_num1 = None
                            like_num2 = None
                            like_num3 = None
                            print('0')                            
    
                        else:
                            like_num_a = fb_a[0]
                            print(like_num_a)
    
                            if str(num) == '0':
                                like_num1 = like_num_a
                            elif str(num) == '1':
                                like_num2 = like_num_a
                            else:
                                like_num3 = like_num_a
                                
            #작가
            if w_href is not None:
                w_hrefs = w_href.a.get('href')
            #작가 시리얼 넘버 w_serial
                pattern_w = re.compile(r'\d\d\d\d\d\d\d')
                w_serial = pattern_w.search(w_hrefs).group()
                                
                w_like = 'https://www.facebook.com/widgets/like.php?width=280&show_faces=1&layout=standard&href=http%3A%2F%2Fwww.imdb.com%2Fname%2Fnm'+str(w_serial)+'%2F&colorscheme=light'
                
                source_code_w = requests.get(w_like)
                plain_text_w = source_code_w.text
        
                soup_w = BeautifulSoup(plain_text_w, 'lxml')
                
                print('작가 좋아요 :')
                fbs_w = soup_w.find(id='u_0_3')
                
                if fbs_w is not None:
                    
                    fb_w = fbs_w.get_text().split('명')
                    #만 곱하기               
                    like_w = fb_w[0]                
                    if '만' in like_w:
                        a = like_w.split('만')
                        like_num_w = float(a[0])*10000
                        print(like_num_w)
                    elif '친구들이 무엇을 좋아하는지 알아보려면 가입하기' in like_w:
                        like_num_w = None
                        print('0')
                    
                    else:
                        like_num_w = fb_w[0]
                        print(like_num_w)
                                
                    
                                
            #영화아닌 컨텐츠 
            else:
                print("영화아닌 컨텐츠 ")
    
    print('<<'+str(serial)+'>>')
    print('==============')
    
    wr.writerow([serial,like_num1,like_num2,like_num3,like_num_d,ratings,ratingCounts,like_num_m,like_num_w])
    
    like_num1 = None
    like_num2 = None
    like_num3 = None
    
    like_num_d = None
    like_num_a = None
    like_num_w = None
    
    ratings = None
    ratingCounts = None
    like_num = None

f.close()
f2.close()
