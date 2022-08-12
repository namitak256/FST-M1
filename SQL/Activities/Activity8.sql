select customer_id, max(purchase_amount) as m from orders
group by customer_id;

select customer_id, max(purchase_amount) from orders
where order_date='17-AUG-12'
group by customer_id;

select customer_id, order_date, max(purchase_amount) as mp from orders
having max(purchase_amount) in (2030,3450, 5760, 6000)
group by customer_id, order_date;