INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`name` , `value`) VALUES ('Laptop', 500.00);
INSERT INTO `items` (`name` , `value`) VALUES ('item1', 1.00);
INSERT INTO `orders` (`fk_customers_id`, `order_value`) VALUES (1, 501.00);
INSERT INTO `orders` (`fk_customers_id`, `order_value`) VALUES (1, 0.0);
INSERT INTO `orders` (`fk_customers_id`, `order_value`) VALUES (1, 0.0);
INSERT INTO `orders` (`fk_customers_id`, `order_value`) VALUES (1, 0.0);
INSERT INTO `orders` (`fk_customers_id`, `order_value`) VALUES (1, 0.0);
INSERT INTO `orders_items` (`fk_orders_id`, `fk_items_id`) VALUES (1, 0);