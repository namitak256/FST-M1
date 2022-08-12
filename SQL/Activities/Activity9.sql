create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select s.salesman_name, c.customer_name from salesman s
left join customers c
on s.salesman_id=c.salesman_id;


select c.customer_name, s.salesman_name, c.grade
from customers c
left join salesman s
on c.salesman_id=s.salesman_id
where c.grade < 300
order by c.grade asc;

select c.customer_id, c.customer_name, c.city, s.salesman_id, s.salesman_name, s.commission
from customers c
inner join salesman s
on c.salesman_id=s.salesman_id
where s.commission > 12;

select o.order_no, o.order_date, o.purchase_amount, c.customer_name, s.salesman_name, s.commission
from customers c
inner join orders o on c.customer_id=o.customer_id
inner join salesman s on c.salesman_id=s.salesman_id;
