select sum(purchase_amount) sum_purchase from orders;

select avg(purchase_amount) avg_purchase from orders;

select max(purchase_amount) max_purchase from orders;

select min(purchase_amount) min_purchase from orders;

select  count(distinct salesman_id) as countOfSalesman from orders;