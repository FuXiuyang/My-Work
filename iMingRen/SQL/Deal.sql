Create table deal(
	id int not null auto_increment,
	deal_time datetime not null,
	sum decimal(3,2) not null,
	user_account varchar(15) not null,
	vip_account varchar(15) not null,
	vip_password varchar(15) not null,
	primary key (id)
);