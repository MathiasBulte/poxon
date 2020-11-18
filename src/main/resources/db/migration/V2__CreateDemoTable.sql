create table demo
(
	id varchar(36) not null
		constraint demo_pkey
			primary key,
	input_value varchar(255) not null
);