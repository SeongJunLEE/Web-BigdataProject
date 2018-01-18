create table director(
	d_id number(5) not null,
	d_name varchar2(50) not null,
	d_like number(10) not null,
	primary key (d_id)
);

create table actor(
	a_id number(10) not null,
	a_name varchar2(50) not null,
	a_like number(10) not null,
	a_rank number(10) not null,
	primary key (a_id)
);


create table genre(
	g_id number(5) not null,
	g_name varchar2(50) not null,
	primary key (g_id)
);



create table movie(
	m_id number(20) not null,
	m_name varchar2(50) not null,
	m_time number(5) not null,
	m_budget number(10) not null,
	m_date number(5) not null,
	m_like number(10) not null,
	m_ratings number(5, 1) not null,
	m_pred_ratings number(5, 2) not null,
 	m_ratecount number(10) not null,
	d_id number(5) not null,
	a1_id number(10) not null,
	a2_id number(10) not null,
	a3_id number(10) not null,
	g_id number(5) not null,
	primary key (m_id),
	foreign key (d_id) references director,
	foreign key (a1_id) references actor,
	foreign key (a2_id) references actor,
	foreign key (a3_id) references actor,
	foreign key (g_id) references genre
);

create table recommendation(
	m_id number(20) not null,
	r1_id number(20),
	r2_id number(20),
	r3_id number(20),
	foreign key (m_id) references movie
);

 
create table customer(
	c_id varchar2(20) not null,
	c_password varchar2(50) not null,
	c_name varchar2(20) not null,
 	gender varchar2(1) not null,
	birth date not null,
	c_phone varchar2(20) not null,
	join_date timestamp not null,
	primary key (c_id)
);

create table staff(
	s_id varchar2(20) not null,
	s_password varchar2(20) not null,
	s_name varchar2(20) not null,
	primary key (s_id)
);

create table search(
	search_id number(20) not null,
	search_contents varchar(50) not null,
	search_date date not null,
	c_id varchar(20) not null,
	primary key (search_id),
	foreign key (c_id) references customer
);

