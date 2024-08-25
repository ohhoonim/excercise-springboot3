drop table if exists product;
create table if not exists product (
   id varchar(255),
   name varchar(255),
   unit_type varchar(255),
   price INT
);
create table if not exists order_line_table (
   id serial primary key,
   order_date TIMESTAMP,
   product_id VARCHAR(255),
   product_name VARCHAR(255),
   product_unit_type VARCHAR(255),
   product_price INT,
   qty int
);